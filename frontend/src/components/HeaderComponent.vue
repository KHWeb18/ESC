<template>
  <div class="nav-container">
    <v-app-bar app :color="bg" class="bar" elevation="0">
      <v-toolbar-title>
        <router-link to="/">
          <span :class="logo">EVS</span>
        </router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-heart</v-icon>
      </v-btn>
      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
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
    }
  },
  methods: {
    changeColor() {
      if (
          document.body.scrollTop > 100 ||
          document.documentElement.scrollTop > 100
      ) {
        this.bg = 'blue-grey darken-4';
        this.logo = 'logoScroll'
      } else {
        this.bg = 'transparent';
        this.logo = 'logo'
      }
    },
  },
}
</script>

<style scoped>
a{
  text-decoration: none;
}

.logo{
  font-family: 'Do Hyeon', sans-serif;
  font-size: 2em;
  color: black;
}

.logoScroll{
  font-family: 'Do Hyeon', sans-serif;
  font-size: 2em;
  color: white;
}
</style>
