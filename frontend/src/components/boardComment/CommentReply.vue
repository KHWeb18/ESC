<template>
  <v-card color="grey lighten-5" max-width="95%" class="mx-auto" elevation="0">
    <div v-for="(item,idx) in replies" :key="idx">

      <!-- delete btn -->
      <v-btn @click="deleteReply(item)" v-if="item.writer === checkUser || checkUser === admin"
             v-show="item.content !== deleted" text class="right deleteBtn mt-1">
        <v-icon>close</v-icon>delete</v-btn>

      <v-card-title class="text-subtitle-1 font-weight-bold">{{ item.writer }}</v-card-title>
      <v-card-text class="grey--text mt-n5">{{ item.regDate }}</v-card-text>
      <v-card-text class="text-body-1 mt-n2 mb-1 font-weight-light black-text">{{ item.content }}</v-card-text>

      <v-divider></v-divider>

    </div>

    <v-card-actions>
      <v-textarea @focus="setWriter" solo auto-grow class="mt-8 ml-5 mr-10"
                  rows="3" row-height="20" placeholder="Reply to Comment"
                  v-model="content"></v-textarea>

      <v-btn @click="registerReply" v-show="content" text class="py-9">Submit</v-btn>
    </v-card-actions>

  </v-card>
</template>

<script>
export default {
  name: "CommentReply"
}
</script>

<style scoped>

</style>
