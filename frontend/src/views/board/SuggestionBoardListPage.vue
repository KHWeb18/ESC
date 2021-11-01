<template>
    <div>
        <customer-service-board-menu/>
        <suggestion-board-list-page-form :TargetList="TargetList"/>
    </div>
</template>

<script>
import {mapActions,mapState} from 'vuex'
import CustomerServiceBoardMenu from '../../components/board/CustomerServiceBoardMenu.vue'
import SuggestionBoardListPageForm from '../../components/board/SuggestionBoardListPageForm.vue'
export default {
  components: { SuggestionBoardListPageForm,CustomerServiceBoardMenu},
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