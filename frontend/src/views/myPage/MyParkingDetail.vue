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
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주소:{{itemsList.addr1}},</span>
          </template>
          <span>주소입니다. </span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">문의전화:{{itemsList.call1}},</span>
          </template>
          <span>문의전화</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차구획수:{{itemsList.parkingNum}},</span>
          </template>
          <span>주차할수있는 주차공간개수입니다. </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">관리기관명:{{itemsList.adminiNm}},</span>
          </template>
          <span>관리기관 </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차장구분: :{{itemsList.kind1}},</span>
          </template>
          <span>주차장구분 </span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">평일운영시작시각:{{itemsList.weekStart}}</span>
          </template>
          <span>주중해당입니다.</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">평일운영종료시각:{{itemsList.weekEnd}},</span>
          </template>
          <span>주중해당입니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">토요일운영시작시각:{{itemsList.satStart}}  </span>
          </template>
        <span>토요일해당입니다</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">토요일운영종료시각:{{itemsList.satEnd}}</span>
          </template>
          <span>토요일해당입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">공휴일운영시작시각:{{itemsList.holiStart1}}</span>
          </template>
          <span>공휴일해당입니다.</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">공휴일운영종료시각:{{itemsList.holiEnd}}</span>
          </template>
          <span>공휴일해당입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">운영요일:{{itemsList.operatingday}}</span>
          </template>
            <span>운영요일</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">주차장유형:{{itemsList.parkingType || '-'}}</span>
          </template>
          <span>주차장의형태입니다</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">주차기본요금:{{itemsList.basicsPay}}원</span>
          </template>
          <span>단위(원)</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차기본시간:{{(itemsList.basicsTime)}}분</span>
          </template>
          <span>단위(분)</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
          <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">추가단위시간:{{(itemsList.addpayUnit)}}원</span>
          </template>
          <span>단위(원)</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px"  v-bind="attrs" v-on="on">추가단위시간:{{(itemsList.addtimeUnit)}}분</span>
          </template>
          <span>단위(분)</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">월정기권요금:{{(itemsList.monthPay || '-')}}원</span>
          </template>
          <span>단독/동시</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">결제방법:{{(itemsList.paymethod)}}</span>
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



    var iwContent = `<div style="padding:5px;">${this.itemsList.parkingNm}</div>`,
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

        axios.post(`http://evsbackend.herokuapp.com/member/addMyParkingState/${session.memberNo}`,{memberNo:session.memberNo ,  paymethod:items.paymethod, lng:items.lng ,
         holiStart1:items.holiStart1 , holiEnd:items.holiEnd, adminiNm:items.adminiNm,addr1:items.addr1,addr2:items.addr2,
         operatingday:items.operatingday,monthPay:items.monthPay,lat:items.lat,call1:items.call1,parkingNum:items.parkingNum,basicsTime:items.basicsTime,
         basicsPay:items.basicsPay,kind1:items.kind1,parkingNm:items.parkingNm,ParkingType:items.ParkingType,addtimeUnit:items.addtimeUnit,addpayUnit:items.addpayUnit,
         satStart:items.satStart,satEnd:items.satEnd,weekStart:items.weekStart,weekEnd:items.weekEnd
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
