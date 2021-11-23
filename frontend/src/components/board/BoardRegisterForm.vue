<template>
<div >
        <!--
        <form @submit.prevent="OnSubmit">
            <v-row><v-select  outlined style="max-width:300px" :items="boardCategory"  v-model="category" label="카테고리"> </v-select>
           <v-text-field style="max-width:700px" outlined label="제목을입력하세요"  v-model="title"></v-text-field></v-row>
           <v-row>
              <textarea  name="contentText" id="contentText" cols="30" rows="10" v-model="content"></textarea>
           </v-row>
           <v-row>
             <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
           <v-btn class="blue white--text" style="margin-left: 44.2%" type="submit" v-on:click="submitFiles()">등록</v-btn>
           </v-row>
        </form>
        -->
        <v-container style="max-width:1000px;">
        <form @submit.prevent="OnSubmit">
            <v-card >
                <v-divider></v-divider>
                <v-card-title>
                   <v-select  outlined style="max-width:150px" :items="boardCategory"  v-model="category" label="카테고리"> </v-select>
                    <v-text-field style="max-width:850px;" outlined label="제목을입력하세요"  v-model="title"></v-text-field>
                </v-card-title>
                <v-divider></v-divider>
                <v-card-title>
                    <textarea  name="contentText" id="contentText" cols="30" rows="10" v-model="content"></textarea>
                </v-card-title>
                <v-divider></v-divider>
                <v-card-title>
                    <v-row>
                    <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
                    <v-btn depressed style="margin-left: 46.7%" type="submit" v-on:click="submitFiles()">등록</v-btn><v-btn @click="cancle()"  depressed>취소</v-btn>
                    </v-row>
                </v-card-title>
            </v-card>
        </form>
        </v-container>
</div>
        
    
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
//import {mapState } from 'vuex'
export default {
        name: 'BoardRegisterForm',
        props: {
            
        },
        computed:{
            ...mapState(["session"])
        },
        data () {
            return {
                
                randomNumToString: '',
               // memberId: this.$store.state.User, <- 쿠키넣으면 이거쓸것
                 //로그인정보가없어서 이걸로 대체
                title: '',
                content: '',
                img: '',
                category: '',
                boardCategory: [
                    {text: '자유게시판', value : '자유게시판' },
                    {text: '충전소게시판', value : '충전소게시판' },
                    {text: '주차장게시판', value : '주차장게시판' },
                    {text: '건의게시판', value : '건의게시판' }
                ]
            }
        },
        methods: {
            ...mapActions(["cookieToSession"]),
            handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            
            this.img = this.randomNumToString+this.session.memberId+"의"+ info[0].name
        }, 
            
            OnSubmit() {
            if(this.category == ''){
                alert("게시판 카테고리를 선택하세요")
            }else {
                 const {  title, content, img, category} = this
                this.$emit('submit', { memberId:this.session.memberId, title, content, img, category})
            }
               
            },
            submitFiles () {
                
                
            if (this.files == undefined){
                console.log('사진노첨부')
            }
            else{
                let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                this.files.name = this.img
                formData.append('fileList', this.files[idx])
            }
            axios.post(`https://evsbackend.herokuapp.com/board/uploadImg/${this.session.memberId}/${this.randomNumToString}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
            }
            
            
        },
        cancle(){
            this.$router.back()
        }
            
           
        },
        created() {
            this.randomNumToString = String(Math.floor(Math.random() * 99999) +1 )
            console.log(this.randomNumToString)
          
        },
        
        
    
}
</script>

<style scoped>
#contentText{width:1000px; height:500px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
padding: 10px;
			box-sizing: border-box;
			border: solid 2px black;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
}
#contentTitle{width:1000px; height:50px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 padding: 10px;
			box-sizing: border-box;
			border: solid 2px black;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
           
}
p{

}
</style>
