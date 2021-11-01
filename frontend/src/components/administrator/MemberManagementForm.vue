<template>
  <div>
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
                    <!--
                    <v-dialog eager v-model="dialog" persistent max-width="400">
                    <template v-slot:activator="{ on }">
                        <v-btn v-on="on">정지</v-btn>
                        </template>
                        <v-card>
                            <v-card-title>
                                해당유저를 정지시키겟습니까?
                            </v-card-title>
                            <v-card-actions>
                                <v-btn @click="ban(p)">예</v-btn>
                                <v-btn @click="cancle">아니오</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-dialog>
                    <v-dialog eager v-model="dialog2" persistent max-width="400">
                    <template v-slot:activator="{ on }">
                    <v-btn  v-on="on">해제</v-btn>
                    </template>
                    <v-card>
                    <v-card-title class="headline">
                        해당유저를 복귀시키겟습니까?
                    </v-card-title>
                    <v-card-actions>
                        <v-btn @click="jailbreak(p.memberNo)">예</v-btn>
                    <v-btn @click="cancle">아니오</v-btn>
                    </v-card-actions>
                    </v-card>
                    </v-dialog>
                    -->
                    </td>    

                
                
            
            </tr>
            </table>
            <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            <form @keyup.enter="searching(searchMenus,search)">
                    <!--
                <v-row style="margin-left: 80%">
                <v-select  style="max-width: 100px" :items="searchMenu" label="검색" v-model="searchMenus"/>
                <v-text-field  style="max-width: 300px" v-model="search" label="검색란"></v-text-field>
                </v-row>
                -->
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
      pageNum: 0,
      dialog: false,
      dialog2: false,
      ONE: 1,

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
              alert("해당아이디는 해방되었습니다.")
              this.$router.go()
          })
      },
      cancle(){
          this.dialog = false
          this.dialog2 =false
      },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
  },
  computed: {
    pageCount () {
      let listLeng = this.memberList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;
      
      /*
      아니면 page = Math.floor((listLeng - 1) / listSize) + 1;
      이런식으로 if 문 없이 고칠 수도 있다!
      */
      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.memberList.slice(start, end);
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