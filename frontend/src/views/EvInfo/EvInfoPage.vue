<template>
    <div>
         <ev-info-form @submit="OnSubmit"/>
    </div>
</template>

<script>

import EvInfoForm from '../../components/EvInfo/EvInfoForm.vue'

export default {
    name: 'EvInfoPage',
    components: {
        EvInfoForm
    },
    
}
</script>


