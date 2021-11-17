<template>
  <div>
    <is-my-page-banner-form />
    <v-card
      class="mx-auto"
      max-width="400"
      min-height="100%"
      style="margin: 50px;"
    >
      <v-list-item two-line>
        <v-list-item-content>
          <h3 class="center mt-3">회원정보 수정</h3>
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
      </v-list>
      <v-card-text>
        <v-text-field
          :rules="nameRules"
          required
          v-model="name"
          label="회원이름"
          type="text"
          prepend-icon="mdi-account"
          flat
          solo
        >
        </v-text-field>

        <v-text-field
          :rules="passwordRules"
          required
          v-model="memberPw"
          label="비밀번호"
          type="password"
          prepend-icon="mdi-lock"
          flat
          solo
        >
        </v-text-field>

        <v-text-field
          :rules="memberPwCheck"
          required
          label="비밀번호확인"
          type="password"
          prepend-icon="mdi-lock"
          flat
          solo
        >
        </v-text-field>

        <v-text-field
          :rules="emailRules"
          required
          v-model="email"
          label="이메일"
          type="text"
          prepend-icon="mdi-email-multiple"
          flat
          solo
        >
        </v-text-field>

        <v-select
          :items="SelectCarList"
          v-model="memberCar"
          label="보유차종선택"
        >
        </v-select>
      </v-card-text>
      <v-divider></v-divider>
      <v-card-actions>
        <v-btn color="primary" @click="done">수정완료</v-btn>
        <v-spacer></v-spacer>
        <v-btn color="primary" @click="cancel">취소</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions, mapState } from "vuex";
/* import MyPageMenu from "../../components/myPage/MyPageMenu.vue"; */
import IsMyPageBannerForm from '../../components/myPage/IsMyPageBannerForm.vue';

export default {
  name: "IsMyBoardPage",
  components: { /* MyPageMenu */ IsMyPageBannerForm },
  computed: {
    ...mapState([
      "member",
      "session",
      "emailRules",
      "nameRules",
      "passwordRules",
    ]),
  },
  data() {
    return {
      email: "",
      name: "",
      memberPw: "",
      memberNo: this.$store.state.session && this.$store.state.session.memberNo,
      memberCar: "",
      memberPwCheck: [
        (v) => this.memberPw === v || "비밀번호가 일치하지않습니다",
      ],
      SelectCarList: [
        { text: "전기차", value: "전기차" },
        { text: "일반차", value: "일반차" },
        { text: "하이브리드차", value: "하이브리드차" },
        { text: "없음", value: "없음" },
      ],
      loginAlert: "보유차종을 선택하여주십시오.",
    };
  },
  methods: {
    ...mapActions(["cookieToSession"]),
    cancel() {
      this.$router.push({ name: "IsMyPage" });
    },
    done() {
      const { memberNo, memberId, name, email, memberPw, memberCar } = this;
      axios
        .put(`http://localhost:7777/member/modify/${memberNo}`, {
          memberId,
          name,
          email,
          memberPw,
          memberCar,
        })
        .then((res) => {
          alert("수정 성공!");
          this.res = res.data;
          this.$cookies.set("user", res.data, "1h");
          this.cookieToSession();
          this.$router.push({
            name: "IsMyPage",
          });
        })
        .catch((err) => {
          alert(err.response.data.message);
        });
    },
  },
};
</script>
