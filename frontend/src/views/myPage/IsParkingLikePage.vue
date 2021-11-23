<template>
  <div id="wrap">
    <div id="header">
      <is-my-page-banner-form />
    </div>
    <div id="container">
      <div id="aside"></div>
      <div id="content">
        <v-container>
          <h1 style="margin: 30px;">즐겨찾기</h1>
          <my-page-menu />
          <is-my-parking-like-list :myParkingStates="myParkingStates" />
          <v-divider light style="margin-top: 30px;"></v-divider>
          <h1 style="margin: 30px;">게시글</h1>
          <is-my-board-page-form :myBoardList="myBoardList" />
          <v-divider light style="margin-top: 30px;"></v-divider>
          <h1 style="margin: 30px;">댓글</h1>
          <is-my-comment-list-form :myCommentList="myCommentList" />
        </v-container>
      </div>
    </div>
  </div>
</template>

<script>
import IsMyPageBannerForm from "../../components/myPage/IsMyPageBannerForm.vue";
import MyPageMenu from "../../components/myPage/MyPageMenu.vue";
import IsMyParkingLikeList from "../../components/myPage/IsMyParkingLikeList.vue";
import { mapActions, mapState } from "vuex";
import IsMyBoardPageForm from "../../components/myPage/IsMyBoardPageForm.vue";
import IsMyCommentListForm from "../../components/myPage/IsMyCommentListForm.vue";
import Vue from "vue";

export default {
  name: "IsMyPage",
  components: {
    IsMyBoardPageForm,
    IsMyCommentListForm,
    IsMyParkingLikeList,
    IsMyPageBannerForm,
    MyPageMenu,
  },
  computed: {
    ...mapState(["session", "myBoardList", "myCommentList", "myParkingStates"]),
  },
  methods: {
    ...mapActions([
      "fetchMyBoardList",
      "fetchMyCommentList",
      "fetchMyLikeList",
      "getMyParkingStateList",
    ]),
  },
  mounted() {
    if (this.session) {
      this.fetchMyBoardList(this.session.memberId);
    } else {
      let data = Vue.$cookies.get("user");
      let member = data.memberId;
      this.fetchMyBoardList(member);
    }

    if (this.session) {
      this.fetchMyCommentList(this.session.memberId);
    } else {
      let data = Vue.$cookies.get("user");
      let member = data.memberId;
      this.fetchMyCommentList(member);
    }

    if (this.session) {
      this.getMyParkingStateList(
        this.session.memberNo && this.session.memberNo
      );
    } else {
      let data = Vue.$cookies.get("user");
      let member = data.memberNo;
      this.getMyParkingStateList(member);
    }
  },
};
</script>

<style scoped>
#wrap {
  width: 100%;

  margin: 0 auto;
}

#container {
  height: 100%;
}
#aside {
  margin-top: 60px;
  background: skyblue;
  width: 10%;
  height: 70%;
  float: left;
}
#content {
  width: 80%;
  height: 30%;
  float: left;
  margin-left: 50px;
}
</style>
