<template>
  <div v-if="coin ==0">
      <v-container>
        <v-btn @click="chk">확인</v-btn>
            <table>
            <tr>
                <td>회원번호</td>
                <td>회원이름</td>
                <td>회원아이디</td>
                <td>회원상태</td>
                <td>비고</td>

            
            </tr>
            <tr v-for="p in paginatedData" :key="p.memberNo">
                <td>{{p.memberNo}}</td>
                <td>{{p.name}}</td>
                <td>{{p.memberId}}</td>
                <td>{{p.status}}</td>
                <td><v-btn @click="ban(p.memberNo)">정지</v-btn>
                <v-btn @click="jailbreak(p.memberNo)">해제</v-btn>

                    </td>    

                
                
            
            </tr>
            </table>
            <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            <form @keyup.enter="searching(searchMenus,search)">

                <v-row style="margin-left: 80%">
                <v-select  style="max-width: 100px" :items="searchMenu" label="검색" v-model="searchMenus"/>
                <v-text-field  style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
                </v-row>

            </form>
            </div>
        </v-container>
  </div>
   <div v-else-if="coin ==1">
      <v-container>
        <v-btn @click="chk">확인</v-btn>
            <table>
            <tr>
                <td>회원번호</td>
                <td>회원이름</td>
                <td>회원아이디</td>
                <td>회원상태</td>
                <td>비고</td>

            
            </tr>
            <tr v-for="p in searchpaginatedData" :key="p.memberNo">
                <td>{{p.memberNo}}</td>
                <td>{{p.name}}</td>
                <td>{{p.memberId}}</td>
                <td>{{p.status}}</td>
                <td><v-btn @click="ban(p.memberNo)">정지</v-btn>
                <v-btn @click="jailbreak(p.memberNo)">해제</v-btn>

                    </td>    

                
                
            
            </tr>
            </table>
            <!--검색후-->
            <div class="btn-cover">
            <button :disabled="searchpageNum === 0" @click="searchPrevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ searchpageNum + 1 }} / {{ searchpageCount }}</span>
            <button :disabled="searchpageNum >= searchpageCount - 1" @click="searchNextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            <form @keyup.enter="searching(searchMenus,search)">

                <v-row style="margin-left: 80%">
                <v-select  style="max-width: 100px" :items="searchMenu" label="검색" v-model="searchMenus"/>
                <v-text-field  style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
                </v-row>
                <v-btn @click="showAll()">검색해제</v-btn>
            </form> 
            </div>
        </v-container>
  </div> 
</template>

<script>
import axios from 'axios'
export default {
  name: 'paginated-list',
  data () {
    return {
      search:'',
      pageNum: 0,
      searchpageNum: 0,
      dialog: false,
      dialog2: false,
      coin: 0,
      searchMenus: '',
      searchMenu: [
        {text: '회원번호', value: '회원번호'},
        {text: '회원이름', value: '회원이름'},
        {text: '아이디', value: '아이디'},
      ],
      searchList: [],

    }
  },
  props: {
    memberList: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 10
    }
  },
  methods: {
      chk(){
          console.log(this.memberList[0].memberAuthList[0].auth)

      },
      showAll(){
        this.coin =0
      },
      ban(memberNo){
          console.log(memberNo)
          axios.post(`http://localhost:7777/member/IDban/${memberNo}`)
          .then( () =>{
              alert("해당아이디는 정지 하였습니다.")
              this.$router.go()
          })
      },
      jailbreak(memberNo){
          console.log(memberNo)
          axios.post(`http://localhost:7777/member/jailbreak/${memberNo}`)
          .then( () =>{
              alert("정지 해제 되었습니다.")
              this.$router.go()
          })
      },
      searching(searchMenus,search){
        if(searchMenus ==''){
        alert("찾는 카테고리를 선택해주세요")
        }
        if(searchMenus == '회원번호'){
          
          axios.post(`http://localhost:7777/member/findALLByNo/${search}`)
          .then( (res) =>{
              if(res.data ==""){
                alert("해당 회원번호는 존재하지않습니다.")
              }
              else{this.searchList = res.data 
              this.coin = 1;}
              
          }).catch((err) =>{
            console.log(err.response.data.message)
            alert("숫자를입력해주세요")
          })
        }
        else if(searchMenus =='회원이름'){
          axios.post(`http://localhost:7777/member/findALLByName/${search}`)
          .then( (res) =>{
              if(res.data ==""){
                alert("해당 회원이름는 존재하지않습니다.")
              }
              else{this.searchList = res.data 
              this.coin = 1;}
          } )
        }
        else if (searchMenus == '아이디')
        axios.post(`http://localhost:7777/member/findALLById/${search}`)
          .then( (res) =>{
              if(res.data ==""){
                alert("해당 아이디는 존재하지않습니다.")
              }
              else{this.searchList = res.data 
              this.coin = 1;}
          } )
      },
      cancle(){
          this.dialog = false
          this.dialog2 =false
      },
     nextPage () {
      this.pageNum += 1;
    },
    searchNextPage(){
      this.searchpageNum +=1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    searchPrevPage() {
      this.searchpageNum -=1;
    },
  },
  computed: {
    pageCount () {
      let listLeng = this.memberList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    searchpageCount () {
      let listLeng = this.searchList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.memberList.slice(start, end);
    },
    searchpaginatedData () {
      const start = this.searchpageNum * this.pageSize,
            end = start + this.pageSize;
      return this.searchList.slice(start, end);
    },
    
  }
}
</script>

<style>
table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.2rem;
}
table tr {
  height: 2rem;
  text-align: center;
  border-bottom: 1px solid #505050;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1.1rem;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}
</style>