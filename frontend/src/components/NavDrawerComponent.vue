<template>
  <div>
    <v-app-bar-nav-icon @click.stop="nav_drawer = !nav_drawer" :class="hamburger">
    </v-app-bar-nav-icon>

    <v-navigation-drawer app v-model="nav_drawer" absolute temporary right>

      <v-list-item>
        <v-list-item-avatar v-if="session">
          <v-img src="https://user-images.githubusercontent.com/83811729/139426389-ea6ace2a-bd42-4e3a-96fa-82388a029e67.png"></v-img>
        </v-list-item-avatar>

        <v-list-item-content v-if="session" @click="$router.push('/isMyPage')" class="pointer">
          <v-list-item-title>{{ session.memberId }}</v-list-item-title>
        </v-list-item-content>

        <v-list-item-icon v-if="!session">
          <v-icon>exit_to_app</v-icon>
        </v-list-item-icon>
        <v-list-item-content v-if="!session" @click="$router.push('/loginPage')" class="pointer">
          <v-list-item-title>로그인 하러가기</v-list-item-title>
        </v-list-item-content>

      </v-list-item>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item @click="item.method" v-for="item in items" :key="item.title" link>

            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content class="text-button">
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>

        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "NavDrawerComponent",
  computed: {
    ...mapState(['isLogin', 'session'])
  },
  mounted() {
    window.onscroll = () => {
      this.changeColor();
    };
  },
  data() {
    return {
      nav_drawer: false,
      hamburger: 'hamburger hidden-lg-only black--text',
      color: '',
      items: [
        { title: '홈으로', icon: 'home', method: this.goHome},
        { title: '마이페이지', icon: 'account_box', method: this.goMyPage},
        { title: '게시판', icon: 'mdi-view-dashboard', method: this.goBoard},
        { title: '자동차 정보', icon: 'directions_car', method: this.evInfo},
        { title: '로그아웃', icon: 'reply', method: this.logout},
      ],
    }
  },
  methods:{
    ...mapActions(['logout', ]),
    changeColor() {
      if (
          document.body.scrollTop > 50 ||
          document.documentElement.scrollTop > 50
      ) {
        this.hamburger = 'hamburger hidden-lg-only white--text'
      } else {
        this.hamburger = 'hamburger hidden-lg-only black--text'
      }
    },
    goMyPage() {
      this.$router.push('/isMyPage')
    },
    goHome() {
      this.$router.push('/')
    },
    goBoard() {
      this.$router.push('/boardListPage')
    },
    evInfo() {
      this.$router.push('/evinfo')
    }
  }
}
</script>

<style scoped>

.pointer{
  cursor: pointer;
}

</style>
