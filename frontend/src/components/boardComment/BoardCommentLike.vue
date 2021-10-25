<template>
  <v-card-text class="likeBtn"><v-btn @click="likeComment">Like</v-btn>
    {{ comment.commentLikes.length }}
    <v-btn @click="removeLike">hate</v-btn>
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
    ...mapState(['commentLikes'])
  },
  data() {
    return{
      memberId: "testIdddd"
    }
  },
  methods: {
    ...mapActions(["fetchCommentList"]),
    likeComment(){
      const { memberId } = this
      const { commentNo } = this.comment
      axios.post(`http://localhost:7777/comment/like/${commentNo}`, { memberId })
          .then(() => {
            this.fetchCommentList(this.boardNo)
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    removeLike(){
      const { memberId } = this
      const { commentNo } = this.comment
      axios.delete(`http://localhost:7777/comment/like/delete/${commentNo}/${memberId}`)
          .then(() => {
            this.fetchCommentList(this.boardNo)
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    }
  }
}
</script>

<style scoped>

</style>
