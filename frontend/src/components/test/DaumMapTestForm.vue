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
        const {center, level}  = this.options
        const mapInstance = new kakao.maps.Map(container, {
            center : new kakao.maps.LatLng(center.lat, center.lng),
            level,
        }); //지도 생성 및 객체 리턴
        console.log(mapInstance)

      var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다
          imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
          imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

      // 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
      var markerPosition  = new kakao.maps.LatLng(center.lat, center.lng);

        var marker = new kakao.maps.Marker({
        position: markerPosition,
        image: markerImage // 마커이미지 설정

});
        marker.setMap(mapInstance);

      // 커스텀 오버레이에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
      var content = `<div class="overlay_info">
      <a href="https://place.map.kakao.com/17600274" target="_blank"><strong>스울 충전소</strong></a>
      <div class="desc">
      <img src="https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/place_thumb.png" alt="">
      <span class="address">스울 충전소 ~~~</span>
      </div>
      </div>`;

// 커스텀 오버레이가 표시될 위치입니다
      var position = new kakao.maps.LatLng(center.lat, center.lng);

// 커스텀 오버레이를 생성합니다
      var customOverlay = new kakao.maps.CustomOverlay({
        map: mapInstance,
        position: position,
        content: content,
        xAnchor: 0.5, // 커스텀 오버레이의 x축 위치입니다. 1에 가까울수록 왼쪽에 위치합니다. 기본값은 0.5 입니다
        yAnchor: 0.5 // 커스텀 오버레이의 y축 위치입니다. 1에 가까울수록 위쪽에 위치합니다. 기본값은 0.5 입니다
      });

      customOverlay.setMap(mapInstance)


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
  border:0; box-shadow: 0px 1px 2px #888;
}
.overlay_info a
{
  display: block;
  background: #d95050;
  background: #d95050 url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png) no-repeat right 14px center;
  text-decoration: none;
  color: #fff; padding:12px 36px 12px 14px;
  font-size: 14px;
  border-radius: 6px 6px 0 0
}
.overlay_info a strong
{
  background:url(https://user-images.githubusercontent.com/83811729/140928869-499c8c5e-751a-47b0-ba71-e4e0dd78e0f0.png) no-repeat;
  padding-bottom: 10px;
  padding-left: 27px;
}
.overlay_info .desc
{
  padding:14px;
  position: relative;
  min-width: 190px;
  height: 56px
}
.overlay_info img
{
  vertical-align: top;
}
.overlay_info .address
{font-size: 12px;
  color: #333;
  position: absolute;
  left: 80px;
  right: 14px; top: 24px; white-space: normal
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
