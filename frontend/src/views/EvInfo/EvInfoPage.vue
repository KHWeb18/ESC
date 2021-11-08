<template>
    <div>
<!--         <ev-info-form @submit="OnSubmit"/>-->
      <ev-info-example></ev-info-example>
    </div>
</template>

<script>

// import EvInfoForm from '../../components/EvInfo/EvInfoForm.vue'
import EvInfoExample from "../../components/EvInfo/EvInfoExample";

export default {
    name: 'EvInfoPage',
    components: {
      EvInfoExample,
        // EvInfoForm
    },

    
}
</script>


