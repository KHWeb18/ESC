<template>
  <v-card-text class="likeBtn"><v-btn @click="likeComment">Like</v-btn>
    <v-btn>reply</v-btn>
  </v-card-text>
</template>

<script>
import axios from "axios";

export default {
  name: "BoardCommentLike",
  props: {
    comment: {
      type: Object,
      required: true
    },
  },
  data() {
    return{
      memberId: "testId"
    }
  },
  methods: {
    likeComment(){
      const { memberId } = this
      const { commentNo } = this.comment
      axios.post(`http://localhost:7777/comment/like/${commentNo}`, { memberId })
          .then(() => {
            alert('좋아요')
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
  }
}
</script>

<style scoped>

</style>
