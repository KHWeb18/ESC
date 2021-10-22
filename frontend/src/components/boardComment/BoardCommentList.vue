<template>
  <div class="commentListBox">
    <v-card max-width="90%" elevation="0">

      <div v-for="(item,idx) in comments" :key="idx">

        <v-card-title class="commentAuthor">{{ item.memberId }}</v-card-title>
        <v-card-text class="grey--text commentDate">{{ item.regDate }}</v-card-text>

        <!-- 수정 / 삭제 버튼 -->
        <comment-edit-menu class="editBtn"></comment-edit-menu>

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
      type: String,
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
  font-size: 1.2em;
  margin-left: 5px;
}

.commentDate{
  font-size: 0.8em;
  margin: -42px 0 0 47px;
}

.editBtn{
  position: relative;
  margin: -45px 0 10px 88%;
}

.commentContent{
  font-size: 0.95em;
  margin: -20px 0 40px 0;
  min-height: 50px;
}
</style>
