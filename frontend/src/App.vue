<template>
  <v-app>
    <HeaderComponent></HeaderComponent>
    <v-main>
      <router-view/>
    </v-main>
    <footer-component/>
  </v-app>
</template>

<script>
import footerComponent from './components/footer/footerComponent.vue'
import HeaderComponent from "./components/HeaderComponent";
import {mapActions} from "vuex";
export default {
  name: 'App',
  components: {
    HeaderComponent,
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
