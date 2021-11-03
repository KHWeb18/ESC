<template>
    <div>
        <ev-info/>
        <ev-subidy-form />
    </div>
</template>

<script>
import EvInfo from '../../components/EvInfo/EvInfo.vue'
import EvSubidyForm from '../../components/EvInfo/EvSubidyForm.vue'
export default {
    name: 'EvSubidy',
  components: { EvSubidyForm,EvInfo },
  data(){
      return{
          target: '보조금 지원 및 전기차 리스트'
      }
  },
    
}
</script>