<template>
    <div>
        <v-container>
        <p>아이디찾기</p>
            <v-stepper max-width="700px" v-model="e1">
                <v-stepper-header>
                    <v-stepper-step :complete="e1 > 1" step="1">이메일확인</v-stepper-step>
                    <v-divider></v-divider>
                <v-stepper-step :complete="e1 > 2" step="2">아이디확인</v-stepper-step>
                    <v-divider></v-divider>
                </v-stepper-header>

            <v-stepper-items>
                <v-stepper-content step="1">
                    <p>이메일입력</p>
                    <input v-model="email"/>
                    <v-btn @click="MatchedEmail"><v-icon>mdi-arrow-right-thick</v-icon></v-btn>
                </v-stepper-content>

                <v-stepper-content step="2">
                <p>해당이메일로 가입된 아이디 입니다.</p>
                <p>{{ userid }}</p>
                <v-btn route :to="{name: 'FindByPwPage' }">비밀번호 찾으러가기</v-btn>
                </v-stepper-content>
            </v-stepper-items>
            </v-stepper>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name:'FindByIdPage',
    data(){
        return{
            email: '',
            coin: 0,
            userid: [],
            e1: 1,
        }
    },
    methods:{
        MatchedEmail(){
            const {email} = this
            axios.post('https://evsbackend.herokuapp.com/member/FindById',{email})
            .then( (res) =>{
                    this.userid = res.data
                    if(res.data == ''){
                        alert('등록된이메일이 없습니다.')
                    }else{
                        this.e1 = 2
                    }
            })
        },
        check(){
            console.log(this.userid)
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
p{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 2.5em;
}
li{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 2.5em;
}
</style>
