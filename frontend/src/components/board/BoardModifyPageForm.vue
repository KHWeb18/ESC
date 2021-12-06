
<template>
   <div>
       <form @submit.prevent="OnSubmit(coin)">
       <v-container >
          <v-card>
              <v-card-title>
                  <input type="text" v-model="title"/>
              </v-card-title>
              <v-divider></v-divider>
              <v-card-title>
                  <img v-if="board.img != '' && coin ==0" width="300px" :src="require(`@/assets/게시판/${board.img}`)"/>
              </v-card-title>
              <v-divider></v-divider>
              <v-card-subtitle>
                  <v-btn v-if="coin ==0" @click="ModifyImg">이미지수정</v-btn>
                    <v-btn v-if="coin ==1" @click="ModifyImgCancle">이미지바꾸기취소</v-btn>
                    <input v-if="coin ==1" type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
              </v-card-subtitle>
              <v-divider></v-divider>
              <v-card-subtitle>
                  <textarea   cols="240" rows="10" v-model="content"></textarea>
              </v-card-subtitle>
              <v-divider></v-divider>
              <v-card-actions>
                  <v-btn type="submit" v-on:click="submitFiles(coin)">수정완료</v-btn>
              </v-card-actions>
          </v-card>
       </v-container>
       </form>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'

export default {
    name: 'BoardModifyPageForm',
    props:{
        board:{
            type:Object
        }
    },
    computed:{
        ...mapState(['session'])
    },
    data() {
        return{
            memberId: this.$store.state.session.memberId,
            randomNumToString: '',
            coin : 0,
            //
            title: this.board.title,
            content: this.board.content,
            img: this.board.img,
            img2: '',
            
        }
    },
    methods:{
        handleFileUpload(){
            this.files = this.$refs.files.files
            const info = this.files
            // 기존이미지
            this.img = this.board.img
            //변경된이미지
            this.img2 = this.randomNumToString+this.memberId+"의"+ info[0].name
        },
        ModifyImg(){
            this.coin = 1;
        },
        ModifyImgCancle(){
            this.img  = this.board.img
            this.coin = 0;
        },
        OnSubmit(coin){
            if (coin == 1){
                const  {title, content ,img2} =this
                axios.post(`https://evsbackend.herokuapp.com/board/boardModify/${this.board.boardNo}`,{title, content ,img: img2})
                .then( () =>{
                    alert("수정이 완료되었습니다.")
                    this.$router.go(-1)
                } )
            }
            else{
                const  {title, content } =this
                
                axios.post(`https://evsbackend.herokuapp.com/board/boardModify/${this.board.boardNo}`,{title, content,img: this.board.img})
                .then( () =>{
                    alert("수정이 완료되었습니다.")
                    this.$router.go(-1)
                })
            }
        },
        submitFiles (coin) {
                        if(coin == 1){
                            if (this.files == undefined){
                console.log('사진노첨부')
            }
            else{
                let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                this.files.name = this.img2
                formData.append('fileList', this.files[idx])
            }
            axios.post(`https://evsbackend.herokuapp.com/board/uploadImg/${this.memberId}/${this.randomNumToString}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
            }
                        }
                        else{
                            console.log("사진변경없음")
                        }
                
            
            
            
        },
    },
    created(){
        console.log(this.board.img)
       this.randomNumToString = String(Math.floor(Math.random() * 99999) +1 )
            
    },


}
</script>

<style scope>
#boardinfo{
    font-size: 0.6em;
}

</style>
