<template>
    <div>
        <administrator-memu/>
        <reported-board-form/>
    </div>
</template>

<script>
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import ReportedBoardForm from '../../components/administrator/ReportedBoardForm.vue'
export default {
  components: { ReportedBoardForm, AdministratorMemu },
    
}
</script>