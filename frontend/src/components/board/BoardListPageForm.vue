<template>
<div>
  <v-row>
  <v-card
    class="mx-auto my-12"
    width="400"
    v-for="i in paginatedData" :key="i.boardNo"
  >
    <v-card-title>{{i.memberId}}</v-card-title>
    <v-card-title>{{i.title}}</v-card-title>
    <v-card-subtitle>[{{$moment(i.createDate).format('YYYY-MM-DD/hh:mm')}} 조회{{i.viewcount}}<v-icon small>mdi-thumb-up</v-icon>:{{i.good}},<v-icon small>mdi-thumb-down</v-icon>:{{i.bad}}</v-card-subtitle>
    <v-img v-if="i.img != ''" width="400px" height="350" :src="require(`@/assets/게시판/${i.img}`)"></v-img>
    <v-img v-else-if="i.img == ''" width="400px" height="350" :src="require('@/assets/게시판/사진없음.jpg')"></v-img>
    

    <v-card-text>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-actions>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="goDetail(i.boardNo)"
      >
        보기
      </v-btn>
    </v-card-actions>
  </v-card>
  </v-row>
  <div class="btn-cover">
      <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
        이전
      </button>
      <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
      <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
        다음
      </button>
    </div>
</div>
<!--
  <div>
      <v-container>
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
        <td>{{p.boardNo}}</td>
        <td  @click="goDetail(p.boardNo)">{{p.title}}</td>
        <td>{{p.memberId}}</td>
        <td>{{p.viewcount}}</td>
        <td style="width:70px">{{p.good}}</td>
        <td style="width:70px">{{p.bad}}</td>
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
  -->
</template>

<script>
import Vue from 'vue'
import VueMoment from 'vue-moment'
import axios from 'axios';
Vue.use(VueMoment)
export default {
  name: 'paginated-list',
  data () {
    return {
      pageNum: 0,
      loading: false,
      selection: 1,
    }
  },
  props: {
    boardList: {
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
    reserve () {
        this.loading = true
        setTimeout(() => (this.loading = false), 2000)
      },
  },
  computed: {
    pageCount () {
      let listLeng = this.boardList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.boardList.slice(start, end);
    }
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