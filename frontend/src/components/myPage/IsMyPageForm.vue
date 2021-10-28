<template>
  <div>
    <div>
      <v-card
        max-width="25%"
        class="mx-auto"
        style="margin: 3%;"
      >
        <v-img
          src="https://img3.yna.co.kr/etc/inner/KR/2021/02/15/AKR20210215126900005_03_i_P4.jpg"
          height="200px"
          dark
        >
          <v-row class="fill-height">
            <v-card-title class="white--text pl-12 pt-12">
              <div class="text-h4 pl-12 pt-12">
                <div v-if="LoginCheck">
        <h2 style="  text-align: center;">{{ session }} 님 하윙</h2>
      </div>
              </div>
            </v-card-title>
          </v-row>
        </v-img>

        <v-list>
          <v-list-item>
            <v-list-item-icon>
              <v-icon color="indigo">
                mdi-account
              </v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ session }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-divider inset></v-divider>

          <v-list-item>
            <v-list-item-icon> </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>이름(ㅇㄹㅇㄹㅇ)</v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-divider inset></v-divider>

          <v-list-item>
            <v-list-item-icon>
              <v-icon color="indigo">
                mdi-email
              </v-icon>
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title>EVS@naver.com</v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-divider inset></v-divider>

          <v-list-item>
            <v-list-item-icon>
              <v-icon color="indigo">
                mdi-cake
              </v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>9999-99-99</v-list-item-title>
            </v-list-item-content>
          </v-list-item>

          <v-divider inset></v-divider>

          <v-list-item>
            <v-list-item-icon>
              <v-icon color="indigo">
                mdi-car
              </v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>하이브리드</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-card>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

export default {
  computed: {
    ...mapState(["isLogin", "session"]),
    LoginCheck() {
      return this.isLogin;
    },
  },
  methods: {
    ...mapActions(["setIsLogin"]),
  },
  name: "MemberJoinColumnTestForm",
  data() {
    return {};
  },
};
</script>

<style scoped></style>
