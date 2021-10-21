<template>
<div>
  <login-page-form @submit="onSubmit" />

</div>
</template>

<!--  <button v-on:click="login">로그인</button>
  <a href="/signUp">가입하기</a> -->

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
import LoginPageForm from '../../components/member/LoginPageForm.vue'
import {mapActions} from "vuex";

Vue.use(cookies)
  export default {
   name: 'LoginPage',
    components: {
        LoginPageForm
    },
      methods: {
     ...mapActions(['cookieToSession', 'setIsLogin']),
    onSubmit (payload) {
            if (this.$store.state.session === null) {
                const { id, pw } = payload
                axios.post('http://localhost:7777/login', { memberId: id, password: pw, auth: null })
                        .then(res => {
                            if (res.data != "") {
                              alert('로그인 성공! - ' + res.data.auth)
                              this.$cookies.set("user", res.data, '1h')
                              this.cookieToSession()
                              this.setIsLogin()
                              this.$router.push('/')

                            } else {
                              alert('로그인 실패! - ' + res.data)
                              this.$router.push('/')
                            }
                            
    })
  
  
     }
    }
   }
  }
  

</script>
