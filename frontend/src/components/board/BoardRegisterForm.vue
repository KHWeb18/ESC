<template>
<div>
    <!--
        <v-btn @click="check">
            작성자체크
        </v-btn>
        -->
        <section>
        <form @submit.prevent="OnSubmit">
                <v-container >
            <p>작성자:{{memberId}}</p> <!--작성자 부분은 추후 쿠키들어오면 뺼것임  -->
            <p>제목</p> 
            <v-select style="max-width:300px" :items="boardCategory"  v-model="category" label="카테고리"> </v-select>  

            <textarea name="contentTitle" id="contentTitle" cols="30" rows="10" v-model="title"></textarea>
            <p>내용 </p>
            
              <textarea name="contentText" id="contentText" cols="30" rows="10" v-model="content"></textarea>
           <p>이미지</p>
             <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
           <v-btn type="submit" v-on:click="submitFiles()">등록</v-btn>
                </v-container>
            
        </form>
        </section>
</div>
        
    
</template>

<script>
import axios from 'axios'

//import {mapState } from 'vuex'
export default {
        name: 'BoardRegisterForm',
        props: {
            
        },
        data () {
            return {
               // memberId: this.$store.state.User, <- 쿠키넣으면 이거쓸것
                memberId: '한상우', //로그인정보가없어서 이걸로 대체
                title: '',
                content: '',
                img: '',
                category: '',
                boardCategory: [
                    {text: '자유게시판', value : '자유게시판' },
                    {text: '충전소게시판', value : '충전소게시판' },
                    {text: '주차장게시판', value : '주차장게시판' }
                ]
            }
        },

        methods: {
            handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            
            this.img = this.category+"에등록된"+this.memberId+"의"+ info[0].name
        }, 
            
            OnSubmit() {
            if(this.category == ''){
                alert("게시판 카테고리를 선택하세요")
            }else {
                 const { memberId, title, content, img,category} = this
                this.$emit('submit', { memberId, title, content, img,category})
            }
               
            },
            submitFiles () {
                console.log(this.files)
                
            if (this.files == undefined){
                console.log('사진노첨부')
            }
            else{
                let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                this.files.name = this.img
                formData.append('fileList', this.files[idx])
            }
            axios.post(`http://localhost:7777/board/uploadImg/${this.memberId}/${this.category}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
            }
            
            
        },
            //...mapState[('loginUser')], 쿠키없어서 비활성화
           
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
			border: solid 2px green;
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
			border: solid 2px green;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
           
}
p{
    font-size: 2.5em;
}
</style>