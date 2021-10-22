<template>
  <div>
      <v-container>
          검색
      <input v-model="search"/>
          
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>추천</th>
        <th>비추천</th>
       
      </tr>
      <tr v-for="p in paginatedData" :key="p.no">
        <td v-if="p.title.includes(search)">{{p.boardNo}}</td>
        <td v-if="p.title.includes(search)"  @click="goDetail(p.boardNo)">{{p.title}}</td>
        <td v-if="p.title.includes(search)">{{p.memberId}}</td>
        <td v-if="p.title.includes(search)">{{p.viewcount}}</td>
        <td v-if="p.title.includes(search)" style="width:70px">{{p.good}}</td>
        <td v-if="p.title.includes(search)" style="width:70px">{{p.bad}}</td>
      </tr>
    </table>
    <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
    <v-btn route :to="{name: 'BoardRegister'}">글쓰기</v-btn>
      </v-container>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'FreeBoardListForm',
  data () {
    return {
      pageNum: 0,
      search: '',
      target: '자유게시판',
      ip: ''
     
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
      default: 10
    }
  },
  methods: {
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    goDetail(boardNo){
        this.$router.push({name: 'BoardReadPage', params:{boardNo}})

        axios.post(`http://localhost:7777/board/viewcount/${boardNo}`)
        .then( () =>{

        })
    },

  },
  computed: {
    pageCount () {
      let listLeng = this.TargetList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.TargetList.slice(start, end);
    }
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