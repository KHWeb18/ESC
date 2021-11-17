<template>
    <div>

        <free-board-list-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'

import FreeBoardListForm from '../../components/board/FreeBoardListForm.vue'
export default {
    name: 'FreeBoardList',
  components: { FreeBoardListForm  },
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