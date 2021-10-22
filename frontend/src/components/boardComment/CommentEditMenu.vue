<template>
  <div>
    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn large icon color="indigo" v-bind="attrs" v-on="on">
          <v-icon>more_horiz</v-icon>
        </v-btn>
      </template>
      <v-list>

        <v-list-item>
          <v-icon class="iconBox">edit</v-icon>
          <v-list-item-title class="iconBox" >수정
          </v-list-item-title>
        </v-list-item>

        <v-list-item>
          <v-icon class="iconBox">delete</v-icon>
          <v-list-item-title class="iconBox" @click="deleteComment(commentInfo)">삭제
          </v-list-item-title>
        </v-list-item>

      </v-list>
    </v-menu>
  </div>
</template>

<script>
import axios from "axios";
import {mapActions} from "vuex";

export default {
  name: "CommentEditMenu",
  props: {
    commentInfo: {
      type: Object,
      required: true
    },
    boardNo: {
      type: Number,
      required: true
    },
  },
  data() {
    return {
      items: [
        { title: '수정', icon: 'edit', method: 'editComment(commentInfo)' },
        { title: '삭제', icon: 'delete', method: 'deleteComment(commentInfo)' },
      ],
      deleted: '삭제된 댓글입니다.'
    }
  },
  methods: {
    ...mapActions(['fetchCommentList']),
    deleteComment(commentInfo) {
      const { deleted } = this
      axios.put(`http://localhost:7777/comment/${commentInfo.commentNo}`,
          { memberId : commentInfo.memberId, content : deleted })
          .then(() => {
            alert('삭제 성공!')
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
.iconBox{
  margin: 0 3px;
  cursor: pointer;
}
</style>
