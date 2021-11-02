<template>
    <div>
        <customer-service-board-menu/>
        <notice-list-page-form :noticeList="noticeList" />
        <v-btn @click="getManageAuth" >관리자등급받기</v-btn>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import NoticeListPageForm from '../../../components/board/notice/NoticeListPageForm.vue'
import CustomerServiceBoardMenu from '../../../components/board/CustomerServiceBoardMenu.vue'
export default {
  components: { NoticeListPageForm, CustomerServiceBoardMenu },
    name: 'NoticeListPage',
    computed:{
        ...mapState(['noticeList'])
    },
    methods: {
        ...mapActions(['GetNoitceList','logout']),
        getManageAuth(){
            if(this.$store.state.auth =="일반유저"){axios.post(`http://localhost:7777/member/getManageAuth/${this.$store.state.loginMemberNo}`)
            .then( () =>{
                alert('관리자 등급을받았습니다. 다시로그인해주세요')
                this.logout()
                this.$router.push({name: 'LoginPage'})
                

            })
        }
        else{
            alert("이미관리자등급입니다.")
        }
        }
        
            
    },
    created(){
        this.GetNoitceList()
        
    }
}
</script>