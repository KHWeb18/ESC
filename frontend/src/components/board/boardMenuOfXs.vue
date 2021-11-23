<template>
<div class="hidden-xl-only hidden-lg-only hidden-md-only">
    <v-card  dark>
    <v-card-title > 
     <v-btn width="130" outlined route :to="{ name: 'BoardListPage'}"> 전체글({{AllBoardLength}})</v-btn>
     <v-btn width="130" outlined route :to="{ name: 'FreeBoardListPage'}"> 자유게시판</v-btn>
     <v-btn width="130" outlined route :to="{ name: 'ChargingBoardListPage'}"> 충전소게시판</v-btn>
     <v-btn width="130" outlined route :to="{ name: 'ParkingBoardListPage'}"> 주차장게시판</v-btn>
     <v-btn width="130" outlined route :to="{ name: 'SuggestionBoardListPage'}"> 건의게시판</v-btn>
     <v-btn width="130" outlined route :to="{ name: 'NoticeListPage'}"> 공지사항</v-btn>
    </v-card-title>

  </v-card>
</div>
</template>

<script>

export default {
   props:{
       boardList: {
           required: true
       }
   },
   data(){
       return{
           AllBoardLength: this.boardList.length
       }
   }

}
</script>