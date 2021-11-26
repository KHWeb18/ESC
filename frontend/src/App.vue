<template>
  <v-app>
    <MainHeader/>
    <v-main>
      <router-view/>
    </v-main>
    <footer-component/>
  </v-app>
</template>

<script>
import footerComponent from './components/footer/footerComponent.vue'
import {mapActions} from "vuex";
import MainHeader from "./components/MainHeader";
export default {
  name: 'App',
  components: {
    MainHeader,
    footerComponent
  },
  data: () => ({
    //
  }),
  mounted() {
    this.setIsLogin()
    this.cookieToSession()
    this.setAuth()
    
  },
  methods:{
    ...mapActions(['cookieToSession', 'setIsLogin',"setAuth",])
  }
};
</script>

<style>

</style>
