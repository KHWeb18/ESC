<template>
  <div>
    <my-page-menu />
    <is-my-board-menu />
    <is-my-comment-list-form :myCommentList="myCommentList" />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import IsMyBoardMenu from '../../components/myPage/IsMyBoardMenu.vue';
import IsMyCommentListForm from "../../components/myPage/IsMyCommentListForm.vue";
import MyPageMenu from "../../components/myPage/MyPageMenu.vue";
import Vue from "vue";
export default {
  name: "IsMyBoardPage",
  computed: {
    ...mapState(["myCommentList", "session"]),
  },
  components: {
    IsMyCommentListForm,
    MyPageMenu,
    IsMyBoardMenu,
  },
/*   data() {
    return {
      memberNo: this.$store.state.session
    };
  }, */
  methods: {
    ...mapActions(["fetchMyCommentList"]),
  },
  mounted() {
    if(this.session){
    this.fetchMyCommentList(this.session.memberId);
    }else{
      let data = Vue.$cookies.get("user");
      let member = data.memberId;
       this.fetchMyCommentList(member)
    }
  },
};
</script>
 