<template>
    <div>
        <administrator-memu/>
        <member-management-form  v-if="memberList" :memberList="memberList"/>
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