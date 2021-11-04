<template>
<v-container>
    <div>
        <div class="kmap" ref="map">
        </div>
        <table>
            <tr>
                <td>지점명</td>
                <td>주소</td>
                <td>충전타입</td>
                <td>사용시간</td>
                <td>CALL</td>
            </tr>
            <tr v-for=" items in item " :key="items.statId">
                <td>{{items.statNm}}</td>
                <a @click="makeMarker(item.lat,item.lng)"><td>{{items.addr}}</td></a>
                <td>{{items.chgerType}}</td>
                <td>{{items.useTime}}</td>
                <td>{{items.busiCall}}</td>
            </tr>
        </table>
        
            
        <v-select style="max-width: 100px;" :items="locationList" v-model="zcode">지역</v-select>
        <v-btn @click="fetchData">검색</v-btn>
        
        
    </div>
</v-container>
</template>

<script>
import axios from 'axios'
export default {
    data() {
    return {
      requestLink: 'http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?',
      apiKey: '7Yn%2BwtpnhhN0JX1sYiW%2Bf0lHHNeWUIlA7FwpwyGl2UOGTNu%2FAZ2IUTCQFFwOM0IvRPMJOXiAiaHmlv54y6EwHA%3D%3D',
      item: [],
      heroku: 'https://esc-proxy.herokuapp.com/',
      numOfRows: 10,
      zcode: 41,
      locationList:[
          {text: '강원도', value: 42},{text: '경기도', value: 41},{text: '경상남도', value:48 },
          {text: '경상북도', value:47 },{text: '광주광역시', value:29 },{text: '대구광역시', value:27 },
          {text: '대전광역시 ', value:30 },{text: '부산광역시', value:26 },{text: '서울특별시', value: 11},
          {text: '전라남도 ', value:46 },{text: '전라북도', value:45 },{text: '제주특별자치도 ', value: 50},
          {text: '울산광역시', value:31 },{text: '인천광역시', value:28 }
          

      ],
      lat: 0,
      lng: 0,
      MapOptions : {
                center:  {
                    lat: 37.26286532,
                    lng: 127.02963007,
                },
                level: 8
            }

    }
  },
  methods:{
    fetchData(){
      axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=${this.numOfRows}&pageNo=1&zcode=${this.zcode}`)
          .then((res)=>{
            let xml = res.data.items[0].item
            console.log(res.data.items[0].item)
            console.log(typeof xml)
            return xml
            // let json = convert.xml2json(xml, { compact: true })
            // this.item = JSON.parse(json)
      }).then(this.setResults).catch((err)=>{
        console.log(err)
      })
    },
    setResults(results){
      this.item = results
    },
    makeMarker(lat,lng){
        this.lat =lat
        this.lng = lng

    }
  },
  created(){
      this.fetchData()
  },
    mounted(){
        let kakao = window.kakao
        console.log(this.$refs.map) // should be not null
        var container = this.$refs.map
        const {center, level}  = this.MapOptions
        const mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(center.lat, center.lng),
            level,
        }); //지도 생성 및 객체 리턴
        console.log(mapInstance)
        
        
         var markerPosition  = new kakao.maps.LatLng(center.lat, center.lng);
            
        var marker = new kakao.maps.Marker({
        position: markerPosition 
        
});
        marker.setMap(mapInstance);
    }


    
}
</script>

<style  scoped>
.kmap{
    width: 100%;
    height: 600px;
}
</style>