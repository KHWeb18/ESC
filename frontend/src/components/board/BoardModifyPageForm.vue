
<template>
   <div>
        <v-container>
            <form @submit.prevent="OnSubmit(coin)">
            <input type="text" v-model="title"/>
            <p align="left">[{{$moment(board.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{board.viewcount}}추천:{{board.good}},비추천:{{board.bad}}]</p>
            <v-btn v-if="coin ==0" @click="ModifyImg">이미지바꾸기</v-btn>
            <v-btn v-if="coin ==1" @click="ModifyImgCancle">이미지바꾸기취소</v-btn>
            <input v-if="coin ==1" type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
            <img v-if="board.img != '' && coin ==0" width="1000px" :src="require(`@/assets/게시판/${board.img}`)"/>
            <p>내용</p>
            <pre><input type="text" v-model="content"/></pre>
            <v-btn type="submit" v-on:click="submitFiles(coin)">수정완료</v-btn>
            </form>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'BoardModifyPageForm',
    props:{
        board:{
            type:Object
        }
    },
    data() {
        return{
            memberId: '한상우',
            randomNumToString: '',
            coin : 0,
            //
            title: this.board.title,
            content: this.board.content,
            img: '',
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
                axios.post(`http://localhost:7777/board/boardModify/${this.board.boardNo}`,{title, content ,img: img2})
                .then( () =>{
                    alert("수정이 완료되었습니다.")
                    this.$router.go(-1)
                } )
            }
            else{
                const  {title, content } =this
                
                axios.post(`http://localhost:7777/board/boardModify/${this.board.boardNo}`,{title, content,img: this.board.img})
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
                this.files.name = this.img
                formData.append('fileList', this.files[idx])
            }
            axios.post(`http://localhost:7777/board/uploadImg/${this.memberId}/${this.randomNumToString}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
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
            
    }
}
</script>