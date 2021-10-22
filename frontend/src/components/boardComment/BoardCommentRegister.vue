<template>
  <v-card-actions v-if="!this.$store.state.isLogin">

    <v-textarea @focus="setWriter" solo auto-grow class="commentBox"
                rows="3" row-height="20" placeholder="댓글 작성" v-model="content">
    </v-textarea>

    <v-btn @click="onClick" depressed color="primary" class="commentBtn">댓글 등록</v-btn>

  </v-card-actions>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";

export default {
  name: "BoardCommentRegister",
  props: {
    board: {
      type: Object,
      required: true,
    },
    computed: {
      ...mapState(["session"])
    },
  },
  data() {
    return {
      content: '',
      writer: '',
    }
  },
  methods: {
    ...mapActions(["fetchCommentList"]),
    onClick() {
      const { writer, content } = this
      const { boardNo } = this.board

      axios.post(`http://localhost:7777/comment/register/${boardNo}`, { writer, content })
          .then(() => {
            alert('댓글 등록 성공!')
            //window.location.reload();
            this.fetchCommentList(this.board.boardNo)
            this.content = ""
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    setWriter() {
      const temp = this.$store.state.session.member_id
      this.writer = temp
    }
  }
}
</script>

<style scoped>
.commentBox{
  position: relative;
  top: 50px;
  width: 50%;
  margin: auto;
  padding: 0 20px;
  box-sizing: border-box;
  border-radius: 5px;
}

.commentBtn{
  position: relative;
  top: 35px;
  min-height: 50px;
}
</style>
