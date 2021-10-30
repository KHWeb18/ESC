
<template>
   <div>
       <form @submit.prevent="OnSubmit(coin)">
       <v-container >
        <table>
            <tr>
              <td style="text-align: left;"> <input type="text" v-model="title"/><br>
              <p id="boardinfo" align="left">[{{$moment(notice.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{notice.viewcount}}]</p>
              </td>
              </tr>
              <tr style="text-align: left">
                  <img v-if="notice.img != '' && coin ==0" width="300px" :src="require(`@/assets/게시판/${notice.img}`)"/>
                     <v-btn v-if="coin ==0" @click="ModifyImg">이미지수정</v-btn>
              </tr>
              <tr>
                <td style="text-align: left">
                    <v-btn v-if="coin ==1" @click="ModifyImgCancle">이미지바꾸기취소</v-btn>
                    <input v-if="coin ==1" type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
                    <br>
                <textarea  name="contentText" id="contentText" cols="30" rows="10" v-model="content"></textarea><br>
                <v-btn type="submit" v-on:click="submitFiles(coin)">수정완료</v-btn>
                </td>
              </tr>
          </table>
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
        notice:{
            type:Object
        }
    },
    computed:{
        ...mapState(['session'])
    },
    data() {
        return{
            memberId: this.$store.state.session,
            randomNumToString: '',
            coin : 0,
            //
            title: this.notice.title,
            content: this.notice.content,
            img: this.notice.img,
            img2: '',
            
        }
    },
    methods:{
        handleFileUpload(){
            this.files = this.$refs.files.files
            const info = this.files
            // 기존이미지
            this.img = this.notice.img
            //변경된이미지
            this.img2 = this.randomNumToString+this.memberId+"의"+ info[0].name
        },
        ModifyImg(){
            this.coin = 1;
        },
        ModifyImgCancle(){
            this.img  = this.notice.img
            this.coin = 0;
        },
        OnSubmit(coin){
            if (coin == 1){
                const  {title, content ,img2} =this
                axios.post(`http://localhost:7777/notice/noticeModify/${this.notice.boardNo}`,{title, content ,img: img2})
                .then( () =>{
                    alert("수정이 완료되었습니다.")
                    this.$router.go(-1)
                } )
            }
            else{
                const  {title, content } =this
                
                axios.post(`http://localhost:7777/notice/noticeModify/${this.notice.boardNo}`,{title, content,img: this.notice.img})
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
            axios.post(`http://localhost:7777/notice/uploadImg/${this.memberId}/${this.randomNumToString}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
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
        console.log(this.notice.img)
       this.randomNumToString = String(Math.floor(Math.random() * 99999) +1 )
            
    },


}
</script>

<style scope>
#boardinfo{
    font-size: 0.6em;
}
#contentText{width:1800px; height:500px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
padding: 10px;
			box-sizing: border-box;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
}
</style>