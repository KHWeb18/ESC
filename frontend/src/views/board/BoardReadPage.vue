<template>
    <div>
       <board-read-page-fom v-if="board" :board="board"/> 
       <p>{{boardNo}}</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardReadPageFom from '../../components/board/BoardReadPageFom.vue'
export default {
  components: { BoardReadPageFom },
    name: 'BoardReadPage',
    props: {
        boardNo: {
            type: String,
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