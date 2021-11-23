<template>
<div>
    <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on"><v-btn style="position: absolute;" @click="ModeChange()"><v-icon>mdi-table</v-icon></v-btn></span>
          </template>
          <span>게시글 형태을 변환합니다!</span>
        </v-tooltip>
          <board-menu class="hidden-xs-only" :boardList="boardList"/>
          <board-menu-of-xs class="hidden-xl-only" :boardList="boardList"/>
<div v-if="coin ==0&&this.tableMode ==1">
    <v-container style="max-width:1000px;">
      <v-simple-table >
        <template v-slot:default>
          <thead>
            <tr style="text-align: center;">
              <td>분류</td>
              <td>번호</td>
              <td>제목</td>
              <td>글쓴이</td>
              <td><v-icon>mdi-clock-outline</v-icon></td>
              <td><v-icon>mdi-eye</v-icon></td>
            </tr>
          </thead>
          <tbody>
          <tr @click="goDetail(p.boardNo)" style="text-align: center;"  v-for="p in paginatedData" :key="p.boardNo">
            <td>{{p.category}}</td>
            <td style="margin-right:50px">{{p.boardNo}}</td>
            <td>{{p.title}}</td>
            <td>{{p.memberId}}</td>
            <td>{{$moment(p.createDate).format('YYYY-MM-DD/hh')}}</td>
            <td>{{p.viewcount}}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
    </v-container>
</div>


<div v-else-if="coin ==1&&tableMode ==1">
    <v-container style="max-width:1000px;">
      <v-simple-table >
        <template v-slot:default>
          <thead>
            <tr style="text-align: center;">
              <td>번호</td>
              <td>제목</td>
              <td>글쓴이</td>
              <td><v-icon>mdi-clock-outline</v-icon></td>
              <td><v-icon>mdi-eye</v-icon></td>
            </tr>
          </thead>
          <tbody>
            <tr style="text-align: center;"  v-for="p in searchpaginatedData" :key="p.boardNo">
              <td style="margin-right:50px">{{p.boardNo}}</td>
              <td @click="goDetail(p.boardNo)">{{p.title}}</td>
              <td>{{p.memberId}}</td>
              <td>{{$moment(p.createDate).format('YYYY-MM-DD/hh')}}</td>
              <td>{{p.viewcount}}</td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </v-container>
</div>


<div v-else-if="coin ==0&&cardMode ==1">
   <v-container style="max-width: 1000px">
  <v-row>
    <v-card class="mx-auto my-12" width="250"  v-for="i in paginatedData" :key="i.boardNo" @click="goDetail(i.boardNo)" outlined hover>
    <v-card-title>{{i.memberId}}</v-card-title>
    <v-divider class="mx-4"></v-divider>
    <v-card-title>{{i.title}}</v-card-title>
    <v-card-subtitle>[{{$moment(i.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{i.viewcount}}]</v-card-subtitle>
    <v-img v-if="i.img != ''" width="250px" height="150" :src="require(`@/assets/게시판/${i.img}`)"></v-img>
    <v-img v-else-if="i.img == ''" width="250px" height="150" :src="require('@/assets/게시판/사진없음.jpg')"></v-img>
    <v-divider class="mx-4"></v-divider>
    </v-card>
  </v-row>
   </v-container>
</div>


<div v-else-if="coin ==1&&cardMode ==1">
  <v-container style="max-width: 1000px">
  <v-row>
    <v-card class="mx-auto my-12" width="250" v-for="i in searchpaginatedData" :key="i.boardNo" @click="goDetail(i.boardNo)" outlined hover>
    <v-card-title>{{i.memberId}}</v-card-title>
    <v-card-title>{{i.title}}</v-card-title>
    <v-card-subtitle>[{{$moment(i.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{i.viewcount}}]</v-card-subtitle>
    <v-img v-if="i.img != ''" width="250" height="150" :src="require(`@/assets/게시판/${i.img}`)"></v-img>
    <v-img v-else-if="i.img == ''" width="250" height="150" :src="require('@/assets/게시판/사진없음.jpg')"></v-img>
    <v-divider class="mx-4"></v-divider>
    </v-card>
  </v-row>
  </v-container>
</div>
<v-container style="max-width: 1000px">
  <v-btn v-if="coin ==1" @click="coin = 0" >검색해제</v-btn>
    <v-card dark id="option" style="max-height: 115px;" class="hidden-xs-only">
      <input style="position: absolute; margin-left: 40%; margin-top:9%" v-model="filterSearch" placeholder="필터검색" @input="handleSearchInput" @keydown.tab="KeydownTab"/>
       <v-btn style="position:absolute; margin-top:77px" @click="Write()">글쓰기</v-btn>
      <v-card-text>
  <div class="btn-cover">
    <button :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
    <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
    <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
    <form @keyup.enter="searching(searchMenus,search)">
        <v-row  >
          <v-select  style="max-width: 100px; margin-left: 570px;" :items="searchMenu" label="검색" v-model="searchMenus"/>
          <v-text-field  style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
        </v-row>
      </form>
    </div>
      </v-card-text>
    </v-card>
    <v-card  dark class="hidden-xl-only hidden-md-only hidden-lg-only hidden-sm-only">
       <v-btn  @click="Write()">글쓰기</v-btn>
        <button style="margin-left: 23%" :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
    <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
    <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
    <v-card-subtitle>
      <form @keyup.enter="searching(searchMenus,search)">
       <v-select :items="searchMenu" label="검색" v-model="searchMenus"/>
          <v-text-field  v-model="search" label="검색란"></v-text-field>
      </form>
    </v-card-subtitle>
    </v-card>
    </v-container>
</div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios';
import { mapActions, mapState } from 'vuex';
import BoardMenu from '../../board/boardMenu.vue';
import BoardMenuOfXs from '../../board/boardMenuOfXs.vue';
Vue.use(cookies)
export default {
  name: 'FreeBoardListForm',
  components:{
    BoardMenu,BoardMenuOfXs
  },
  data () {
    return {
      //tableMode: 1,
      //cardMode: 0,
      searchMenus: '',
      pageNum: 0,
      searchpageNum: 0,
      search: '',
      ip: '',
      coin: 0,
      filterSearch: '',
      searchList: [],
      searchMenu: [
        {text: '글제목', value:'글제목'},
        {text: '분류' , value:'분류'}
      ],
      selectedItem: 1,
      AllBoardLength: null
     
    }
  },
  props: {
    noticeList: {
      type: Array,
      required: true
    },
    pageSize: {
      type: Number,
      required: false,
      default: 8
    }
  },
  mounted(){
    console.log('넘버',Number(this.boardList.length))
    this.AllBoardLength = Number(this.boardList.length)
  },
  methods: {
    chkeccsd(){
      console.log(this.boardList.length)
      this.AllBoardLength = Number(this.boardList.length)
    },
    ...mapActions(['SetTableMode', 'SetCardMode','GetNoitceList','fetchBoardList']),
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

        if(this.$store.state.session == null){
          alert("로그인후 이용해주세요")
          this.$router.push({name: 'LoginPage'})
        }
        else{
          this.$router.push({name: 'NoticeReadPage', params:{boardNo}})

        axios.post(`http://localhost:7777/board/viewcount/${boardNo}`)
        .then( () =>{

        })
        }
        
    },
    viewcount(boardNo){
      console.log("동작")
      axios.post(`http://localhost:7777/notice/viewcount/${boardNo}`)
        .then( () =>{

        })
    },
    searching(searchMenus,search){
      if(searchMenus ==''){
        alert("찾는 카테고리를 선택해주세요")
      }
      if(searchMenus =="글제목"){
        this.searchList.length = 0
        console.log('동작')
      axios.post(`http://localhost:7777/notice/titleSearchList/${search}`)
      .then( (res)=> {
        if(res.data == ''){
          alert("해당검색어로 검색되는 글이 존재하지않습니다.")
        }
        else{
          
              for(var i = 0; i <res.data.length; i++){
            this.searchList.push(res.data[i])
          }
         
          
          
          this.coin= 1}
       
      }
        
        
        )
      }

      if(searchMenus =="분류"){
        this.searchList.length = 0
        axios.post(`http://localhost:7777/notice/categorySearchList/${search}`)
      .then( (res)=>{
        if(res.data == ''){
           alert("해당검색어로 검색되는 글이 존재하지않습니다.")
        }
        else{
          for(var i = 0; i <res.data.length; i++){
            this.searchList.push(res.data[i])
          }
               
       
          
          
          this.coin= 1}
      }
    
        )
      }
      
    },
    showAllBoard(){
      this.coin = 0;
    },

    ModeChange(){

     if(this.$store.state.tableMode == 1){
      Vue.$cookies.remove("TableMode")
      Vue.$cookies.remove("CardMode")
       this.SetTableMode(2)
      this.SetCardMode(1)
      Vue.$cookies.set('TableMode', 2, '1h')
      Vue.$cookies.set('CardMode', 1, '1h')
      console.log(this.tableMode)
      console.log(this.cardMode)
     }
     else{
      Vue.$cookies.remove("TableMode")
      Vue.$cookies.remove("CardMode")
      this.SetTableMode(1)
      this.SetCardMode(2)
      Vue.$cookies.set('TableMode', 1, '1h')
      Vue.$cookies.set('CardMode', 2, '1h')

     }
      
     
    },
    Write(){
      if(this.$store.state.session == null){
        alert("로그인이 필요합니다.")
        this.$router.push({name: 'LoginPage'})
      }
      else{
        this.$router.push({name: "BoardRegister"})
      }
    },
    handleSearchInput(e) { 
      
      this.filterSearch = e.target.value
      if(this.filterSearch.length !== 0){
        clearTimeout(this.debounce)
        this.debounce = setTimeout(() => { 
          const filteredList = this.noticeList.filter(noticeList => noticeList.title.includes(this.filterSearch))
        this.noticeList = filteredList; if(this.pageNum > 0){this.pageNum = 0} }, 500);}
        else if(this.filterSearch.length == 0){
        clearTimeout(this.debounce); this.debounce = setTimeout(() => { 
            this.GetNoitceList().then( (res) =>{
              this.noticeList = res.data
            })
          },500); 
          }},

  },
  computed: {
      ...mapState(['tableMode','cardMode','boardList']),
    pageCount () {
      let listLeng = this.noticeList.length,
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
      return this.noticeList.slice(start, end);
    },
    searchpaginatedData () {
      const start = this.searchpageNum * this.pageSize,
            end = start + this.pageSize;
      return this.searchList.slice(start, end);
    },
  },
  created(){
    this.fetchBoardList()
    if(this.$store.state.tableMode ==null){
      this.SetTableMode()
      this.SetCardMode()
    }
    else{
      this.SetTableMode(Vue.$cookies.get("TableMode"))
      this.SetCardMode(Vue.$cookies.get("CardMode"))
    }

  }

}
</script>

<style scoped>
td{
  font-family: 'Do Hyeon', sans-serif;
}
#option{
  font-family: 'Do Hyeon', sans-serif;
}
#footerMenuBar{
 position: absolute;
}
</style>