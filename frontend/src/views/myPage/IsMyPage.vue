<template>
  <div>
    <my-page-menu />

    <v-card
      class="mx-auto"
      max-width="400"
      min-height="100%"
      style="margin: 50px;"
    >
      <v-list-item two-line>
        <v-list-item-content>
          <h3 class="center mt-3">회원정보</h3>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>

      <v-list>
        <v-list-item>
          <div>
            <v-list-item-icon>
              <v-icon>
                mdi-account
              </v-icon>
            </v-list-item-icon>
          </div>

          <v-list-item-content>
            <v-list-item-title>{{
              session && session.memberId
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon> </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ session && session.name }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>
              mdi-email
            </v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>{{
              session && session.email
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>
              mdi-cake
            </v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{
              session && session.memberBirthDay.split("T", 1)[0]
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>
              mdi-car
            </v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{
              session && session.memberCar
            }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
      <v-divider></v-divider>
      <v-card-actions>
        <v-btn color="primary" route :to="{ name: 'IsEditMemberPage' }">
          회원정보 수정
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn @click="deleteId" color="primary">
          회원 탈퇴
        </v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import axios from "axios";
import MyPageMenu from "../../components/myPage/MyPageMenu.vue";

export default {
  computed: {
    ...mapState(["session"]),
  },
  components: {
    MyPageMenu,
  },
  methods: {
    ...mapActions(["logout"]),
    deleteId() {
      var temp;
      var inputString = prompt("아이디를 입력하세요");
      if (inputString == this.session.memberId) {
        temp = true;
        const { memberNo } = this.session;
        axios
          .delete(`http://localhost:7777/member/delete/${memberNo}`)
          .then(() => {
            alert("계정 삭제 성공");
            this.$cookies.remove("user");
            this.$router.push({ name: "Home" });
            window.location.reload();
          })
          .catch((err) => {
            alert(err.response.data.message);
          });
      } else {
        alert("계정 삭제 실패");
        temp = false;
      }
      console.log(temp);
      return temp;
    },
    changeInfo() {
      this.$router.push({ name: "IsMyPage" });
    },
  },
};
</script>

<style scoped></style>
