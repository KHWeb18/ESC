<template>
  <div>
    <login-page-form v-if="session ==null" @submit="OnSubmit"/>
    <p v-else-if="session !=null"> 환영합니다 여기는 EVS입니다</p>

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
    ...mapState(["isLogin", "session"])
  },
  methods:{
    ...mapActions(['cookieToSession', 'setIsLogin']),
    OnSubmit(payload){
      //console.log(payload)
      const {memberId , memberPw} = payload
      axios.post('http://localhost:7777/member/login', {memberId , memberPw})
          .then( (res) =>{
            console.log(res.data)
            if(res.data.memberId!= null){
              alert('로그인되었습니다.')
              this.res = res.data
              this.$cookies.set("user", res.data, '1h')
              this.$cookies.set("userNo", res.data, '1h')
              this.cookieToSession()
              this.setIsLogin()
              this.$router.push("/")
            }else{
              alert('비밀번호가 틀렸습니다.')
            }
          })
    },
  },
  data() {
    return{
      res: '',
    }
  }
}
</script>
