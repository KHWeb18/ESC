<template>
    <div>
         
        <v-container>
    <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{board.title}}</h4><br>
          <p align="left">[{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.viewcount}}추천:{{board.good}},비추천:{{board.bad}}]</p>
  <img v-if="board.img != ''" width="1000px" :src="require(`@/assets/게시판/${board.img}`)"/>
        <pre>{{board.content}}</pre>
        <v-btn @click="good(board.boardNo)">추천</v-btn><v-btn @click="bad(board.boardNo)">비추천</v-btn>
        <v-btn v-if="board.memberId == session" @click="modifying(board.boardNo)">수정</v-btn>
        <v-btn @click="report(board.boardNo)">신고하기</v-btn>
        <v-btn route :to="{name: 'FreeBoardListPage'}">글목록</v-btn>
        <v-btn @click="DeleteBoard(board.boardNo)" v-if="board.memberId == session">글삭제</v-btn>
      </v-col>
    </v-row>
  
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
//import { mapState } from 'vuex'
import Vue from 'vue'
import VueMoment from 'vue-moment'
import {mapState} from "vuex";
Vue.use(VueMoment);
export default {
    name: 'BoardReadPageForm',
    props:{
        board: {
            type: Object
        }
    },
  computed:{
    ...mapState(['session'])
  },

    methods: {
        OnSubmit() {

                const {ui , comments } = this
                axios.post(`http://localhost:9999/jpaBoard/comment/${this.board.boardNo}`, {ui, comments})
                .then( res => {
                    alert('등록성공' +res) 
                    this.$router.go()
                }).catch(err => {
                    alert(err.response.data.message)
                })

                  },
                  good(boardNo){
                    axios.post(`http://localhost:7777/board/goodCount/${boardNo}`)
                    .then( () =>{
                        alert('추천하였습니다.')
                        this.$router.go()
                    })
                  },
                  bad(boardNo){
                      axios.post(`http://localhost:7777/board/badCount/${boardNo}`)
                    .then( () =>{
                        alert('비추천하였습니다.')
                        this.$router.go()
                    })
                  },
                  report(boardNo){
                      const {reportWord} =  this
                      axios.post(`http://localhost:7777/board/report/${boardNo}`,{reportWord})
                      .then( () =>{
                          alert('게시글이 신고되었습니다.')
                          this.$router.go()
                      })
                  },
                  modifying(boardNo) {
                      this.$router.push({name: 'BoardModifyPage', params:{boardNo} })
                  },
                  DeleteBoard(boardNo){
                      
                      axios.post(`http://localhost:7777/board/DeleteBoard/${boardNo}`)
                      .then( () =>{
                          alert('글이 삭제되었습니다')
                          this.$router.push({name: 'BoardListPage'})
                      })
                  }
                  
    },
    data() {

        return {
                reportWord: '신고됨'
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


</style>
