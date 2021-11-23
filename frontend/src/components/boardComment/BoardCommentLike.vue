<template>
  <v-card-text class="likeBtn">
    <v-btn text v-if="!checkDuplicate()" @click="likeComment">
      <v-icon left>mdi-thumb-up</v-icon>{{ comment.commentLikes.length }}</v-btn>

    <v-btn text v-if="checkDuplicate()" @click="removeLike">
      <v-icon color="primary" left>mdi-thumb-up</v-icon>{{ comment.commentLikes.length }}</v-btn>

  </v-card-text>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";

export default {
  name: "BoardCommentLike",
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
    ...mapState(['commentLikes', 'session']),
  },
  data() {
    return {
      memberId: this.$store.state.session.memberId,
      dup: '',
    }
  },
  methods: {
    ...mapActions(["fetchCommentList"]),
    likeComment() {
      const {memberId} = this
      const {commentNo} = this.comment
      axios.post(`https://evsbackend.herokuapp.com/comment/like/${commentNo}`, {memberId})
          .then(() => {
            this.fetchCommentList(this.boardNo)
          })
          .catch( res=> {
            console.log(res)
            alert("로그인 바랍니다.")
          })
    },
    removeLike() {
      const {memberId} = this
      const {commentNo} = this.comment
      axios.delete(`https://evsbackend.herokuapp.com/comment/like/delete/${commentNo}/${memberId}`)
          .then(() => {
            this.fetchCommentList(this.boardNo)
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    checkDuplicate() {
      const {commentNo} = this.comment
      const {memberId} = this
      let temp;
      axios.get(`https://evsbackend.herokuapp.com/comment/like/check/${commentNo}/${memberId}`)
          .then(res => {
            temp = res.data
            this.dup = temp
          })
      return this.dup
    },
  }
}
</script>

<style scoped>
.likeBtn{
  margin: -20px 0 -31px 50px;
}
</style>
