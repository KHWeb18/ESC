<template>
<v-container style="max-width: 550px">
   <form @submit.prevent="OnSubmit">
             <h3>회원가입</h3>
            <v-text-field  :rules="nameRules"  required v-model="name"
            label="회원이름" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
            <v-text-field    v-model="memberId"
            label="아이디" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
             <v-text-field    :rules="passwordRules" required  v-model="memberPw"
            label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
            <v-text-field    :rules="memberPwCheck" required  
            label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
              <v-text-field :rules="emailRules" required v-model="email"
            label="이메일" type="text" prepend-icon="mdi-email-multiple" flat solo>
            </v-text-field>
            <!-- <v-btn @click="showpost" height="20px">우편</v-btn>
            <v-text-field :rules="emailRules" required v-model="address"
            label="주소" type="text" prepend-icon="mdi-email-multiple" flat solo>
            </v-text-field> -->
            <v-btn @click="emailChkCoin=1, emailsend(email)" v-if="emailChkCoin ==0" height="20px">이메일인증코드발송</v-btn>
            <v-btn @click="emailsend(email)" v-if="emailChkCoin ==1" height="20px">코드가오지않으셧나요?/재발송</v-btn>
            <v-text-field v-if="emailChkCoin ==1" :rules="emailchkRules" required v-model="AuthenticationNum"
            label="인증번호" type="text" prepend-icon="mdi-email-multiple" flat solo>
            </v-text-field>
            <v-text-field  required v-model="memberBirthDay"
             type="Date" prepend-icon="mdi-cake" flat solo>
            </v-text-field>
            <v-select :items="SelectCarList"  v-model="memberCar" label="보유차종선택"> </v-select>  
            <v-btn  type="submit">가입</v-btn>
   </form>
</v-container>
</template>

<script>
import axios from 'axios'
import { mapState} from 'vuex'
export default {
    name: 'SignupPageForm',
    props: {
        memberList: {
            type:Array
        }
    },
    data() {
        return {
            address: '',
            AuthenticationNum: '',
            randumNum: 0,
            emailChkCoin: 0,
            memberId: '',
            memberPw: '',
            memberBirthDay: '',
            name: '',
            email: '',
            memberCar: '',
            memberPwCheck: [v => this.memberPw ===v || '비밀번호가 일치하지않습니다' ],
            SelectCarList: [
                {text: '전기차',value: '전기차'},
                {text: '일반차',value: '일반차'},
                {text: '하이브리드차',value: '하이브리드차'},
                {text: '없음',value: '없음'} ],
            loginAlert: '보유차종을 선택하여주십시오.'               
            
        }
    },
    methods: {
        chk(){
            console.log(this.address)
        },
        OnSubmit() {
            if(this.AuthenticationNum == this.randumNum){
                const {memberId, memberPw , name, email, memberCar, memberBirthDay} = this
            let coin = null;
                for(var i = 0 ; i < this.memberList.length ; i ++){

                      if(this.memberList[i].memberId === this.memberId){
                    alert('등록된 아이디가있습니다.')
                    return coin = 1;
                                                                 }
                
                                                                }
              if(coin ==null){                                                  
            if(this.memberCar !=''){this.$emit('submit', {memberId, memberPw , name, email, memberCar,memberBirthDay})}
            else{ alert(this.loginAlert)}
                this.$router.push({name: 'MainHomePage'})
              }
            }
            else{
                alert("인증번호가 일치하지않습니다.")
            }
            
        },
        emailsend(email) {
            this.randumNum =  Math.floor(Math.random() * 99999) +1
            let randomNum2 = this.randumNum
            console.log(email)
            axios.post('http://localhost:5000/sendNaverEamil',{randomNum2})
            .then( (res) =>{
                alert("인증번호를 보냈습니다."+res.data)
            }).catch(e=>{alert(e.response.data.message)})
            
        },
        // showpost(){ new window.daum.Postcode( {oncomplete:function(data){ 

        // } }).open();
        // },
    setAddress(data){
        this.address  = data.address
    }
    },
    
    computed: {
        ...mapState(['emailRules','nameRules','passwordRules','emailchkRules'])
    },
    mounted(){
        
    }
    
}
</script>


