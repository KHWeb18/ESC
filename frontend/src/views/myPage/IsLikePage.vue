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
import Vue from "vue";
export default {

  components: { MyPageMenu, IsMyLikeList },
  computed: {
    ...mapState([ "session",'myLikeList']),

  },  

/*   data(){
    return{
      memberNo:this.$store.state.session
    }
  },  */
  methods: {
      ...mapActions(['fetchMyLikeList']),
  },
  mounted() {
      if(this.session){
      this.fetchMyLikeList(this.session.memberNo && this.session.memberNo)
      }else{
        let data = Vue.$cookies.get("user")
        let member = data.memberNo
        this.fetchMyLikeList(member)
      }
  }
}

</script>
