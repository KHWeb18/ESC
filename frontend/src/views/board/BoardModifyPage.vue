<template>
    <div>
        <board-modify-page-form :board="board"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardModifyPageForm from '../../components/board/BoardModifyPageForm.vue'
export default {
  components: { BoardModifyPageForm },
    name: "BoardModifyPage",
    props:{
        boardNo: {
            type: String,
            required:true
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods:{
        ...mapActions(['fetchBoard'])
    },
    created(){
        this.fetchBoard(this.boardNo)
    }
}
</script>