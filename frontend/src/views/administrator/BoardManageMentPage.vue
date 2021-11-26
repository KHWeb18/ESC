<template>
    <div>
        <board-manage-ment-page-form v-if="this.$store.state.auth =='관리자'" :boardList="boardList"/>
        <p v-else> 접근권한이 없습니다.</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardManageMentPageForm from '../../components/administrator/BoardManageMentPageForm.vue'

export default {
    name: 'BoardListPage',
    components: {  BoardManageMentPageForm },
    computed: {
        ...mapState(['boardList','session'])
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    },
    created(){
        this.fetchBoardList()
    }


}
</script>