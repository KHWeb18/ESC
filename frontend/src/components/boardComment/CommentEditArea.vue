<template>
  <v-card-actions>
    <v-textarea solo auto-grow class="commentBox"
                rows="3" row-height="20" v-model="editContent">
    </v-textarea>
    <v-btn @click="editComment" depressed color="primary" class="commentBtn">댓글수정</v-btn>

  </v-card-actions>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";

export default {
  name: "CommentEditArea",
  props: {
    comment: {
      type: Object,
      required: true
    },
    boardNo: {
      required: true
    },
  },
  computed: {
    ...mapState(['session'])
  },
  mounted() {
    this.setContent()
  },
  data() {
      return {
        editContent: '',
      }
    },
  methods: {
    ...mapActions(['fetchCommentList']),
    setContent(){
      this.editContent = this.comment.content
    },
    editComment(){
      const { editContent, comment } = this
      axios.put(`https://evsbackend.herokuapp.com/comment/edit/${comment.commentNo}`,
          { memberId : comment.memberId, content : editContent })
          .then(() => {
            alert('수정 성공!')
            this.$emit('hideEditbox', false)
            this.fetchCommentList(this.boardNo)

          })
          .catch(err => {
            alert(err.response.data.message)
          })
    }
  }


}
</script>

<style scoped>
.commentBox{
  margin: 0 0 0 10px;
}
.commentBtn{
  max-width: 100px;
  margin: 0 0 25px 10px;
}
</style>
