<template>
    <div>
        <administrator-memu/>
        <member-management-form  v-if="memberList &&this.$store.state.auth =='관리자' " :memberList="memberList"/>
        <p v-else> 접근권한이 없습니다</p>
    </div>
</template>

<script>
import {mapState,mapActions} from 'vuex'
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import MemberManagementForm from '../../components/administrator/MemberManagementForm.vue'
export default {
  components: { MemberManagementForm, AdministratorMemu },

  computed: {
      ...mapState(['memberList'])
  },
  methods: {
      ...mapActions(['fetchMemberList'])
  },
  created() {
      this.fetchMemberList()
  }
    
}
</script>