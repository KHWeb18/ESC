<template>
  <v-card class="mx-auto">
    <div style="float: left; margin-left: 10%; width: 40%;">
      <router-link :to="{ name: 'IsMyPage' }">
        <h2 style="color: white; margin: 10px;">MY PAGE</h2></router-link
      >
      <div style="display: inline-flex">
        <div style="float: left; padding-right: 20px; padding-top: 15px;">
          <v-img
            style="width: 170px; height: 170px;"
            src="https://user-images.githubusercontent.com/83811729/139426389-ea6ace2a-bd42-4e3a-96fa-82388a029e67.png"
          ></v-img>
        </div>
        <div style="flaot: right;">
          <p id="title" style="font-size: 50px;">{{ session.memberId }}</p>
          <p id="title">{{ session.name }} 님 / {{ session.email }}</p>
          <p id="title">보유차종 : {{ session.memberCar }}</p>
          <p id="title">생년월일 : {{ session.memberBirthDay.split("T", 1)[0] }}</p>
          <p id="title">가입일 : {{ session.regDate.split("T", 1)[0] }}</p>
        </div>
      </div>
    </div>
    <div class="category">
      <router-link :to="{ name: 'IsEditMemberPage' }"
        ><v-icon x-large style="color: white">manage_accounts </v-icon>
        <p class="name">회원정보변경</p></router-link
      >
      <a href="suggestionBoardListPage"
        ><v-icon x-large style="color: white">help </v-icon>
        <p class="name">문의하기</p></a
      >
      <a @click="deleteId"
        ><v-icon x-large style="color: white">delete </v-icon>
        <p class="name">회원탈퇴</p></a
      >
      <a @click="logout"
        ><router-link :to="{ name: 'MainHomePage' }"
          ><v-icon x-large style="color: white;">logout</v-icon>
          <p class="name">로그아웃</p></router-link
        ></a
      >
    </div>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex";
import axios from "axios";

export default {
  computed: {
    ...mapState(["isLogin", "session"]),
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
  },
};
</script>

<style scoped>
#wrap {
  width: 100%;

  margin: 0 auto;
}

.v-card {
  height: 300px;
  background: black;
}

#container {
  height: 100%;
}
#aside {
  background: skyblue;
  width: 20%;
  height: 70%;
  float: left;
}

#content {
  width: 70%;
  height: 30%;
  float: left;
}

#title {
  color: white;
  line-height: 1.1;
}

a {
  text-decoration: none;
}
.category {
  padding-top: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  font-weight: bold;
}
.v-icon {
  margin-left: 60px;
}
.name {
  margin-left: 60px;
  color: white;
  margin-top: 20px;
  text-align: center;
}
</style>
