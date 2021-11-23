<template>
    <div>
        <administrator-memu/>
        <reported-board-form v-if="this.$store.state.auth =='관리자'" :ReportedBoardList="ReportedBoardList"/>
        <p v-else >접근권한이없습니다</p>
    </div>
</template>

<script>
import { mapActions,mapState } from 'vuex'
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import ReportedBoardForm from '../../components/administrator/ReportedBoardForm.vue'
export default {
  components: { ReportedBoardForm, AdministratorMemu },
    computed: {
        ...mapState(["ReportedBoardList"])
    },
    methods:{
        ...mapActions(['getReportedBoardList'])
    },
    created(){
        this.getReportedBoardList()
    },

}
</script>