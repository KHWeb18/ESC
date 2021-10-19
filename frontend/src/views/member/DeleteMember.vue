<template>
    <div>
         <delete-member-form @submit="OnSubmit"/>
    </div>
</template>

<script>

import DeleteMemberForm from '../../components/member/DeleteMemberForm.vue'

export default {
    name: 'DeleteMember',
    components: {
        DeleteMemberForm
    },
    
}
</script>