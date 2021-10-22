<template>
  <div class="comment-container">
    <v-container class="pa-0">
      <board-read-page-fom v-if="board" :board="board"/>

      <!-- 댓글 -->
      <board-comment-register></board-comment-register>
    </v-container>
  </div>
<!--  <v-container>-->
<!--    <div>-->
<!--      <board-read-page-fom v-if="board" :board="board"/>-->

<!--      &lt;!&ndash; 댓글 &ndash;&gt;-->
<!--      <board-comment-register></board-comment-register>-->
<!--    </div>-->
<!--  </v-container>-->

</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardReadPageFom from '../../components/board/BoardReadPageFom.vue'
import BoardCommentRegister from "../../components/boardComment/BoardCommentRegister";
export default {
  components: {BoardCommentRegister, BoardReadPageFom },
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: Number,
            required: true
        },
        },
        computed:{
            ...mapState(['board'])
        },
        methods: {
            ...mapActions(['fetchBoard'])
        },
        created() {
            console.log(this.boardNo)
            this.fetchBoard(this.boardNo)
        },
    }

</script>
