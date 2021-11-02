<template>
  <div v-if="session" class="hidden-sm-and-down">
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn text v-bind="attrs" v-on="on">
          <span class="profileBtn">{{ session.memberId }}</span>
          <v-icon>arrow_drop_down</v-icon>
        </v-btn>
      </template>
      <v-list>

        <v-list-item class="pointer" @click="goMyPage">
          <v-icon>account_box</v-icon>
          <v-list-item-title class="iconBox">마이페이지
          </v-list-item-title>
        </v-list-item>

        <v-list-item class="pointer" @click="logout">
          <v-icon>reply</v-icon>
          <v-list-item-title class="iconBox">로그아웃
          </v-list-item-title>
        </v-list-item>

      </v-list>
    </v-menu>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "HeaderMemberMenu",
  computed:{
    ...mapState(['session'])
  },
  methods:{
    ...mapActions(['logout']),
    goMyPage() {
      this.$router.push('/isMyPage')
    },
  }
}
</script>

<style scoped>
.profileBtn{
  font-size: 1.2em;
}
.iconBox{
  margin: 0 -5px 0 10px;
}

.pointer{
  cursor: pointer;
}
</style>
