<template>
    <div>
        <suggestion-board-list-page-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import {mapActions,mapState} from 'vuex'
import SuggestionBoardListPageForm from '../../components/board/SuggestionBoardListPageForm.vue'
export default {
  components: { SuggestionBoardListPageForm},
    name: 'SuggestionBoardListPage',
    
    data(){
      return{
          target: '건의게시판'
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