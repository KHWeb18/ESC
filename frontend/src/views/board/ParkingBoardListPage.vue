<template>
    <div>
        <board-list-menu/>
        <parking-board-list-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardListMenu from '../../components/board/BoardListMenu.vue'
import ParkingBoardListForm from '../../components/board/ParkingBoardListForm.vue'

export default {
    name: 'ParkingBoardListPage',
  components: {ParkingBoardListForm, BoardListMenu, },
  data(){
      return{
          target: '주차장게시판'
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