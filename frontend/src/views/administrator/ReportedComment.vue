<template>
    <div>
      <administrator-memu/>
      <reported-comment-form v-if=" this.$store.state.auth =='관리자'"  />
      <p v-else>접근권한이없습니다.</p>
    </div>
</template>

<script>
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import ReportedCommentForm from '../../components/administrator/ReportedCommentForm.vue'
export default {
  components: { AdministratorMemu, ReportedCommentForm },
    name: 'ReportedCommentedForm',
   
    
}
</script> 