<template>
    <div>
         <v-btn v-if="board.memberId == '한상우'" @click="Modifyfing">수정</v-btn> <!--세션없어서 제이름넣었습니다-->
        <v-container>
    <v-row id="input-usage">
      <v-col cols="12">
          <h4>{{board.title}}</h4><br>
          <p align="left">[{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.viewcount}}추천:{{board.good}},비추천:{{board.bad}}]</p>
  <img v-if="board.img != ''" width="1000px" :src="require(`@/assets/게시판/${board.img}`)"/>
        <pre>{{board.content}}</pre>
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
Vue.use(VueMoment);
export default {
    name: 'BoardReadPageForm',
    props:{
        board: {
            type: Object
        }
    },

    methods: {
        check() {
            console.log(this.board)
           },

        ModifyOn(boardCommentNo){

                this.commentBox = 0
                this.Modify = boardCommentNo

                                },

        ModifyOFF(){

                this.commentBox = 1
                this.Modify = null

                   },

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

        CommemtsModify(item){

            console.log(item)
            const {boardCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaBoard/ModifyComments/${this.board.boardNo}`,{ui,boardCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                            },
        
        deleteComment(boardCommentNo){
            
               console.log(boardCommentNo)
            axios.delete(`http://localhost:9999/jpaBoard/deleteComment/${boardCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },

        checkingman(value) {
                console.log(value)
                          },
        Modifyfing(){
            this.$router.push({ name: 'CommunityModifyPage', params: {board: this.board}})
        },
          appendIconCallback () {},
      prependIconCallback () {},
    },
    data() {

        return {

            comments: '',
            ui: this.$store.state.User,
            Modify: '',
            commentBox: 1,
            text: ''

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
    height: 700px;
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