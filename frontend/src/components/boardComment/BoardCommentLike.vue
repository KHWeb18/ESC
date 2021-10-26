<template>
  <v-card-text class="likeBtn"><v-btn @click="likeComment">Like</v-btn>
    {{ comment.commentLikes.length }}
    <v-btn @click="removeLike">hate</v-btn>
    {{ comment.commentNo }}
    <v-btn @click="checkDuplicate">check</v-btn>
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
    return{
      memberId: this.$store.state.session
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
    },
    checkDuplicate(){
      const { memberId } = this
      const { commentNo } = this.comment
      console.log(commentNo)
      let temp;
      axios.get(`http://localhost:7777/comment/like/check/${commentNo}/${memberId}`)
          .then(res => {
            //console.log(res.data)
            temp = res.data
            console.log(temp)
          })
      return temp
    },
  }
}
</script>

<style scoped>

</style>
