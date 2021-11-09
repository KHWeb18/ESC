<template>
  <div>
    <div class="kmapDetail" ref="map"></div>
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
  </div>
</template>

<script>

import Vue from 'vue'
import cookies from 'vue-cookies'
import { mapState } from 'vuex'
import axios from 'axios'
//import { mapGetters } from 'vuex'
Vue.use(cookies)
export default {
  props: {
    /*
    items: {
        type:Object,
        required: true
    },
    lat: {
        type:String,
        required: true
    }*/
  },
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

<style  lang="scss">
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
