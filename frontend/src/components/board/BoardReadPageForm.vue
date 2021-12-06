<template>
    <div>
         <v-container style="max-width: 1080px">
         <v-card  elevation="1">
           <v-card-title style="text-align: center;">
             {{board.title}}
           </v-card-title>
           <v-card-subtitle>
             [{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.viewcount}}좋아요:{{board.good}},싫어요:{{board.bad}}]

             <v-btn style="margin-left: 81%" @click="goBack">목록</v-btn>
              <!--<v-btn style="margin-left: 81%" route :to="({name: 'FreeBoardListPage'})">목록</v-btn> -->

             <v-btn  v-if="session" @click="modifying(board.boardNo)">수정</v-btn>


             <v-dialog  v-if="session"  v-model="dialog2" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn     v-on="on">삭제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   정말 삭제하시겟습니까?
               </v-card-title>
               
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click="DeleteBoard(board.boardNo)">확인</v-btn>
               <v-btn @click.native="cancle2">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog> 
           </v-card-subtitle>
           <v-divider></v-divider>
           <v-card-text>
             <img v-if="board.img != ''" width="300px" :src="require(`@/assets/게시판/${board.img}`)"/>
           </v-card-text>
           <v-card-text style="height: 300px;">
             {{board.content}}
           </v-card-text>
           <v-divider></v-divider>
           <v-card-actions>
             <v-dialog  v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn    dark v-on="on">신고</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   정말 신고하시겟습니까?
               </v-card-title>
               
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn @click="report(board)">확인</v-btn>
               <v-btn @click.native="cancle">취소</v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
                <v-btn style="margin-left: 81%" @click="good(board.boardNo)"><v-icon>mdi-thumb-up</v-icon></v-btn> 
                <v-btn @click="bad(board.boardNo)"><v-icon>mdi-thumb-down</v-icon></v-btn>
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
        board: {
            type: Object
        }
    },
  computed:{
    ...mapState(['session','loginMeberNo',])
    
  },
  created(){

    
   
  },
    methods: {
        ...mapActions(['findMemberInfo']),
                  goBack() {
                    this.$router.go(-1)
                  },
                  good(boardNo){
                    if(this.session ==undefined){
                      alert('로그인 이후 가능합니다.')
                    }
                    else{
                    axios.post(`https://evsbackend.herokuapp.com/member/addLikeBoard/${boardNo}`,{memberNo:this.$store.state.loginMemberNo})
                    .then( (res) =>{
                      alert(res.data)
                      if(res.data =="추천되었습니다."){
                          axios.post(`https://evsbackend.herokuapp.com/board/goodCount/${boardNo}`)
                          .then( () =>{
                           
                            this.$router.go()
                    })
                      }

                    })  
                    }
                    
                  },
                  
                  bad(boardNo){
                    if(this.session ==undefined){
                      alert('로그인 이후 가능합니다.')
                    }
                    else{
                        axios.post(`https://evsbackend.herokuapp.com/member/addHateBoard/${boardNo}`,{memberNo:this.$store.state.loginMemberNo})
                    .then( (res) =>{
                      alert(res.data)
                      if(res.data =="비추되었습니다."){
                        axios.post(`https://evsbackend.herokuapp.com/board/badCount/${boardNo}`)
                        .then( () =>{
                          this.$router.go()
                        })
                      }
                    })
                    }
                    
                  },
                  
                  report(board){
                      
                      const {reportWord} =  this
                      axios.post(`https://evsbackend.herokuapp.com/board/report/${reportWord}`,{boardNo: board.boardNo, memberId: board.memberId,})
                      .then( () =>{
                          alert('게시글이 신고되었습니다.')
                          this.dialog =false
                         

                      })
                  },
                  modifying(boardNo) {
                    if(this.session.memberId ==this.board.memberId){
                      this.$router.push({name: 'BoardModifyPage', params:{boardNo} })
                    }
                    else{
                      alert('작성자 외에 수정할 수 없습니다.')
                    }
                      
                  },
                  DeleteBoard(boardNo){
                      if(this.session.memberId ==this.board.memberId){
                        axios.post(`https://evsbackend.herokuapp.com/board/DeleteBoard/${boardNo}`)
                      .then( () =>{
                          alert('글이 삭제되었습니다')
                          this.$router.push({name: 'FreeBoardListPage'})
                      })
                      }
                      else{
                        alert('작성자 외에 삭제할 수 없습니다.')
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
  font-size: 1.6em;
}
#contentArea{
  height: 300px;
}
#boardTitle{
  font-family: 'Oswald', sans-serif;
  font-size: 2.5em
}
</style>
