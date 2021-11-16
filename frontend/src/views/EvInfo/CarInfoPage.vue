<template>
    <div>
         <car-info-form @submit="OnSubmit"/>
    </div>
</template>

<script>

import CarInfoForm from '@/components/EvInfo/CarInfoForm.vue'

export default {
    name: 'CarInfoPage',
    components: {
        CarInfoForm
    },
    
}
</script>


