<template>
  <v-card max-width="95%" class="mx-auto" elevation="0">

    <div v-for="(item,idx) in comments" :key="idx">

      <v-card-title class="text-subtitle-1 font-weight-bold">{{ item.memberId }}</v-card-title>
      <v-card-text class="grey--text mt-n5">{{ item.regDate }}</v-card-text>
      <v-card-text class="text-body-1 mt-n2 mb-1 font-weight-light black-text">{{ item.content }}</v-card-text>

      <v-divider></v-divider>
    </div>

  </v-card>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
  name: "BoardCommentList",
  props: {
    boardNo: {
      type: String,
      required: true
    },
  },
  mounted() {
    this.fetchCommentList(this.boardNo)
  },
  computed: {
    ...mapState(['comments', 'comment', 'session'])
  },
  methods: {
    ...mapActions(['fetchCommentList', 'fetchComment'])
  }

}
</script>

<style scoped>

</style>
