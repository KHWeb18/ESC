<template>
  <div class="nav-container">
    <v-app-bar app :color="bg" elevation="0">
      <v-container class="pa-0 fill-height">

        <!-- logo -->
        <v-toolbar-title class="logoContainer">
          <router-link to="/">
            <span :class="logo">EVS</span>
          </router-link>
        </v-toolbar-title>

        <v-toolbar-items :class="menus" class="hidden-sm-and-down">
          <span @click="$router.push('/evinfo')">전기차 정보</span>
          <span @click="$router.push('/freeboardListPage')">게시판</span>
          <span @click="$router.push('/apiTest')">api실험</span>
          <span @click="$router.push('/noticeListPage')">공지사항/건의</span>
          <span v-if="this.$store.state.auth =='관리자'" @click="$router.push('/administratorPage')">관리자페이지</span>
          <span>원하는거 추가</span>
        </v-toolbar-items>

        <v-spacer></v-spacer>
        <v-toolbar-items class="memberItems">

          <div v-if="!LoginCheck">
            <router-link to="/loginPage">
              <span :class="text" class="hidden-sm-and-down">로그인</span>
            </router-link>
            <router-link to="signUpPage">
              <span :class="text" class="hidden-sm-and-down">회원가입</span>
            </router-link>
          </div>

          <header-member-menu></header-member-menu>

        </v-toolbar-items>

        <!-- hamburger icon -->
<!--        <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" :class="hamburger">-->
<!--        </v-app-bar-nav-icon>-->

        <!-- nav-drawer if mobile -->
        <nav-drawer-component></nav-drawer-component>

      </v-container>


    </v-app-bar>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import NavDrawerComponent from "./NavDrawerComponent";
import HeaderMemberMenu from "./header/HeaderMemberMenu";

export default {
  name: "HeaderComponent",
  components: {HeaderMemberMenu, NavDrawerComponent},
  mounted() {
    window.onscroll = () => {
      this.changeColor();
    };
  },
  computed: {
    ...mapState(['isLogin', 'session']),
    LoginCheck(){
      return this.isLogin
    }
  },
  data() {
    return {
      bg: 'transparent',
      logo: 'logo',
      text: 'text',
      menus: 'menus',
      hamburger: 'hamburger hidden-md-and-up black--text',

    }
  },
  methods: {
    ...mapActions(['setIsLogin', 'logout']),
    changeColor() {
      if (
          document.body.scrollTop > 50 ||
          document.documentElement.scrollTop > 50
      ) {
        this.bg = 'blue-grey darken-4'
        this.logo = 'logoScroll'
        this.text = 'textScroll'
        this.menus = 'menusScroll'
        this.hamburger = 'hamburger hidden-md-and-up white--text'
      } else {
        this.bg = 'transparent';
        this.logo = 'logo'
        this.text = 'text'
        this.menus = 'menus'
        this.hamburger = 'hamburger hidden-md-and-up black--text'
      }
    },
    closeNav(value){
      this.nav_drawer = value
    }
  },
}
</script>

<style scoped>

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Do Hyeon', sans-serif;
  user-select: none;
}

a{
  text-decoration: none;
}

.logoContainer{
  margin-top: -10px;
}

.logo{
  font-size: 2.5em;
  color: black;
}
.logoScroll{
  font-size: 2.5em;
  color: white;
}

.menus{
  margin-top: 10px;
  margin-left: 10%;
  font-size: 1.8em;
  cursor: pointer;
}
.menus:hover{
  color: grey;
}

.menusScroll{
  margin-top: 10px;
  margin-left: 10%;
  font-size: 1.8em;
  color: white;
  cursor: pointer;
}
.menusScroll:hover{
  color: grey;
}

.menus span{
  padding: 0 30px
}
.menusScroll span{
  padding: 0 30px
}
.menus span:hover{
  color: black;
}
.menusScroll span:hover{
  color: white;
}

.memberItems{
  margin-top: -8px;
  margin-right: -25px;
}

.text{
  font-size: 1em;
  margin-left: 25px;
  color: black;
}
.textScroll{
  font-size: 1em;
  margin-left: 25px;
  color: white;
}
.myPage{
  margin: 0 0 0 20px;
}
</style>
