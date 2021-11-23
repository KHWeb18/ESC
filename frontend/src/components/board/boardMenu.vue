<template>
<div>
    <v-card  dark elevation="0" style="float:left; margin-top: 13px; margin-left: 250px; width:180px">
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