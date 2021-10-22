<template>
    <div>
        <board-list-menu/>
        <charging-board-list-page-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardListMenu from '../../components/board/BoardListMenu.vue'
import ChargingBoardListPageForm from '../../components/board/ChargingBoardListPageForm.vue'

export default {
    name: 'ChargingBoardListPage',
  components: {ChargingBoardListPageForm, BoardListMenu  },
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