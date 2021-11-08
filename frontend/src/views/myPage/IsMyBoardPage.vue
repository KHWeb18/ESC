<template>
    <div>
      <my-page-menu/>
      <is-my-board-menu/> 
      <is-my-board-page-form :myBoardList=myBoardList />

    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import IsMyBoardMenu from '../../components/myPage/IsMyBoardMenu.vue'
import IsMyBoardPageForm from '../../components/myPage/IsMyBoardPageForm.vue'
import MyPageMenu from '../../components/myPage/MyPageMenu.vue'

export default {
    name: 'IsMyBoardPage',
    computed: {
      ...mapState([ "session", 'myBoardList']),
    },  
    components: { 
      IsMyBoardPageForm, MyPageMenu,
        IsMyBoardMenu  
    },
    data(){
      return{
        memberNo: this.$store.state.session.memberNo
      }
    },
    methods: {
        ...mapActions(['fetchMyBoardList']),
    },
  mounted() {
      this.fetchMyBoardList(this.session.memberId)
  }


}
</script>
