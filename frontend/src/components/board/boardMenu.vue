<template>
<div>
    <v-card  dark elevation="0" style="position:absolute; margin-top: 13px; margin-left: 250px; width:180px">
    <v-card-title > 
     
    </v-card-title>
    <v-divider></v-divider>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'BoardListPage'}"> 전체글({{AllBoardLength}})</v-btn>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'FreeBoardListPage'}"> 자유게시판</v-btn>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'ChargingBoardListPage'}"> 충전소게시판</v-btn>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'ParkingBoardListPage'}"> 주차장게시판</v-btn>
    </v-card-title>
    <v-divider></v-divider>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'SuggestionBoardListPage'}"> 건의게시판</v-btn>
    </v-card-title>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'NoticeListPage'}"> 공지사항</v-btn>
    </v-card-title>
    <v-divider></v-divider>
  </v-card>
</div>
</template>

<script>
import { mapActions ,mapState } from 'vuex'
export default {
    data(){
        return{
            AllBoardLength:Number(this.boardList.length)
        }
    },
computed: {
    ...mapState(['boardList'])
},
methods:{
    ...mapActions(['fetchBoardList'])
},
created(){
    this.fetchBoardList()
}


}
</script>