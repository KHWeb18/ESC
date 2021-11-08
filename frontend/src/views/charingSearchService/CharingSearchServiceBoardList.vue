<template>

    <div>

        
        <div style="max-width:800px" class="kmap" ref="map">

        </div>
        
        <div class="InfoTable">
        <table>
            <tr id="headerTr">
                <td>즐겨찾기</td>
                <td>지점명</td>
                <td>주소</td>
                <td>충전타입</td>
                <td>사용시간</td>
                <td>CALL</td>
            </tr>
            <tr v-for=" items in paginatedData " :key="items.lat+items.statNm+items.statUpdDt">
                <td><button @click="addMyState(session,items)"><v-icon>mdi-star</v-icon></button></td>
                <td>{{items.statNm}}</td>
                <a @click="goDetial(items)"><td>{{items.addr}}</td></a>
                <td>{{items.chgerType}}</td>
                <td>{{items.useTime}}</td>
                <td>{{items.busiCall}}</td>
            </tr>
        </table>
        <div class="btn-cover">
        <button class="levelControll" @click="levelControll(-1)"><span class="material-icons">zoom_in</span></button>
        <button class="levelControll" @click="levelControll(1)"><span class="material-icons">zoom_out</span></button>
          <v-menu offset-y>
        <template v-slot:activator="{ on, attrs }">
          <v-btn text v-bind="attrs" v-on="on">
          <span class="profileBtn">지역선택</span>
          <v-icon>arrow_drop_down</v-icon>
          </v-btn>
          </template>
          <v-list>
            <v-list-item v-for="location in locationList" :key="location.value" class="pointer" @click="FetchData(location.value)">
              <v-list-item-title>{{location.text}}</v-list-item-title></v-list-item>
            </v-list>
          </v-menu>
            <button  style="margin-left: 20%;" :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            검색
            <input style="border: 1px; margin-right: 18%" v-model="search" placeholder="지점명 검색" @input="handleSearchInput" @keydown.tab="KeydownTab"/>
            
            </div>

        
        
   
        </div>
        
    </div>

</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
import { mapActions, mapState } from 'vuex';
Vue.use(cookies)
export default {
    data() {
    return {
      requestLink: 'http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?',
      apiKey: '7Yn%2BwtpnhhN0JX1sYiW%2Bf0lHHNeWUIlA7FwpwyGl2UOGTNu%2FAZ2IUTCQFFwOM0IvRPMJOXiAiaHmlv54y6EwHA%3D%3D',
      item: [],
      heroku: 'https://esc-proxy.herokuapp.com/',
      // api에서 뽑아오는 row 개수
      numOfRows: 200,
      //초기 지역설정 
      zcode: 11,
      locationList:[
          {text: '강원도', value: 42},{text: '경기도', value: 41},{text: '경상남도', value:48 },
          {text: '경상북도', value:47 },{text: '광주광역시', value:29 },{text: '대구광역시', value:27 },
          {text: '대전광역시 ', value:30 },{text: '부산광역시', value:26 },{text: '서울특별시', value: 11},
          {text: '전라남도 ', value:46 },{text: '전라북도', value:45 },{text: '제주특별자치도 ', value: 50},
          {text: '울산광역시', value:31 },{text: '인천광역시', value:28 }
          

      ],
      lat: 0,
      lng: 0,
      pageSize: 7,
      pageNum: 0,
      MapOptions : {
                center:  {
                    // 초기 세팅값
                    lat: 37.26286532,
                    lng: 127.02963007,
                },
                level: 9
            },
    mapInstance: null,
    FirstmapInstance: null,
    infowindow: null,
    Firstinfowindow: null,
    searchList:[],
    search: '',
    allitem: null

    }
  },
  computed: {
    
    ...mapState(['session']),
    pageCount () {
      let listLeng = this.item.length,
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
      return this.item.slice(start, end);
    }
  },
  methods:{
    ...mapActions(['SetitemList']),
    addMyState(session,items){
      if(session !== null){
        const {addr , busiCall, chgerType, lat , lng , statNm, useTime } = items
        axios.post(`http://localhost:7777/member/addMyState/${session.memberNo}`,{addr , busiCall, chgerType, lat , lng , statNm, useTime})
        .then( (res) => {
          alert(res.data)
        }) 
      }
      else if(session == null){
        alert('로그인후 이용해주세요')
      }
    },
    SettingData(){
      axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=${this.numOfRows}&pageNo=1&zcode=${this.zcode}`)
          .then((res)=>{
            
            let xml = res.data.items[0].item
        //검색후 마커 및 인포 윈도우 그리기 시작..
            let kakao = window.kakao
        console.log(this.$refs.map) // should be not null
        var container = this.$refs.map
        //MapOptions center세팅시작
        this.MapOptions.center.lat = xml[0].lat
        this.MapOptions.center.lng = xml[0].lng
        //MapOptions center세팅시작완료
        const {center, level}  = this.MapOptions
        this.mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(center.lat, center.lng),
            level,
        }); //지도 생성 및 객체 리턴

        for (var i = 0 ; i < xml.length ; i ++){
        var markerPosition  = new kakao.maps.LatLng(xml[i].lat, xml[i].lng);
        var marker = new kakao.maps.Marker({ position: markerPosition});
        marker.setMap(this.mapInstance);
        
        var iwContent = `<div  style="max-width:1000">${xml[i].statNm}</div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능
        iwPosition = new kakao.maps.LatLng(xml[i].lat, xml[i].lng), //인포윈도우 표시 
        iwRemoveable = true; 

            // 인포윈도우를 생성하고 지도에 표시
            this.infowindow = new kakao.maps.InfoWindow({
            map: this.mapInstance, // 인포윈도우가 표시될 지도
            position : iwPosition, 
            content : iwContent,
            removable : iwRemoveable });
        } 
        //검색후 마커 및 인포 윈도우 그리기 끝
            this.item = xml
      })

    },
    FetchData(searchzcode){
      axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=${this.numOfRows}&pageNo=1&zcode=${searchzcode}`)
          .then((res)=>{
            
            let xml = res.data.items[0].item
        //검색후 마커 및 인포 윈도우 그리기 시작..
            let kakao = window.kakao
        console.log(this.$refs.map) // should be not null
        var container = this.$refs.map
        //MapOptions center세팅시작
        this.MapOptions.center.lat = xml[0].lat
        this.MapOptions.center.lng = xml[0].lng
        //MapOptions center세팅시작완료
        const {center, level}  = this.MapOptions
        this.mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(center.lat, center.lng),
            level,
        }); //지도 생성 및 객체 리턴

        for (var i = 0 ; i < xml.length ; i ++){
        var markerPosition  = new kakao.maps.LatLng(xml[i].lat, xml[i].lng);
        var marker = new kakao.maps.Marker({ position: markerPosition});
        marker.setMap(this.mapInstance);
        
        var iwContent = `<div  style="max-width:1000">${xml[i].statNm}</div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능
        iwPosition = new kakao.maps.LatLng(xml[i].lat, xml[i].lng), //인포윈도우 표시 
        iwRemoveable = true; 

            // 인포윈도우를 생성하고 지도에 표시
            this.infowindow = new kakao.maps.InfoWindow({
            map: this.mapInstance, // 인포윈도우가 표시될 지도
            position : iwPosition, 
            content : iwContent,
            removable : iwRemoveable });
        } 
        //검색후 마커 및 인포 윈도우 그리기 끝
            this.item = xml
      })
    },
    goDetial(items){
        this.SetitemList(items)
        this.$cookies.set('itemsList', items, '1h')
        this.$cookies.set('itemslat', items.lat, '1h')
        this.$cookies.set('itemslng', items.lng, '1h')
        this.$router.push({name: 'CharingSearchServiceReadPage',})
    },
    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
    levelControll(delta){    
      const level = Math.max(3, this.MapOptions.level +delta) 
      this.MapOptions.level =level
    },
    handleSearchInput(e) { 
      
      this.search = e.target.value
      if(this.search.length !== 0){
        clearTimeout(this.debounce)
        this.debounce = setTimeout(() => { 
          const filteredList = this.item.filter(item => item.statNm.includes(this.search))
        this.item = filteredList; if(this.pageNum > 0){this.pageNum = 0} }, 500);}
        else if(this.search.length == 0){
        clearTimeout(this.debounce); this.debounce = setTimeout(() => { 
          axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=${this.numOfRows}&pageNo=1&zcode=${this.zcode}`)
          .then( (res) =>{
          this.item = res.data.items[0].item
          })},500); 
          }},
  },
  created(){
      this.SettingData()
  },
    mounted(){
  
    },
    watch: {
      'MapOptions.level'(cur, /*prev*/){
       // console.log(`[LEVEL CHAGNE]: ${cur} =>${prev}}`)  for testing
        this.mapInstance.setLevel(cur)
      }
    }

  

    
}
</script>

<style  lang="scss" >
.kmap{
    width: 100%;
    height: 600px;
    float: left;
}
button {
    border: 1px solid transparent;
    padding: 6px;
    background-color: #efefefdd;
    border-radius: 6px;
    &:hover{
        background-color: #ddd;
        border-color: #ddd;
    }
    
}
table tr td {
    &:hover{
        background-color: #ddd;
        border-color: #ddd;
    }
}
.InfoTable{

  width: 1100px;
  float: right;
}
input:focus {outline:2px solid #d50000;}
#headerTr{
  background: rgb(93, 128, 233);
}

</style>