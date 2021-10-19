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
          <span>전기차 소개</span>
          <span>구매 가이드</span>
          <span>참여마당</span>
        </v-toolbar-items>

        <v-spacer></v-spacer>

        <v-toolbar-items class="memberItems">
          <router-link to="/">
            <span :class="text" class="hidden-sm-and-down">로그인</span>
          </router-link>
          <router-link to="signUpPage">
            <span :class="text" class="hidden-sm-and-down">회원가입</span>
          </router-link>
        </v-toolbar-items>

        <!-- hamburger icon -->
        <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" :class="hamburger">
        </v-app-bar-nav-icon>
      </v-container>


    </v-app-bar>
  </div>
</template>

<script>
export default {
  name: "HeaderComponent",
  mounted() {
    window.onscroll = () => {
      this.changeColor();
    };
  },
  data() {
    return {
      bg: 'transparent',
      logo: 'logo',
      text: 'text',
      menus: 'menus',
      hamburger: 'hamburger hidden-md-and-up black--text',
      nav_drawer: false,
    }
  },
  methods: {
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
  },
}
</script>

<style scoped>

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Do Hyeon', sans-serif;
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

.menusScroll{
  margin-top: 10px;
  margin-left: 10%;
  font-size: 1.8em;
  color: white;
  cursor: pointer;
}

.menus span{
  padding: 0 30px
}
.menusScroll span{
  padding: 0 30px

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

.hamburger{
  margin-top: -15px;
}
</style>
