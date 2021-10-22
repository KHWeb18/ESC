<template>
  <div class="home">
    <div id="header">
      <router-link
        :to="{ name: 'MainHomePage' }"
        class="nav-link"
        active-class="active">
        메인홈
      </router-link>
      <router-link
        :to="{ name: 'FreeBoardListPage' }"
        class="nav-link"
        active-class="active">
        게시판
      </router-link>
    </div>
  </div>
</template>

<script>

  export default {
    name: 'Home',

    components: {}
  }
</script>
