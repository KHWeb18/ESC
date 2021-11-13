<template>
  <div class="nav-container">
    <v-app-bar absolute app color="white" hide-on-scroll prominent elevation="0">
      <v-container class="pa-0 fill-height">

          <router-link class="logo" to="/" tag="span">
          </router-link>

        <v-toolbar-items class="hidden-md-and-down menus">
          <span @click="$router.push('/evinfo')">전기차 정보</span>
          <span @click="$router.push('/freeboardListPage')">게시판</span>
          <span @click="$router.push('/apiTest')">api실험</span>
          <span @click="$router.push('/noticeListPage')">공지사항/건의</span>
          <span v-if="this.$store.state.auth =='관리자'" @click="$router.push('/administratorPage')">관리자페이지</span>
          <span  @click="$router.push('/charingSearchServiceBoardList')">충전소찾기</span>
          <span>원하는거 추가</span>
        </v-toolbar-items>

        <v-toolbar-items class="hidden-sm-and-down hidden-lg-only menusSmall">
          <span @click="$router.push('/evinfo')">전기차 정보</span>
          <span @click="$router.push('/freeboardListPage')">게시판</span>
          <span @click="$router.push('/apiTest')">api실험</span>
          <span @click="$router.push('/noticeListPage')">공지사항/건의</span>
          <span v-if="this.$store.state.auth =='관리자'" @click="$router.push('/administratorPage')">관리자페이지</span>
          <span  @click="$router.push('/charingSearchServiceBoardList')">충전소찾기</span>
          <span>원하는거 추가</span>
        </v-toolbar-items>

        <v-spacer></v-spacer>
        <v-toolbar-items class="memberItems">

          <div v-if="!LoginCheck" class="memberContainer hidden-sm-and-down">
            <router-link to="/loginPage">
              <span class="text">로그인</span>
            </router-link>
            <router-link to="signUpPage">
              <span class="text">회원가입</span>
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
      } else {
        this.bg = 'transparent';
        this.logo = 'logo'
        this.text = 'text'
        this.menus = 'menus'
      }
    },
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

.logo{
  position: absolute;
  top: 3px;
  left: 42%;
  cursor: pointer;
  background-image: url("https://user-images.githubusercontent.com/83811729/141101367-6f78239a-c8f0-4530-a6d9-7648d6d961a9.png");
  background-size: contain;
  width: 220px;
  height: 100%;
}

.menus{
  margin-top: 80px;
  font-size: 1.2em;
  cursor: pointer;
}
.menus:hover{
  color: grey;
}

.menus span{
  padding: 0 30px
}

.menus span:hover{
  color: black;
}

.menusSmall{
  margin-top: 80px;
  font-size: 1.1em;
  cursor: pointer;
}
.menusSmall:hover{
  color: grey;
}

.menusSmall span{
  padding: 0 10px 0 0;
  margin: 0 30px 0 0;
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
