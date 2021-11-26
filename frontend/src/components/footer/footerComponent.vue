<template>
     <v-footer 
    dark
    padless
  >
    <v-card width="100%" 
      flat
      tile
      class="black lighten-1 white--text text-center"
    > <!--
      <v-card-text>
        <v-btn
        class="mx-4 white--text"
        href="https://ev.or.kr/portal/main#">
        사이트소개
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://ev.or.kr/portal/main#">
        이용약관
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        개인정보처리방침
        </v-btn>
        <v-btn
        class="mx-4 white--text"
        href="https://www.facebook.com/profile.php?id=100007057508611">
        고객센터
        </v-btn>
      </v-card-text>
      -->
      <v-card-text>
        <p style="margin-right:"> <a style="color: white" @click="gopersonalinfo()">이용약관</a><a style="color: white" href="https://www.naver.com"> 사이트안내</a> 
        <a style="color: white" @click="gopersonalinfo()"> 개인정보처리방침</a> <a style="color: white" @click="goNoticeListPage()">공지사항</a></p>
        <p> &copy;ElectricVehicleService.</p>
        
      </v-card-text>
      <v-card-text  id="footerImg" class="white--text pt-0">
      <a style="margin-left: 81%" href="http://www.me.go.kr"><img src="../../assets/footer로고/환경부.jpg"   border="0" alt="환경부 홈페이지로 갑니다"></a>
      <a href="https://www.keco.or.kr/kr/main/index.do"><img src="../../assets/footer로고/한국환경공단.jpg"  border="0" alt="한국환경공단으로 갑니다."></a>
      <a href="https://www.aea.or.kr/new/"><img src="../../assets/footer로고/한국자동차환경협회.jpg"  border="0" alt="한국자동차환경협회 홈페이지로 갑니다"></a>
      <a href="http://www.webwatch.or.kr/Situation/WA_Situation.html?MenuCD=110"><img src="../../assets/footer로고/정보통신접근성.jpg"  border="0" alt="웹인증 홈페이지로 갑니다"></a>              
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
    data(){
        return{

        }
    },
    methods:{
      goNoticeListPage(){
        this.$router.push({name: 'NoticeListPage'})
      },
      gopersonalinfo(){
        this.$router.push({name: 'Personalinfo'})
      }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
p{
    font-family: 'Do Hyeon', sans-serif;
    font-size: 1.3em;
    float: none;
}

a { 
  
  text-decoration:none 
  } 

</style>