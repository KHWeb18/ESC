<template>
  <div v-if="coin == 0">
      <v-container>
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일자</th>
        <th>조회수</th>
        <th>추천</th>
        <th>비추천</th>
      </tr>
      <tr  v-for="p in paginatedData" :key="p.no">
        <td>{{p.boardNo}}</td>
        <td  @click="goDetail(p.boardNo)">{{p.title}}</td>
        <td>{{p.memberId}}</td>
        <td>{{$moment(p.createDate).format('YYYY-MM-DD/hh:mm')}}</td>
        <td>{{p.viewcount}}</td>
        <td style="width:70px">{{p.good}}</td>
        <td style="width:70px">{{p.bad}}</td>
      </tr>
    </table>

    <div class="btn-cover"><button :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
    <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} Page</span>
    <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
    <v-row>
    <v-select  style="max-width: 100px" :items="searchMenu" label="검색" v-model="searchMenus"/>
    <v-text-field style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
    </v-row>
    <v-btn @click="searching(searchMenus,search)">검색하기</v-btn>
      <v-btn route :to="{name: 'BoardRegister'}">글쓰기</v-btn>
    </div> 
    </v-container>
  </div>

  <div v-else>
    <v-container>
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일자</th>
        <th>조회수</th>
        <th>추천</th>
        <th>비추천</th>
      </tr>
      <tr  v-for="p in searchpaginatedData" :key="p.no">
        <td>{{p.boardNo}}</td>
        <td  @click="goDetail(p.boardNo)">{{p.title}}</td>
        <td>{{p.memberId}}</td>
        <td>{{$moment(p.createDate).format('YYYY-MM-DD/hh:mm')}}</td>
        <td>{{p.viewcount}}</td>
        <td style="width:70px">{{p.good}}</td>
        <td style="width:70px">{{p.bad}}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <button :disabled="searchpageNum === 0" @click="searchPrevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
      <span class="page-count">{{ searchpageNum + 1 }} / {{ searchpageCount }} Page</span>
      <button :disabled="searchpageNum >= searchpageCount - 1" @click="searchNextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
    <v-row>
      <v-select  style="max-width: 100px" :items="searchMenu" label="검색" v-model="searchMenus"/>
      <v-text-field style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
      </v-row>
      <v-btn @click="searching(searchMenus,search)">검색하기</v-btn>
      <v-btn @click="showAllBoard()"> 게시글전체보기</v-btn>
    </div><v-btn route :to="{name: 'BoardRegister'}">글쓰기</v-btn>
    </v-container>
  </div>

</template>

<script>
import axios from 'axios';
export default {
  name: 'ParkingBoardListForm',
  data () {
    return {
      searchMenus: '',
      pageNum: 0,
      searchpageNum: 0,
      search: '',
      ip: '',
      coin: 0,
      searchList: [],
      searchMenu: [
        {text: '글제목', value:'글제목'},
        {text: '작성자' , value:'작성자'}
      ]
     
    }
  },
  props: {
    TargetList: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 5
    }
  },
  methods: {
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
    goDetail(boardNo){
        this.$router.push({name: 'BoardReadPage', params:{boardNo}})

        axios.post(`http://localhost:7777/board/viewcount/${boardNo}`)
        .then( () =>{

        })
    },
    searching(searchMenus,search){
      if(searchMenus ==''){
        alert("찾는 카테고리를 선택해주세요")
      }
      if(searchMenus =="글제목"){
      axios.post(`http://localhost:7777/board/titleSearchList/${search}`)
      .then( (res)=> {
        if(res.data == ''){
          alert("해당검색어로 검색되는 글이 존재하지않습니다.")
        }
        else{
          this.searchList = res.data,
          this.coin= 1}
       
      }
        
        
        )
      }

      if(searchMenus =="작성자"){axios.post(`http://localhost:7777/board/memberIdSearchList/${search}`)
      .then( (res)=>{
        if(res.data == ''){
           alert("해당검색어로 검색되는 글이 존재하지않습니다.")
        }
        else{
          this.searchList = res.data,
          this.coin= 1
        }
      }
    
        )
      }
      
    },
    showAllBoard(){
      this.coin = 0;
    },
    check(){
      console.log("확인")
    }

  },
  computed: {
      
    pageCount () {
      let listLeng = this.TargetList.length,
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
      return this.TargetList.slice(start, end);
    },
    searchpaginatedData () {
      const start = this.searchpageNum * this.pageSize,
            end = start + this.pageSize;
      return this.searchList.slice(start, end);
    },
  },
  created(){
      
    axios.post('https://ipapi.co/json/')
    .then( (res) =>{
      this.ip = res.data.ip
      console.log(this.ip)
    })
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