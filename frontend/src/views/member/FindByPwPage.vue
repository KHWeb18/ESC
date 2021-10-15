<template>
    <div>
        <v-container >
            <p>비밀번호찾기</p>
            <v-stepper max-width="700px" v-model="e1">
                <v-stepper-header>
                    <v-stepper-step :complete="e1 > 1" step="1">아이디 확인</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step :complete="e1 > 2" step="2">생년월일 확인</v-stepper-step>
                    <v-divider></v-divider>
                    <v-stepper-step step="3">비밀번호 변경</v-stepper-step>
                    <v-divider></v-divider>
                </v-stepper-header>

                <v-stepper-items>
                    <v-stepper-content step="1">
                    <p>아이디입력</p>
                    <input v-if="coin ==0" v-model="memberId"/>
                    <v-btn @click="OnSubmit"><v-icon>mdi-arrow-right-thick</v-icon></v-btn>
                    <router-link :to="{name: 'FindByIdPage'}">아이디가기억나지않으세요?</router-link>
                </v-stepper-content>

                    <v-stepper-content step="2">
                        <p>생년월일입력</p>
                        <input style="width:350px" type="date" v-model="maybeBirthday"/><br>
                        <v-btn @click="idMatchedBirthday"><v-icon>mdi-arrow-right-thick</v-icon></v-btn>
                    </v-stepper-content>

                <v-stepper-content step="3">
                    <p>비밀번호 재설정</p>
                    <v-text-field  type="password" v-model="memberPw" :rules="passwordRules"></v-text-field>
                    <v-text-field type="password" :rules="passwordCheck"></v-text-field>
                <v-btn @click="PasswordReset" ><v-icon>mdi-arrow-right-thick</v-icon></v-btn>
                </v-stepper-content>
                </v-stepper-items>
            </v-stepper>
  </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
     computed:{
         ...mapState(['passwordRules'])
     },
     data() {
            return{
               
                memberId: '',
                coin: 0,
                name: '',
                memberNo: null,
                memberBirthDay: '',
                regDate: '',
                email: '',
                maybeBirthday: '',
                memberPw: '',
                passwordCheck: [ v => this.memberPw ===v || '비밀번호가 일치하지않습니다' ],
                e1: 1,

                }
            },
    name: 'FindByPasswordPage',
    methods:{
            OnSubmit(){
                    const {memberId} =this
                    axios.post('http://localhost:7777/member/FindBymemberImp',{memberId})
                    .then((res)=>{
                        console.log(res.data)
                        if(res.data ==''){
                            alert('등록된아이디가없습니다.')
                            this.memberNo = null
                        }
                        else{
                            this.coin = 1
                            this.memberNo = res.data.memberNo
                            this.memberId = res.data.memberId
                            this.memberCar = res.data.memberCar
                            this.regDate = res.data.regDate
                            this.email = res.data.email
                            this.memberBirthDay = res.data.memberBirthDay
                            this.name = res.data.name
                            this.e1 = 2
                        }
                    })
            },

            idMatchedBirthday(){
               const {memberId,maybeBirthday} = this
               axios.post('http://localhost:7777/member/IdMatchedBirthday/',{memberId,maybeBirthday})
               .then( (res) => {
                   if(res.data == true){
                       this.e1 = 3
                                      }
                   else      {
                       alert('생년월일이 일치하지않습니다.')
                            }
                  }) 
            },

            PasswordReset(){

                    const {memberNo, memberId, name, memberBirthDay,email,memberPw,regDate,memberCar } = this
                    axios.post('http://localhost:7777/member/ModifyPassword/',{memberNo, memberId, name, memberBirthDay,email,memberPw,regDate,memberCar})
                    .then( () =>{
                        alert('비밀번호가변경되었습니다')
                        this.$router.go()
                    })

            }
            
    },
    
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
p{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 2.5em;
}
</style>