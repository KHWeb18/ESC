<template>
  <div>
    <my-page-menu />
    <is-my-like-list  :myLikeList=myLikeList  />
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import MyPageMenu from "../../components/myPage/MyPageMenu.vue";
import IsMyLikeList from "../../components/myPage/IsMyLikeList.vue"

export default {

  components: { MyPageMenu, IsMyLikeList },
  computed: {
    ...mapState([ "session",'myLikeList']),
    // ...mapState([{
    //   session: state => state.session
    // },
    // {
    //   myLikeList: state => state.myLikeList
    // }])
  },  

/*   data(){
    console.log('state')
    console.log(this.$store.state);
    console.log('state.session')
    console.log(this.$store.state.session);
    console.log('state.loginMemberNO')
    console.log(this.$store.state.loginMemberNo);
    return{
      memberNo: this.$store.state.session.memberNo && this.$store.state.session.memberNo
    }
  }, */
  methods: {
      ...mapActions(['fetchMyLikeList']),
  },
  mounted() {
    console.log('mounted')
    console.log(this.$store.state);
    console.log(this.$store.state.session);
    const {sessionData} = this.$store.getters;
    console.log(sessionData); 
      this.fetchMyLikeList(this.session.memberNo && this.session.memberNo)
  }
}

</script>
