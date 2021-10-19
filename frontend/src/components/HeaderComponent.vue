<template>
  <div class="nav-container">
    <v-app-bar app :color="bg" elevation="0">
      <!-- logo -->
      <v-toolbar-title>
        <router-link to="/">
          <span :class="logo">EVS</span>
        </router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <v-toolbar-items class="items">
        <router-link to="/">
          <span :class="text" class="hidden-sm-and-down">로그인</span>
        </router-link>
        <router-link to="signUpPage">
        <span :class="text" class="hidden-sm-and-down">회원가입</span>
      </router-link>
      </v-toolbar-items>

      <!-- hamburger icon -->
      <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer" class="hidden-md-and-up ml-auto">
      </v-app-bar-nav-icon>

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
      } else {
        this.bg = 'transparent';
        this.logo = 'logo'
        this.text = 'text'

      }
    },
  },
}
</script>

<style scoped>

*{
  font-family: 'Do Hyeon', sans-serif;
}

a{
  text-decoration: none;
}

.logo{
  font-size: 2em;
  color: black;
}
.logoScroll{
  font-size: 2em;
  color: white;
}

.items{
  margin-top: 20px;
}

.text{
  font-size: 1em;
  margin-left: 25px;
  margin-right: 10px;
  color: black;
}
.textScroll{
  font-size: 1em;
  margin-left: 25px;
  margin-right: 10px;
  color: white;
}
</style>
