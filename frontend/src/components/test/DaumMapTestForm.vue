<template>
    <div class="kmap" ref="map">

    </div>
</template>

<script>
/*eslint no-mixed-spaces-and-tabs: ["error", "smart-tabs"]*/
export default {
    props:['options'],

    mounted(){
        let kakao = window.kakao
        console.log(this.$refs.map) // should be not null
        var container = this.$refs.map
        // const {center, level}  = this.options
        const mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(37.54699, 127.09598),
            level: 4,
        }); //지도 생성 및 객체 리턴
        console.log(mapInstance)

      var imageSrc = 'https://user-images.githubusercontent.com/83811729/141110524-2eb6207b-b3a0-453b-8440-8429673b2cba.png', // 마커이미지의 주소입니다
          imageSize = new kakao.maps.Size(30, 45), // 마커이미지의 크기입니다
          imageOption = {offset: new kakao.maps.Point(20, 42)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
      var markerPosition  = new kakao.maps.LatLng(37.54699, 127.09598);

        var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage // 마커이미지 설정

});
        marker.setMap(mapInstance);

      // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
      var content = `<div class="overlay_info">
      <div class="topTitle"><span>충전소 정보</span></div>
      <div class="desc">
      <span class="name">종묘 공영주차장</span>
      <hr class="solid">

      <div class="address">
      <i class="fas fa-map-marker-alt"></i>
      <span>서울특별시 종로구 종로 157 가나다라마ㅏ사</span>
      </div>

      <div class="tel">
      <i style="color: #3F51B5; font-size: 20px" class="fas fa-phone"></i>
      <span>1661-9408</span>
      </div>

      <div class="status">
      <i style="color: #3F51B5; font-size: 20px" class="fas fa-info-circle"></i>
      <span>사용 가능</span>
      </div>
      </div>
      </div>`;

// 커스텀 오버레이가 표시될 위치입니다
      var position  = new kakao.maps.LatLng(37.54699, 127.09598);

// 커스텀 오버레이를 생성합니다
      var customOverlay = new kakao.maps.CustomOverlay({
        map: mapInstance,
        position: position,
        content: content,
        xAnchor: 0.53, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
        yAnchor: 1.3, // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
        removable: true
      });

      // customOverlay.setMap(mapInstance)
      kakao.maps.event.addListener(marker, 'click', function() {
        customOverlay.setMap(mapInstance);
      });

    },
  methods: {
    addMyPositionMarker(){
      let kakao = window.kakao
      var myPosition  = new kakao.maps.LatLng(this.myPositionLat, this.MyPositoinLng);
      var myPositionMarker = new kakao.maps.Marker({ position: myPosition});
      myPositionMarker.setMap(this.FirstmapInstance)
    },
    customOverlay(){

    }
  }
}
</script>
<style>
.kmap{
    width: 100%;
    height: 600px
}
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
hr.solid {
  border-top: 2px solid #bbb;
}

.overlay_info .address span{
  font-size: 13px;
  color: #333;
  margin-top: 4px;
}
.overlay_info .address .fa-map-marker-alt{
  margin: 6px 2px 0 0;
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
  margin: 6px 2px 0 0;
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
  margin: 6px 2px 0 0;
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
