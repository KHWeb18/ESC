<template>
  <v-card-text class="likeBtn">
    <v-btn v-if="!checkDuplicate()" @click="likeComment">추천</v-btn>

    <v-btn v-if="checkDuplicate()" @click="removeLike">비추천</v-btn>
    추천수 : {{ comment.commentLikes.length }}
    중복인가? : {{ checkDuplicate() }}

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
      type: Number,
      required: true
    },
  },
  computed: {
    ...mapState(['commentLikes', 'session']),
  },
  data() {
    return {
      memberId: this.$store.state.session,
      dup: '',
    }
  },
  methods: {
    ...mapActions(["fetchCommentList"]),
    likeComment() {
      const {memberId} = this
      const {commentNo} = this.comment
      axios.post(`http://localhost:7777/comment/like/${commentNo}`, {memberId})
          .then(() => {
            this.fetchCommentList(this.boardNo)
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    removeLike() {
      const {memberId} = this
      const {commentNo} = this.comment
      axios.delete(`http://localhost:7777/comment/like/delete/${commentNo}/${memberId}`)
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
      axios.get(`http://localhost:7777/comment/like/check/${commentNo}/${memberId}`)
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

</style>
