<template>
  <div >
      <v-container style="max-width:1000px">
            <table>
            <tr>
                <td>댓글번호</td>
                <td>회원아이디</td>
                <td>댓글내용</td>
                <td>작성날짜</td>
                <td>비고</td>


            </tr>
            <tr v-for="p in paginatedData" :key="p.commentNo">
                <td>{{p.commentNo}}</td>
                <td>{{p.memberId}}</td>
                <td>{{p.content}}</td>
                <td>{{p.updDate}}</td>
                <td><v-btn @click="deleteComment(p)">삭제</v-btn><v-btn @click="hold(p)">보류</v-btn></td>




            </tr>
            </table>
            <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            </div>
        </v-container>
  </div>

</template>


<script>
import {mapActions,mapState} from 'vuex'
import axios from 'axios'
export default {
  name: 'paginated-list',
  data () {
    return {
      pageSize:10,
        isDeleted: true,
      search:'',
      pageNum: 0,
      searchpageNum: 0,
      dialog: false,
      dialog2: false,
      searchMenus: '',
      searchMenu: [
        {text: '회원번호', value: '회원번호'},
        {text: '회원이름', value: '회원이름'},
        {text: '아이디', value: '아이디'},
      ],
      searchList: [],
      
    }
  },
  methods: {
    ...mapActions(['getReportedCommentNoList']),
        hold(commentInfo){
            axios.post(`https://evsbackend.herokuapp.com/comment/reportedCommentDelete/${commentInfo.commentNo}`)
            .then( ()=>{
                alert("해당댓글은 보류되었습니다.")
                this.$router.go();
                
            })           
        },
        deleteComment(commentInfo) {
            axios.post(`https://evsbackend.herokuapp.com/comment/reportedCommentDelete/${commentInfo.commentNo}`)
            .then( ()=>{
            }) 
            const { isDeleted } = this
            axios.put(`https://evsbackend.herokuapp.com/comment/delete/${commentInfo.commentNo}`,
                { memberId : commentInfo.memberId, isDeleted })
                .then(() => {
                    alert('해당댓글은 삭제되었습니다.')
                    this.$router.go();


                })
                .catch(err => {
                    alert(err.response.data.message)
                })
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
    ...mapState(['reportedCommentList']),
    pageCount () {
      let listLeng = Number(this.reportedCommentList.length),
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
      return this.reportedCommentList.slice(start, end);
    },
    searchpaginatedData () {
      const start = this.searchpageNum * this.pageSize,
            end = start + this.pageSize;
      return this.searchList.slice(start, end);
    },
    
  },
  created(){
    this.getReportedCommentNoList()
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
