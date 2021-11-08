<template>
  <div>
    <table>
      <tr>
        <v-btn depressed route :to="{ name: 'IsMyBoardPage' }">
          게시글
        </v-btn>
        <v-btn depressed route :to="{ name: 'IsMyCommentListPage' }">
          댓글
        </v-btn>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: "IsMyBoardMenu",
};
</script>
