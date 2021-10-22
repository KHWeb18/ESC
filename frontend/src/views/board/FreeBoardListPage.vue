<template>
    <div>
        <board-list-menu/>
        <free-board-list-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import BoardListMenu from '../../components/board/BoardListMenu.vue'
import FreeBoardListForm from '../../components/board/FreeBoardListForm.vue'
export default {
    name: 'FreeBoardList',
  components: { FreeBoardListForm, BoardListMenu },
  data(){
      return{
          target: '자유게시판'
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