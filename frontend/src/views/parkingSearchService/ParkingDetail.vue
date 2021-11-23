<template>
  <div>
    <div class="kmapDetail" ref="map"></div>

    <v-card id="cardinfo">
      <v-card-title style="text-align:center">
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <button @click="addMyParkingState(session,itemsList)" ><v-icon>mdi-star</v-icon></button><span v-bind="attrs" v-on="on">{{itemsList.statNm}}</span>
          </template>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주소:{{itemsList.소재지도로명주소}},</span>
          </template>
          <span>주소입니다. </span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">문의전화:{{itemsList.전화번호}},</span>
          </template>
          <span>문의전화</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차구획수:{{itemsList.주차구획수}},</span>
          </template>
          <span>주차할수있는 주차공간개수입니다. </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">관리기관명:{{itemsList.관리기관명}},</span>
          </template>
          <span>관리기관 </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차장구분: :{{itemsList.주차장구분}},</span>
          </template>
          <span>주차장구분 </span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">평일운영시작시각:{{itemsList.평일운영시작시각}}</span>
          </template>
          <span>주중해당입니다.</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">평일운영종료시각:{{itemsList.평일운영종료시각}},</span>
          </template>
          <span>주중해당입니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">토요일운영시작시각:{{itemsList.토요일운영시작시각}}  </span>
          </template>
        <span>토요일해당입니다</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">토요일운영종료시각:{{itemsList.토요일운영종료시각}}</span>
          </template>
          <span>토요일해당입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">공휴일운영시작시각:{{itemsList.공휴일운영시작시각}}</span>
          </template>
          <span>공휴일해당입니다.</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">공휴일운영종료시각:{{itemsList.공휴일운영종료시각}}</span>
          </template>
          <span>공휴일해당입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">운영요일:{{itemsList.운영요일}}</span>
          </template>
            <span>운영요일</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">주차장유형:{{itemsList.주차장유형}}</span>
          </template>
          <span>주차장의형태입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">주차기본요금:{{itemsList.주차기본요금}}</span>
          </template>
          <span>단위(원)</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차기본시간:{{(itemsList.주차기본시간)}}</span>
          </template>
          <span>단위(분)</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
          <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">추가단위시간:{{(itemsList.추가단위요금)}}</span>
          </template>
          <span>단위(원)</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">추가단위시간:{{(itemsList.추가단위시간)}}</span>
          </template>
          <span>단위(분)</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">월정기권요금:{{(itemsList.월정기권요금)}}</span>
          </template>
          <span>단독/동시</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">결제방법:{{(itemsList.결제방법)}}</span>
          </template>
          <span>해당주차장의 결제방법입니다.</span>
        </v-tooltip>
      </v-card-title>
    </v-card>

  </div>
</template>

<script>
import VueMoment from 'vue-moment'
import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapState } from 'vuex'
import axios from 'axios'
Vue.use(VueMoment)
//import { mapGetters } from 'vuex'
Vue.use(cookies)
export default {

  data(){
    return{
      itemsList: null,
      Firstinfowindow: null,
      FirstmapInstance: null,
      MapOptions : {
        center:  {
          lat: this.$cookies.get('itemslat'),
          lng: this.$cookies.get('itemslng'),
        },
        level: 8
      },
      myPositionLat: this.$cookies.get("myPositionLat"),
      MyPositoinLng: this.$cookies.get("myPositionLng"),
    }
  },
  computed: {
    ...mapState(['session'])
    /*
    ...mapGetters(['itemList']),
    items() {
        return this.itemList
    },*/

  },
  mounted() {
    // 지도 center 세팅
    let kakao = window.kakao
    console.log(this.$refs.map) // should be not null
    var container = this.$refs.map
    const {center, level}  = this.MapOptions
    this.FirstmapInstance = new kakao.maps.Map(container, {
      center : new kakao.maps.LatLng(center.lat, center.lng),
      level,
    }); //지도 생성 및 객체 리턴
    //console.log(FirstmapInstance)
    // 마커 생성
    var markerPosition  = new kakao.maps.LatLng(center.lat, center.lng);
    var marker = new kakao.maps.Marker({ position: markerPosition});


    marker.setMap(this.FirstmapInstance);



    var iwContent = `<div style="padding:5px;">${this.itemsList.주차장명}</div>`,
        iwPosition = new kakao.maps.LatLng(center.lat, center.lng),
        iwRemoveable = true;


    this.Firstinfowindow = new kakao.maps.InfoWindow({
      map: this.FirstmapInstance,
      position : iwPosition,
      content : iwContent,
      removable : iwRemoveable});

  },

  methods:{
    addMyParkingState(session,items){
      if(session !== null){

        axios.post(`http://localhost:7777/member/addMyParkingState/${session.memberNo}`,{memberNo:session.memberNo ,  paymethod:items.결제방법, lng:items.경도 ,
         holiStart1:items.공휴일운영시작시각 , holiEnd:items.공휴일운영종료시각, adminiNm:items.관리기관명,addr1:items.소재지도로명주소,addr2:items.소재지지번주소,
         operatingday:items.운영요일,monthPay:items.월정기권요금,lat:items.위도,call1:items.전화번호,parkingNum:items.주차구획수,basicsTime:items.주차기본시간,
         basicsPay:items.주차기본요금,kind1:items.주차장구분,parkingNm:items.주차장명,ParkingType:items.주차장유형,addtimeUnit:items.추가단위시간,addpayUnit:items.추가단위요금,
         satStart:items.토요일운영시작시각,satEnd:items.토요일운영종료시각,weekStart:items.평일운영시작시각,weekEnd:items.평일운영종료시각
        })
        .then( (res) => {
          alert(res.data)
        }) 
      }
      else if(session == null){
        alert('로그인후 이용해주세요')
      }
    },
    addMyPositionMarker(){
      let kakao = window.kakao
      var myPosition  = new kakao.maps.LatLng(this.myPositionLat, this.MyPositoinLng);
      var myPositionMarker = new kakao.maps.Marker({ position: myPosition});
      myPositionMarker.setMap(this.FirstmapInstance)

      var myPositonMarkerContent = '<div style="padding:5px;">현재내위치</div>',
          myPositon = new kakao.maps.LatLng(this.myPositionLat, this.MyPositoinLng),
          myPositonRemoveable = true;

      this.FirstmapInstance = new kakao.maps.InfoWindow({
        map: this.FirstmapInstance,
        position: myPositon,
        content: myPositonMarkerContent,
        removable: myPositonRemoveable
      })
    }
  },

  created(){
    this.itemsList = this.$cookies.get('itemsList')
    axios.post('https://ipapi.co/json/')
        .then( (res) =>{
          console.log(res.data.latitude)
          this.$cookies.set("myPositionLat",res.data.latitude ,'1h')
          this.$cookies.set("myPositionLng",res.data.longitude ,'1h')
        })

  }
}
</script>

<style  lang="scss" scoped>
@import url('https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap');
#cardinfo{
  font-family: 'Do Hyeon', sans-serif;
  font-size: 1.3em;
  float: none;
}
.kmapDetail{
  width: 55%;
  height: 600px;
  float: left
}
.kmapInformation{
  position: absolute;
  width: 850px;
  margin-left: 1050px;
  text-align:left;
}

</style>
