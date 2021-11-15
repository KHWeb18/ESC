<template>
  <div class="nav-container">
    <v-app-bar absolute app color="white" hide-on-scroll prominent elevation="0">
      <v-container class="pa-0 fill-height">

        <span class="topTitle hidden-md-and-down"></span>

        <router-link class="logo hidden-md-and-down" to="/" tag="span">
        </router-link>

        <router-link class="logoSmall hidden-lg-and-up hidden-sm-and-down" to="/" tag="span">
        </router-link>

        <router-link class="logoMini hidden-md-and-up" to="/" tag="span">
        </router-link>

        <v-toolbar-items class="hidden-md-and-down menus">
          <span @click="$router.push('/evinfo')">전기차 정보</span>
          <span @click="$router.push('/freeboardListPage')">게시판</span>
          <span @click="$router.push('/apiTest')">api실험</span>
          <span @click="$router.push('/noticeListPage')">공지사항/건의</span>
          <span  @click="$router.push('/charingSearchServiceBoardList')">충전소찾기</span>
          <span>원하는거 추가</span>
          <span v-if="this.$store.state.auth =='관리자'" @click="$router.push('/administratorPage')">관리자페이지</span>
        </v-toolbar-items>

        <v-toolbar-items class="hidden-sm-and-down hidden-lg-only menusSmall">
          <span @click="$router.push('/evinfo')">전기차 정보</span>
          <span @click="$router.push('/freeboardListPage')">게시판</span>
          <span @click="$router.push('/apiTest')">api실험</span> 
          <span @click="$router.push('/noticeListPage')">공지사항/건의</span>
          <span v-if="this.$store.state.auth =='관리자'" @click="$router.push('/memberManagement')">관리자페이지</span>
          <span  @click="$router.push('/charingSearchServiceBoardList')">충전소찾기</span>
          <span  @click="$router.push('/parkingSearchServiceList')">주차장찾기</span>
          <span>원하는거 추가</span>
        </v-toolbar-items>

        <v-spacer></v-spacer>
        <v-toolbar-items class="memberItems">

          <div v-if="!LoginCheck" class="memberContainer hidden-sm-and-down">
            <span class="text" @click="$router.push('/loginPage')">로그인</span>
            <span class="text" @click="$router.push('/signUpPage')">회원가입</span>
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
  },
  computed: {
    ...mapState(['isLogin', 'session']),
    LoginCheck(){
      return this.isLogin
    }
  },
  data() {
    return {

    }
  },
  methods: {
    ...mapActions(['setIsLogin', 'logout']),
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

.topTitle{
  background-image: url("https://user-images.githubusercontent.com/83811729/141649050-85f58ee1-85d7-42cc-a276-1da6fc392508.png");
  background-size: contain;
  position: absolute;
  width: 300px;
  height: 100%;
  top: 20px;
  left: 41%;
  opacity: 0.9;
}

.logo{
  position: absolute;
  top: 12px;
  left: 3px;
  cursor: pointer;
  background-image: url("https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/logo/evslogo2.png");
  background-size: contain;
  width: 160px;
  height: 100%;
}

.logoSmall{
  position: absolute;
  top: 3px;
  left: 42%;
  cursor: pointer;
  background-image: url("https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/logo/evslogo2.png");
  background-size: contain;
  width: 135px;
  height: 100%;
}

.logoMini{
  position: absolute;
  top: 10px;
  left: 39%;
  cursor: pointer;
  background-image: url("https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/logo/evslogo2.png");
  background-size: contain;
  width: 165px;
  height: 100%;
}

.menus{
  position: relative;
  margin-left: 85px;
  top: 40px;
  max-height: 50px;
  font-size: 1.12em;
  cursor: pointer;
  z-index: 2;
}
.menus:hover{
  color: #cfd6da;
}

.menus span{
  padding: 0 30px
}

.menus span:hover{
  color: black;
}

.menusSmall{
  position: relative;
  top: 45px;
  max-height: 35px;
  font-size: 1em;
  cursor: pointer;
}
.menusSmall:hover{
  color: #cfd6da;
}

.menusSmall span{
  padding: 0 20px 0 0;
  margin: 0 10px 0 0;
}

.menusSmall span:hover{
  color: black;
}


.memberItems{
  position: absolute;
  top: 10px;
  right: 6%;
}

.memberContainer{
  font-size: 0.8em;
}
.memberContainer:hover{
  color: #cfd6da;
}
.memberContainer span:hover{
  color: black;
}

.text{
  font-size: 1em;
  margin-left: 25px;
  cursor: pointer;
}

.myPage{
  margin: 0 0 0 20px;
}
</style>
