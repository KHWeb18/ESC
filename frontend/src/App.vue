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
export default {
  name: 'App',
  components: {
    HeaderComponent,
    footerComponent
  },
  data: () => ({
    //
  }),
};
</script>
