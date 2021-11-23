<template>
    <div>
        <charging-board-list-page-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import ChargingBoardListPageForm from '../../components/board/ChargingBoardListPageForm.vue'

export default {
    name: 'ChargingBoardListPage',
  components: {ChargingBoardListPageForm  },
  data(){
      return{
          target: '충전소게시판'
      }
  },
  computed: {
      ...mapState(['TargetList'])
  },
  methods:{
      ...mapActions(['fetchTargetList'])
  },
  created(){
      this.fetchTargetList(this.target)
  }
    
}
</script>