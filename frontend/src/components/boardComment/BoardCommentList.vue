<template>
  <div class="commentListBox">
    <v-card max-width="90%" elevation="0">

      <div v-for="(item,idx) in comments" :key="idx">

        <v-card-title class="commentAuthor">{{ item.memberId }}</v-card-title>
        <v-card-text class="grey--text commentDate">{{ item.regDate }}</v-card-text>

        <!-- 수정 / 삭제 버튼 -->
        <comment-edit-menu class="editBtn" :commentInfo="item" :boardNo="boardNo"></comment-edit-menu>

        <v-card-text class="commentContent">{{ item.content }}</v-card-text>

        <v-divider></v-divider>
      </div>

    </v-card>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import CommentEditMenu from "./CommentEditMenu";

export default {
  name: "BoardCommentList",
  components: {CommentEditMenu},
  props: {
    boardNo: {
      type: Number,
      required: true
    },
  },
  mounted() {
    this.fetchCommentList(this.boardNo)
  },
  computed: {
    ...mapState(['comments', 'comment', 'session'])
  },
  methods: {
    ...mapActions(['fetchCommentList', 'fetchComment'])
  }

}
</script>

<style scoped>

.commentListBox{
  margin-top: 30px;
  margin-left: 8%;
  max-width: 83%;
}

.commentAuthor{
  font-size: 0.95em;
  margin-left: 5px;
}

.commentDate{
  font-size: 0.7em;
  margin: -22px 0 0 5px;
}

.editBtn{
  position: relative;
  margin: -45px 0 10px 88%;
}

.commentContent{
  font-size: 1.1em;
  margin: -20px 0 20px 0;
  min-height: 50px;
  font-weight: normal;
}
</style>
