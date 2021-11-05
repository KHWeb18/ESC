<template>
    <div>
      <my-page-menu/>
      <is-my-board-page-form :memberBoardList=memberBoardList />
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import IsMyBoardPageForm from '../../components/myPage/IsMyBoardPageForm.vue'
import MyPageMenu from '../../components/myPage/MyPageMenu.vue'
//import store from '../../store/states.js'
export default {
    name: 'IsMyBoardPage',
    computed: {
      ...mapState(["memberBoardList", "session"]),
    },  
    components: { 
      IsMyBoardPageForm, MyPageMenu 
    },
    data(){
      return{
        memberNo: this.$store.state.session
      } 
    },
    methods: {
        ...mapActions(['fetchMemberBoardList']),
    },
    created(){
      this.fetchMemberBoardList(this.session)
    }


}
</script>