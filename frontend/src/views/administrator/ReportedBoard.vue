<template>
    <div>
        <administrator-memu/>
        <reported-board-form :ReportedBoardList="ReportedBoardList"/>
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