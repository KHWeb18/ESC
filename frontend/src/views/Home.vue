<template>
  <div class="home">
    <div id="header">
      <router-link
        :to="{ name: 'MainHomePage' }"
        class="nav-link"
        active-class="active">
        메인홈
      </router-link>
      <router-link
        :to="{ name: 'FreeBoardListPage' }"
        class="nav-link"
        active-class="active">
        게시판
      </router-link>
        <router-link
        :to="{ name: 'IsMyPage' }"
        class="nav-link"
        active-class="active">
        마이페이지
      </router-link>
        <router-link
        :to="{ name: 'test' }"
        class="nav-link"
        active-class="active">
        테스트
      </router-link>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Home',
    methods:{
      check(){
        console.log(this.$cookies.get('user'))
        console.log(this.$store.state.session)
        console.log(this.$store.state.isLogin)
      }
    },

    components: {}
  }
</script>
