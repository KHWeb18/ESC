<template>
    <div>
      <my-page-menu/>
      <is-my-board-page-form :memberBoardList=memberBoardList />
      {{ myBoardList }}
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
      ...mapState(["memberBoardList", "session", 'myBoardList']),
    },  
    components: { 
      IsMyBoardPageForm, MyPageMenu 
    },
    data(){
      return{
        //memberNo: this.$store.state.session
        memberNo: this.$store.state.session.memberNo
      }
    },
    methods: {
        ...mapActions(['fetchMemberBoardList', 'fetchMyBoardList']),
    },
    created(){
      // this.fetchMemberBoardList(this.session)
    },
  // 예시
  mounted() {
      this.fetchMyBoardList(this.session.memberId)
  }


}
</script>
