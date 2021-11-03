<template>
    <div>
        <administrator-memu/>
        <reported-comment-form/>
    </div>
</template>

<script>
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import ReportedCommentForm from '../../components/administrator/ReportedCommentForm.vue'
export default {
  components: { AdministratorMemu, ReportedCommentForm },
    
}
</script>