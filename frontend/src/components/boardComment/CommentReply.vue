<template>
  <v-card color="grey lighten-5" max-width="95%" class="mx-auto" elevation="0" v-if="replies">
    <div v-for="(item,idx) in replies" :key="idx">
      <v-card-title class="writer">{{ item.memberId }}</v-card-title>
      <v-card-text class="grey--text date">{{ item.regDate }}</v-card-text>

      <!-- delete btn -->
      <v-btn @click="deleteReply(item)" v-if="item.memberId === session && !item.isDeleted"
             v-show="item.content !== deleted" text class="deleteBtn">
        <v-icon>close</v-icon>삭제</v-btn>

      <v-card-text v-if="!item.isDeleted" class="content">{{ item.content }}</v-card-text>
      <v-card-text v-if="item.isDeleted" class="contentDeleted">삭제된 댓글입니다.</v-card-text>

      <v-divider></v-divider>

    </div>

    <v-card-actions v-if="session">
      <v-textarea @focus="setWriter" solo auto-grow class="mt-8 ml-5 mr-10"
                  rows="3" row-height="20" placeholder="답글 작성하기"
                  v-model="content"></v-textarea>

      <v-btn @click="registerReply" v-show="content"  color="primary" class="registerBtn">답글 등록</v-btn>
    </v-card-actions>

  </v-card>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";


export default {
  name: "CommentReply",
  props: {
    comment: {
      type: Object,
      required: true,
    },
    replies: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      content: '',
      memberId: '',
      deleted : "삭제된 댓글입니다.",
      admin: 'admin',
    }
  },
  computed: {
    ...mapState(['session']),
  },
  methods: {
    ...mapActions(["fetchReplies"]),
    registerReply() {
      const { memberId, content } = this
      const { commentNo } = this.comment
      const isDeleted = false
      axios.post(`https://evsbackend.herokuapp.com/reply/register/${commentNo}`, { memberId, content, isDeleted })
          .then(() => {
            alert('답글 등록 완료!')
            this.fetchReplies(this.comment.commentNo)
            this.content = ""
          })
          .catch(res => {
            alert(res.response.data.message)
          })
    },
    setWriter() {
      const temp = this.$store.state.session
      this.memberId = temp
    },
    deleteReply(item) {
      //const { content } = this
      axios.put(`https://evsbackend.herokuapp.com/reply/${item.replyNo}`,
          { memberId : item.memberId, isDeleted : true })
          .then(() => {
            alert('삭제 성공!')
            this.fetchReplies(this.comment.commentNo)
          })
          .catch(err => {
            alert(err.response.data.message)
          })
    },
  }
}
</script>

<style scoped>

.writer{
  font-size: 0.9em;
}

.date{
  font-size: 0.8em;
  margin: -25px 0 0 0;
}

.deleteBtn{
  position: relative;
  left: 88%;
  margin: -130px 0 0 0;
}

.content{
  font-size: 1.1em;
  margin: -35px 0 20px 0;
  min-height: 50px;
  font-weight: normal;
}
.contentDeleted{
  font-size: 1.1em;
  margin: -10px 0 20px 0;
  min-height: 50px;
  font-weight: normal;
}

.registerBtn{
  position: relative;
  margin: 0 0 0 -20px;
  min-height: 50px;
}
</style>
