<template>
  <div>
    <div class="kmapDetail" ref="map"></div>
    <!--
    <table  style="border: 1px" class="kmapInformation">
      <tr>
        <td style="text-align:left;">주소:{{itemsList.addr}}</td>
        <td style="text-align:left;">지점명:{{itemsList.statNm}}</td>
      </tr>
      <tr>
        <td style="text-align:left;">사용가능시간:{{itemsList.useTime}}</td>
        <td style="text-align:left;">기관:{{itemsList.busiNm}}</td>
      </tr>
      <tr>
        <td style="text-align:left;">문의전화:{{itemsList.busiCall}}</td>
        <td style="text-align:left;">충전타입:{{itemsList.chgerType}}</td>
      </tr>
      <tr>
        <td style="text-align:left;">충전소ID:{{itemsList.statId}}</td>
        <td style="text-align:left;">METHOD:{{itemsList.method}}</td>
      </tr>
      <tr>
        <td style="text-align:left;"><button @click="addMyState(session,itemsList)">즐겨찾기<v-icon>mdi-star</v-icon></button></td>
        <td style="text-align:left;"><button @click="addMyPositionMarker">내위치표시</button></td>
      </tr>
    </table>
    -->
    <v-card id="cardinfo">
      <v-card-title style="text-align:center">
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <button @click="addMyState(session,itemsList)" ><v-icon>mdi-star</v-icon></button><span v-bind="attrs" v-on="on">{{itemsList.statNm}}</span>
          </template>
          <span>지점명</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주소:{{itemsList.addr}},</span>
          </template>
          <span>주소입니다. </span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">문의전화:{{itemsList.busiCall}},</span>
          </template>
          <span>운영기관연락처</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">주차비무료여부:{{itemsList.parkingFree}},</span>
          </template>
          <span>주차료 (Y: 무료, N: 유료, 값 없는 경우 현장 확인) </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">이용자제한:{{itemsList.limitYn}},</span>
          </template>
          <span>이용자 제한 (N:제한 없음) </span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span style="margin-left: 20px" v-bind="attrs" v-on="on">이용자제한사유:{{itemsList.limitDetail}},</span>
          </template>
          <span>이용제한 사유 </span>
        </v-tooltip>

      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">사용가능시간:{{itemsList.useTime}}</span>
          </template>
          <span>해당충전소의 운영시간입니다.</span>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">상세위치:{{itemsList.location}},</span>
          </template>
          <span>이충전기의상태위치입니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">충전소사용상태:{{itemsList.stat}}</span>
          </template>
          <pre>충전기상태
(1: 통신이상, 2: 충전대기,
3: 충전중, 4: 운영중지,
5: 점검중, 9: 상태미확인)
</pre>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">충전소ID:{{itemsList.statId}}</span>
          </template>
          <span>충전소아이디입니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">충전기타입:{{itemsList.chgerType}}</span>
          </template>
          <pre><span>충전기타입
(01:DC차데모,
02: AC완속,
03: DC차데모+AC3상,
04: DC콤보,
05: DC차데모+DC콤보
06: DC차데모+AC3상
+DC콤보,
07: AC3상)
</span></pre>
        </v-tooltip>
        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span  style="margin-left: 20px" v-bind="attrs" v-on="on">충전용량:{{itemsList.output}}</span>
          </template>
          <span>충전용량 kW (3, 7, 50, 100, 200)</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">충전시작일시:{{itemsList.nowTsdt}}</span>
          </template>
          <span>현재충전중이라면,언제부터충전햇는지 표시합니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">마지막충전일시:{{(itemsList.lastTedt)}}</span>
          </template>
          <span>이충전소의 마지막 충전일시입니다.</span>
        </v-tooltip>
      </v-card-title>
      <v-divider></v-divider>
      <v-card-title>

        <v-tooltip bottom>
          <template v-slot:activator="{ on, attrs }">
            <span v-bind="attrs" v-on="on">충전방식:{{(itemsList.method)}}</span>
          </template>
          <span>단독/동시</span>
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



    var iwContent = `<div style="padding:5px;">${this.itemsList.statNm}</div>`,
        iwPosition = new kakao.maps.LatLng(center.lat, center.lng),
        iwRemoveable = true;


    this.Firstinfowindow = new kakao.maps.InfoWindow({
      map: this.FirstmapInstance,
      position : iwPosition,
      content : iwContent,
      removable : iwRemoveable});

  },

  methods:{
    addMyState(session,itemsList){
      if(session !== null){
        const {addr , busiCall, chgerType, lat , lng , statNm, useTime } = itemsList
        axios.post(`http://localhost:7777/member/addMyState/${session.memberNo}`,{addr , busiCall, chgerType, lat , lng , statNm, useTime})
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
