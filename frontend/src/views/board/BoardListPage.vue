<template>
    <div>
        <board-list-page-form :boardList="boardList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardListPageForm from '../../components/board/BoardListPageForm.vue'
export default {
    name: 'BoardListPage',
    components: { BoardListPageForm },
    computed: {
        ...mapState(['boardList'])
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    },
    created(){
        this.fetchBoardList()
    }


}
</script>