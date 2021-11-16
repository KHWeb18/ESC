<template>
    <div v-if="session">
      <my-page-menu/>
      <is-my-board-menu/> 
      <is-my-board-page-form :myBoardList=myBoardList />
      {{ session }}
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import IsMyBoardMenu from '../../components/myPage/IsMyBoardMenu.vue'
import IsMyBoardPageForm from '../../components/myPage/IsMyBoardPageForm.vue'
import MyPageMenu from '../../components/myPage/MyPageMenu.vue'
import Vue from "vue";

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
        memberNo: ''
      }
    },
    methods: {
        ...mapActions(['fetchMyBoardList']),
    },
  mounted() {
      if(this.session){
        this.fetchMyBoardList(this.session.memberId)
      }else{
        let data = Vue.$cookies.get("user");
        let member = data.memberId;
        this.fetchMyBoardList(member)
      }

  }


}
</script>
