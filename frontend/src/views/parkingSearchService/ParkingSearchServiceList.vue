<template>
<div>
   <div id="parkingmap" style="max-width:800px" class="kmap" ref="map">

        </div>
    <div class="InfoTable">
        <table>
            <tr id="headerTr">
                <td>즐겨찾기</td>
                <td>주차장명</td>
                <td>소재지도로명주소</td>
                <td>운영요일</td>
                <td>전화번호</td>
                <td>요금정보</td>
            </tr>
            <tr v-for=" (items,idx) in paginatedData " :key="idx">
                <td><button @click="addMyParkingState(session,items)"><v-icon>mdi-star</v-icon></button></td>
                <a @click="showMetheMarker(items)"><td>{{items.주차장명}}</td></a>
                <td @click="goDetail(session,items)" v-if="items.소재지도로명주소 !==''">{{items.소재지도로명주소}}</td>
                <td  @click="goDetail(session,items)" v-if="items.소재지도로명주소 =='' ">등록된정보가없습니다.</td>
               <td>{{items.운영요일}}</td>
                <td v-if="items.전화번호 !==''">{{items.전화번호}}</td>
                <td v-if="items.전화번호 ==''">미등록</td>
                <td>{{items.요금정보}}</td>
            </tr>
        </table>
        <div class="btn-cover">
        <button class="levelControll" @click="levelControll(-1)"><span class="material-icons">zoom_in</span></button>
        <button class="levelControll" @click="levelControll(1)"><span class="material-icons">zoom_out</span></button>
            <button  style="margin-left: 20%;" :disabled="pageNum === 0" @click="prevPage" class="page-btn"><v-icon>mdi-arrow-left-bold</v-icon></button>
            <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn"><v-icon>mdi-arrow-right-bold</v-icon></button>
            <v-icon>mdi-magnify</v-icon>
            <input style="border: 1px; margin-right: 18%" v-model="search" placeholder="주차장명 검색" @input="handleSearchInput" @keydown.tab="KeydownTab"/>
            
            </div>

        
        
   
        </div>
</div>
</template>

<script>
import parkingData from '../../assets/주차장/parkingData' 
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
import { mapActions, mapState } from 'vuex';
Vue.use(cookies)
export default {
    data() {
    return {
      parkingDataList: parkingData.records,
      pageSize: 10,
    pageNum: 0,           
    search: '',
    infowindow:null,
    mapInstance:null,
    MapOptions : {
                center:  {
                    // 초기 세팅값
                    lat: 37.26286532,
                    lng: 127.02963007,
                },
                level: 11
            }

    }
  },
  mounted(){
        let kakao = window.kakao
        console.log(this.$refs.map) // should be not null
        var container = this.$refs.map
        const {center, level}  = this.MapOptions
        this.mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(center.lat, center.lng),
            level,
        }); 
  },
  computed: {
    
    ...mapState(['session']),
    pageCount () {
      let listLeng = this.parkingDataList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.parkingDataList.slice(start, end);
    }
  },
  methods:{

    nextPage () {
      this.pageNum += 1;
    },
    prevPage () {
      this.pageNum -= 1;
    },
      showMetheMarker(value){
        console.log(value)
        if(value.위도==''){
          alert("해당주차장의 지도정보가없습니다.")
        }

          
          var container = this.$refs.map
          var level = 4;
          this.mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(value.위도, value.경도),
            level,
        }); 


           var markerPosition  = new kakao.maps.LatLng(value.위도,value.경도);
        var marker = new kakao.maps.Marker({ position: markerPosition});
        marker.setMap(this.mapInstance);

        var iwContent = `<div class="overlay_info">
      <div class="topTitle"><span>충전소 정보</span></div>
      <div class="desc">
      <span class="name"><a class="nameLink">주차장명:${value.주차장명}</a></span>
      <hr class="solid">

      <div class="address">
      <i class="fas fa-map-marker-alt"></i>
      <span>주소:${value.소재지도로명주소}</span>
      </div>

      <div class="tel">
      <i style="color: #3F51B5; font-size: 20px" class="fas fa-phone"></i>
      <span>tel:${value.전화번호}</span>
      </div>

      <div class="status">
      <i style="color: #3F51B5; font-size: 20px" class="fas fa-info-circle"></i>
      <span>요금:${value.요금정보}</span>
      </div>

      </div>
      </div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능
        iwPosition = new kakao.maps.LatLng(value.위도,value.경도), //인포윈도우 표시 
        iwRemoveable = true; 

            // 인포윈도우를 생성하고 지도에 표시
            this.infowindow = new kakao.maps.InfoWindow({
            // 인포윈도우가 표시될 지도
            position : iwPosition, 
            content : iwContent,
            removable : iwRemoveable });

        
       kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(this.mapInstance, marker, this.infowindow));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(this.infowindow));
      
      function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}


// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
function makeOutListener(infowindow) {
    return function() {
        infowindow.close();
    };
}
      







      },
    ...mapActions(['SetitemList']),
    formater(value){
      switch (value){
        case '03':
          return '삼번'
        case '06':
          return '육번'
        default:
          return '해당없음'
      }
    },

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
    goDetail(session,items){
      console.log(session)
      console.log(items)

        this.SetitemList(items)
        this.$cookies.set('itemsList', items, '1h')
        this.$cookies.set('itemslat', items.위도, '1h')
        this.$cookies.set('itemslng', items.경도, '1h')
        this.$router.push({name: 'ParkingDetail',})

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
          const filteredList = this.parkingDataList.filter(parkingDataList => parkingDataList.주차장명.includes(this.search))
        this.parkingDataList = filteredList; if(this.pageNum > 0){this.pageNum = 0} }, 500);}
        else if(this.search.length == 0){
        clearTimeout(this.debounce); this.debounce = setTimeout(() => { 
          this.parkingDataList = parkingData.records
          },500); 
          }},
  },
  created(){

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
#parkingmap{

  height: 800px;
}
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

</style>
