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
                <td>{{typeFormatter(items.chgerType)}}</td>
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
    allitem: null,

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
  created(){
    this.SettingData()
  },
  methods:{
    ...mapActions(['SetitemList']),
    typeFormatter(value){
      switch (value){
        case '01':
          return 'DC차데모'
        case '02':
          return 'AC완속'
        case '03':
          return 'DC차데모 + AC3상'
        case '04':
          return 'DC콤보'
        case '05':
          return 'DC차데모 + DC콤보'
        case '06':
          return 'DC차데모 + AC3상 + DC콤보'
        case '07':
          return 'AC3상'
        default:
          return '확인 불가'
      }
    },
    statFormatter(value){
      switch (value){
        case '1':
          return '통신이상'
        case '2':
          return '충전대기'
        case '3':
          return '충전중'
        case '4':
          return '운영중지'
        case '5':
          return '점검중'
        case '6':
          return '상태미확인'
        default:
          return '상태미확인'
      }
    },
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
          var imageSize = new kakao.maps.Size(20, 30), imageOption = {offset: new kakao.maps.Point(5, 20)};
          var imageSrc
          switch (xml[i].stat){
            case '1':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
              break
            case '2':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/green.png'
              break
            case '3':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/red.png'
              break
            case '4':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/grey.png'
              break
            case '5':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/orange.png'
              break
            case '9':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
              break
            default:
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
          }
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
        var markerPosition  = new kakao.maps.LatLng(xml[i].lat, xml[i].lng);
        var marker = new kakao.maps.Marker({
          position: markerPosition,
          image: markerImage,
          clickable: true});
        marker.setMap(this.mapInstance);

          var customOverlay = new kakao.maps.CustomOverlay({
            position: markerPosition,
            xAnchor: 0.48, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
            yAnchor: 1.08, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
          })


          var content = document.createElement('div')
          content.className = 'overlay_info'

          var title = document.createElement('div')
          title.className = 'topTitle'

          var info = document.createElement('span')
          info.appendChild(document.createTextNode('충전소 정보'))
          content.appendChild(title)
          title.appendChild(info)
          title.addEventListener('click',closeOverlay(customOverlay))

          var desc = document.createElement('div')
          desc.className = 'desc'

          var name = document.createElement('span')
          name.className = 'name'

          var nameLink = document.createElement('a')
          nameLink.className = 'nameLink'
          nameLink.appendChild(document.createTextNode(xml[i].statNm))
          name.appendChild(nameLink)
          desc.appendChild(name)
          content.appendChild(desc)

          var solid = document.createElement('hr')
          solid.className = 'solid'
          desc.appendChild(solid)

          var address = document.createElement('div')
          address.className = 'address'
          var markerIcon = document.createElement('i')
          markerIcon.className = 'fas fa-map-marker-alt'
          var addressText = document.createElement('span')
          addressText.appendChild(document.createTextNode(xml[i].addr))
          address.appendChild(markerIcon)
          address.appendChild(addressText)
          desc.appendChild(address)

          var tel = document.createElement('div')
          tel.className = 'tel'
          var telIcon = document.createElement('i')
          telIcon.className = 'fas fa-phone'
          var telText = document.createElement('span')
          telText.appendChild(document.createTextNode(xml[i].busiCall))
          tel.appendChild(telIcon)
          tel.appendChild(telText)
          desc.appendChild(tel)

          var status = document.createElement('div')
          status.className = 'status'
          var statusIcon = document.createElement('i')
          statusIcon.className = 'fas fa-info-circle'
          var statusText = document.createElement('span')
          statusText.appendChild(document.createTextNode(this.statFormatter(xml[i].stat)))
          status.appendChild(statusIcon)
          status.appendChild(statusText)
          desc.appendChild(status)

          var type = document.createElement('div')
          type.className = 'type'
          var typeIcon = document.createElement('i')
          typeIcon.className = 'fas fa-plug'
          var typeText = document.createElement('span')
          typeText.appendChild(document.createTextNode(this.typeFormatter(xml[i].chgerType)))
          type.appendChild(typeIcon)
          type.appendChild(typeText)
          desc.appendChild(type)


          // console.log(content)

          kakao.maps.event.addListener(marker, 'click', makeOverListener(this.mapInstance, customOverlay, content));

          // kakao.maps.event.addListener(marker,'click',function (){
          //     customOverlay.setMap(this.mapInstance)
          //     customOverlay.setContent(content)
          //
          // })


      //   var iwContent = `<div class="overlay_info">
      // <div class="topTitle"><span>충전소 정보</span></div>
      // <div class="desc">
      // <span class="name"><a class="nameLink">${xml[i].statNm}</a></span>
      // <hr class="solid">
      //
      // <div class="address">
      // <i class="fas fa-map-marker-alt"></i>
      // <span>${xml[i].addr}</span>
      // </div>
      //
      // <div class="tel">
      // <i style="color: #3F51B5; font-size: 20px" class="fas fa-phone"></i>
      // <span>${xml[i].busiCall}</span>
      // </div>
      //
      // <div class="status">
      // <i style="color: #3F51B5; font-size: 20px" class="fas fa-info-circle"></i>
      // <span>상태:${xml[i].stat}</span>
      // </div>
      //
      // <div class="type">
      // <i style="color: #3F51B5; font-size: 20px" class="fas fa-plug"></i>
      // <span>충전타입:${xml[i].chgerType}</span>
      // </div>
      //
      // </div>
      // </div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능
      //   iwPosition = new kakao.maps.LatLng(xml[i].lat, xml[i].lng), //인포윈도우 표시
      //   iwRemoveable = true;
      //
      //       // 인포윈도우를 생성하고 지도에 표시
      //       this.infowindow = new kakao.maps.InfoWindow({
      //       // 인포윈도우가 표시될 지도
      //       position : iwPosition,
      //       content : iwContent,
      //       removable : iwRemoveable });
      //   kakao.maps.event.addListener(marker, 'click', goReadPage(xml[i].statNm));
      //  kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(this.mapInstance, marker, this.infowindow));
      //   kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(this.infowindow));
        }
      function makeOverListener(map, customOverlay, content) {
          return ()=>{
            customOverlay.setMap(map)
            customOverlay.setContent(content)}

}
      function closeOverlay(customOverlay) {
        return function() {
          customOverlay.setMap(null)
        };
      }
    // function makeOverListener(map, marker, infowindow) {
    //   return function() {
    //     infowindow.open(map, marker);
    //   };
    // }
//   function goReadPage(statNm) {
//     return function(){
//       console.log(statNm)
//     }
//   }
//
// // 인포윈도우를 닫는 클로저를 만드는 함수입니다
// function makeOutListener(infowindow) {
//     return function() {
//         infowindow.close();
//     };
// }
        

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

          var imageSize = new kakao.maps.Size(20, 30), imageOption = {offset: new kakao.maps.Point(5, 20)};
          var imageSrc
          switch (xml[i].stat){
            case '1':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
              break
            case '2':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/green.png'
              break
            case '3':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/red.png'
              break
            case '4':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/grey.png'
              break
            case '5':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/orange.png'
              break
            case '9':
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
              break
            default:
              imageSrc = 'https://raw.githubusercontent.com/KHWeb18/ESC/main/frontend/src/assets/img/map/blue.png'
          }
          var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
          var markerPosition  = new kakao.maps.LatLng(xml[i].lat, xml[i].lng);
          var marker = new kakao.maps.Marker({
            position: markerPosition,
            image: markerImage,
            clickable: true});
          marker.setMap(this.mapInstance);

          var customOverlay = new kakao.maps.CustomOverlay({
            position: markerPosition,
            xAnchor: 0.48, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
            yAnchor: 1.08, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
          })


          var content = document.createElement('div')
          content.className = 'overlay_info'

          var title = document.createElement('div')
          title.className = 'topTitle'

          var info = document.createElement('span')
          info.appendChild(document.createTextNode('충전소 정보'))
          content.appendChild(title)
          title.appendChild(info)
          title.addEventListener('click',closeOverlay(customOverlay))

          var desc = document.createElement('div')
          desc.className = 'desc'

          var name = document.createElement('span')
          name.className = 'name'

          var nameLink = document.createElement('a')
          nameLink.className = 'nameLink'
          nameLink.appendChild(document.createTextNode(xml[i].statNm))
          name.appendChild(nameLink)
          desc.appendChild(name)
          content.appendChild(desc)

          var solid = document.createElement('hr')
          solid.className = 'solid'
          desc.appendChild(solid)

          var address = document.createElement('div')
          address.className = 'address'
          var markerIcon = document.createElement('i')
          markerIcon.className = 'fas fa-map-marker-alt'
          var addressText = document.createElement('span')
          addressText.appendChild(document.createTextNode(xml[i].addr))
          address.appendChild(markerIcon)
          address.appendChild(addressText)
          desc.appendChild(address)

          var tel = document.createElement('div')
          tel.className = 'tel'
          var telIcon = document.createElement('i')
          telIcon.className = 'fas fa-phone'
          var telText = document.createElement('span')
          telText.appendChild(document.createTextNode(xml[i].busiCall))
          tel.appendChild(telIcon)
          tel.appendChild(telText)
          desc.appendChild(tel)

          var status = document.createElement('div')
          status.className = 'status'
          var statusIcon = document.createElement('i')
          statusIcon.className = 'fas fa-info-circle'
          var statusText = document.createElement('span')
          statusText.appendChild(document.createTextNode(this.statFormatter(xml[i].stat)))
          status.appendChild(statusIcon)
          status.appendChild(statusText)
          desc.appendChild(status)

          var type = document.createElement('div')
          type.className = 'type'
          var typeIcon = document.createElement('i')
          typeIcon.className = 'fas fa-plug'
          var typeText = document.createElement('span')
          typeText.appendChild(document.createTextNode(this.typeFormatter(xml[i].chgerType)))
          type.appendChild(typeIcon)
          type.appendChild(typeText)
          desc.appendChild(type)


          // console.log(content)

          kakao.maps.event.addListener(marker, 'click', makeOverListener(this.mapInstance, customOverlay, content));


        }
            function makeOverListener(map, customOverlay, content) {
              return ()=>{
                customOverlay.setMap(map)
                customOverlay.setContent(content)}

            }
            function closeOverlay(customOverlay) {
              return function() {
                customOverlay.setMap(null)
              };
            }
            // function makeOverListener(map, marker, infowindow) {
            //   return function() {
            //     infowindow.open(map, marker);
            //   };
            // }
//   function goReadPage(statNm) {
//     return function(){
//       console.log(statNm)
//     }
//   }
//
// // 인포윈도우를 닫는 클로저를 만드는 함수입니다
// function makeOutListener(infowindow) {
//     return function() {
//         infowindow.close();
//     };
// }


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
    watch: {
      'MapOptions.level'(cur, /*prev*/){
       // console.log(`[LEVEL CHAGNE]: ${cur} =>${prev}}`)  for testing
        this.mapInstance.setLevel(cur)
      }
    }

  

    
}
</script>

<style  lang="scss"  scoped>
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
<style >
.overlay_info {
  border-radius: 6px;
  margin-bottom: 12px;
  float:left;
  position: relative;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;background-color:#fff;
}

.overlay_info:nth-of-type(n) {
  border:0;
  box-shadow: 0px 1px 2px #888;
}
.overlay_info .topTitle
{
  display: block;
  background: #d95050 url(https://user-images.githubusercontent.com/83811729/141263590-aba1330b-7993-4eb3-b2f3-f8f83f0eaea1.png) no-repeat right 14px center;
  text-decoration: none;
  color: #fff;
  padding:12px 36px 6px 14px;
  font-size: 10px;
  border-radius: 6px 6px 0 0
}
.overlay_info .topTitle span
{
  margin-left: 40px;
  color: #ffffff;
  font-size: 2.1em;
  font-weight: bold;
}
.overlay_info .desc
{
  font-family: "Montserrat", sans-serif;
  padding: 20px 0 10px 0;
  text-align: left;
  margin: -10px 20px 0 20px;
  position: relative;
  min-width: 190px;
  white-space: normal;
}
.overlay_info .name
{
  font-size: 1.2em;
  font-weight: bold;
  color: #333;
}
.overlay_info .name a{
  text-decoration: none;
  color: #333;
}
hr.solid {
  border-top: 2px solid #bbb;
}

.overlay_info .address span{
  font-size: 13px;
  color: #333;
  margin-top: 4px;
}
.overlay_info .address .fa-map-marker-alt{
  margin: 6px 5px 0 0;
  color: #3F51B5;
  font-size: 22px
}
.overlay_info .tel span{
  font-weight: 600;
  font-size: 1em;
  color: #333;
  margin-top: 8px;
}
.overlay_info .tel .fa-phone{
  margin: 6px 5px 0 0;
  color: #3F51B5;
  font-size: 22px
}
.overlay_info .status span{
  font-weight: 600;
  font-size: 1em;
  color: #333;
  margin-top: 7px;
}
.overlay_info .status .fa-info-circle{
  margin: 6px 5px 0 0;
  color: #3F51B5;
  font-size: 22px
}
.overlay_info .type span{
  font-weight: 500;
  font-size: 1em;
  color: #333;
  margin-top: 7px;
}
.overlay_info .type .fa-plug{
  margin: 6px 5px 0 3px;
  color: #3F51B5;
  font-size: 22px
}

hr.soft {
  border-top: 0.7px solid #aaa;
}
.overlay_info:after
{
  content:'';position: absolute;
  margin-left: -11px;
  left: 50%;
  bottom: -12px;
  width: 22px;
  height: 12px;
  background:url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png) no-repeat 0 bottom;
}
</style>
