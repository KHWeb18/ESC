<template>
<div>
    
    <div>
        <notice-list-page-form :noticeList="noticeList" />
        <v-dialog  v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn v-on="on">관리자등급받기</v-btn>
               </template>
               <v-card>
               <v-card-title >
                   코드를입력하세요
               </v-card-title>
               <v-card-text>
                   <input v-model="inputcode"/>
               </v-card-text>
               
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click="getManageAuth(inputcode)">등급받기</v-btn>
               <v-btn @click.native="cancle">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
    </div>
</div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import NoticeListPageForm from '../../../components/board/notice/NoticeListPageForm.vue'

export default {
  components: { NoticeListPageForm },
    name: 'NoticeListPage',
    computed:{
        ...mapState(['noticeList'])
    },
    methods: {
        ...mapActions(['GetNoitceList','logout']),
        getManageAuth(inputcode){

            if(inputcode ==this.code){
                if(this.$store.state.auth =="일반유저"){axios.post(`https://evsbackend.herokuapp.com/member/getManageAuth/${this.$store.state.loginMemberNo}`)
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
            else{
                alert("코드가일치하지않습니다.")
            }
            
        },
        cancle(){
            this.dialog =false
        }
        
            
    },
    data(){
        return {
            dialog: false,
            inputcode: '',
            code: 'STNDW-CMVMOWQ_DMSKMCB-CMLEQ3'
        }
    },
    created(){
        this.GetNoitceList()
        
    }
}
</script>
