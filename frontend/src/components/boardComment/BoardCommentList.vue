<template>
  <div class="commentListBox">
    <v-card max-width="90%" elevation="0">

      <div v-for="(item,idx) in comments" :key="idx">

        <v-card-title class="commentAuthor">{{ item.memberId }}</v-card-title>
        <v-card-text class="grey--text commentDate">{{ item.regDate }}</v-card-text>

        <!-- 수정 / 삭제 버튼 -->
        <comment-edit-menu v-if="!item.isDeleted && commentIdx !== idx" class="editBtn"
                           @showEdit="setCommentIdx(idx)" :commentInfo="item" :boardNo="boardNo"></comment-edit-menu>
        <!-- content -->
        <v-card-text class="commentContent" v-if="!item.isDeleted && commentIdx !== idx">{{ item.content }}</v-card-text>
        <v-card-text class="commentContent" v-if="item.isDeleted && commentIdx !== idx">삭제된 댓글입니다.</v-card-text>

        <!-- 좋아요 -->
        <BoardCommentLike></BoardCommentLike>


        <!-- 수정 text area -->
        <comment-edit-area :comment="item" :boardNo="boardNo" @hideEditbox="hideEditbox"
                           v-if="commentIdx === idx" v-show="editBox"></comment-edit-area>

        <v-divider></v-divider>
      </div>

    </v-card>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import CommentEditMenu from "./CommentEditMenu";
import CommentEditArea from "./CommentEditArea";
import BoardCommentLike from "./BoardCommentLike";

export default {
  name: "BoardCommentList",
  components: {BoardCommentLike, CommentEditArea, CommentEditMenu},
  props: {
    boardNo: {
      type: Number,
      required: true
    },
  },
  mounted() {
    this.fetchCommentList(this.boardNo)
  },
  data() {
    return {
      editBox: true,
      commentIdx: '',
    }
  },
  computed: {
    ...mapState(['comments', 'comment', 'session'])
  },
  methods: {
    ...mapActions(['fetchCommentList', 'fetchComment']),
    setCommentIdx(idx){
      this.commentIdx = idx
      console.log(this.commentIdx)
    },
    hideEditbox(value){
      this.editBox = value
      this.commentIdx = ''
      console.log(this.editBox)
    }
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
