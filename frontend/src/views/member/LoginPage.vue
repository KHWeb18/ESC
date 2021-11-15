<template>
  <div>
    <login-page-form v-if="session ==null" @submit="OnSubmit"/>
    <p v-else-if="session !=null"> 환영합니다 여기는 EVS입니다</p>
    <v-btn @click="chk()">확인</v-btn>
    {{session}}
  </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
import LoginPageForm from '../../components/member/LoginPageForm.vue'
import {mapActions, mapState} from "vuex";

Vue.use(cookies)
export default {
  components: { LoginPageForm },
  name: 'LoginPage',
  computed: {
    ...mapState(["isLogin", "session","auth"])
  },
  methods:{
    ...mapActions(['cookieToSession', 'setIsLogin','setAuth']),
    OnSubmit(payload){
      //console.log(payload)
      const {memberId , memberPw} = payload
      axios.post('http://localhost:7777/member/login', {memberId , memberPw})
          .then( (res) =>{
            console.log(res.data.memberNo)
            if(res.data.status =="정지"){
              alert("정지된회원입니다.")
              
            }else{
              if(res.data.memberId!= null){
              alert('로그인되었습니다.')
              this.res = res.data
              this.$cookies.set("user", res.data, '1h')
              this.$cookies.set("userNo", res.data.memberNo, '1h')
              this.cookieToSession()
              this.setIsLogin()
              
            }else{
              alert('비밀번호가 틀렸습니다.')
            }
            axios.post(`http://localhost:7777/member/getAuth/${this.$store.state.loginMemberNo}`)
            .then( (res) =>{
              if(res.data ==""){
                const user  = "일반유저"
                this.$cookies.set("userAuth",user,'1h' )
                this.setAuth()
              }
              else{
                this.$cookies.set("userAuth", res.data, '1h')
                this.setAuth()
              }
              
            })
            }
            
          })
    },
    chk(){
      console.log("쿠키값"+this.$cookies.get('userAuth'))
      console.log("스토어에저장된  auth값"+this.$store.state.auth)
    }
  },
  data() {
    return{
      res: '',
      haha: 'sdddddd',
    }
  },

}
</script>
