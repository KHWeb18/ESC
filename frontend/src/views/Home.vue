<template>
  <div class="home">
    <div id="header">
                        <router-link
        :to="{ name: 'MainHomePage' }"
        class="nav-link"
        active-class="active"
      >
        메인홈
      </router-link>
      <v-content>
        <div class="d-flex flex-wrap justify-center" width="900">
          <img src="https://picsum.photos/300/300"/>
          <img src="https://picsum.photos/600/300"/>
          <img src="https://picsum.photos/700/300"/>
          <img src="https://picsum.photos/200/300"/>
          <img src="https://picsum.photos/400/300"/>
          <img src="https://picsum.photos/500/300"/>
          <img src="https://picsum.photos/300/300"/>
          <img src="https://picsum.photos/600/300"/>
          <img src="https://picsum.photos/700/300"/>
          <img src="https://picsum.photos/200/300"/>
          <img src="https://picsum.photos/400/300"/>
          <img src="https://picsum.photos/500/300"/>
        </div>
      </v-content>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Home',

    components: {}
  }
</script>
