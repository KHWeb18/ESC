<template>
    <div>
         <v-container style="max-width: 1080px">
         <v-card elevation="1">
           <v-card-title style="text-align: center;">
             {{notice.title}}
           </v-card-title>
           <v-card-subtitle>
             [{{$moment(notice.createDate).format('YYYY-MM-DD/hh:mm')}} 분류:{{notice.category}} 조회{{notice.viewcount}}]
             <v-btn style="margin-left: 81%"  route :to="({name: 'NoticeListPage'})">목록</v-btn>
             <v-btn  v-if="session" @click="modifying(notice.boardNo)">수정</v-btn>
             <v-dialog  v-model="dialog2" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn   v-if="session"  v-on="on">삭제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   정말 삭제하시겟습니까?
               </v-card-title>
               
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click="DeleteBoard(notice.boardNo)">확인</v-btn>
               <v-btn @click.native="cancle2">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
           </v-card-subtitle>
           <v-divider></v-divider>
           <v-card-text>
             <img v-if="notice.img != ''" width="300px" :src="require(`@/assets/게시판/${notice.img}`)"/>
           </v-card-text>
           <v-card-text>
             {{notice.content}}
           </v-card-text>
           <v-divider></v-divider>
           <v-card-actions>
           </v-card-actions>
         </v-card>
         
         </v-container>
    </div>
</template>

<script>
import axios from 'axios'
//import { mapState } from 'vuex'
import Vue from 'vue'
import VueMoment from 'vue-moment'
import {mapActions, mapState} from "vuex";
Vue.use(VueMoment);
export default {
    name: 'BoardReadPageForm',
    props:{
        notice: {
            type: Object
        }
    },
  computed:{
    ...mapState(['session','loginMeberNo','memberInfo'])
    
  },
  created(){
    if(this.$store.state.loginMemberNo != null){
      this.findMemberInfo(this.$store.state.loginMemberNo)
    }
    
   
  },
    methods: {
        ...mapActions(['findMemberInfo']),
                  
                  modifying(boardNo) {
                    if(this.session.memberId ==this.notice.memberId) {
                        this.$router.push({name: 'NoticeModifyPage', params:{boardNo} })
                    }
                    else{
                      alert("작성자 외 수정할 수 없습니다.")
                    }
                      
                  },
                  DeleteBoard(boardNo){
                    
                      if(this.session.memberId ==this.notice.memberId){
                           axios.post(`http://localhost:7777/notice/DeleteBoard/${boardNo}`)
                      .then( () =>{
                          alert('글이 삭제되었습니다')
                          this.$router.push({name: 'NoticeListPage'})
                      })
                      }
                      else{
                        alert("작성자 외 삭제할 수 없습니다.")
                      }
                     
                  },
                  cancle(){
                    this.dialog= false
                  },
                  cancle2(){
                    this.dialog2 = false
                  }
    },
    data() {

        return {
                reportWord: '신고됨',
                coin: 0,
                dialog: false,
                dialog2: false,
               }
           },
           

    
  
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Oswald&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Luckiest+Guy&family=Noto+Serif+KR:wght@700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+SC:wght@300&display=swap');
pre{
    width: 1000px;
    border-block: 1px;
}
h4{
   font-family: 'Noto Serif KR', serif;
}

P{
    font-family: 'Oswald', sans-serif;
}
pre{
font-family: 'Noto Sans SC', sans-serif;
}
#input-usage .v-input__prepend-outer,
  #input-usage .v-input__append-outer,
  #input-usage .v-input__slot,
  #input-usage .v-messages {
    border: 1px dashed rgba(0,0,0, .4);
  }
#boardinfo{
  font-size: 0.6em;
}
#contentArea{
  height: 300px;
}

</style>
