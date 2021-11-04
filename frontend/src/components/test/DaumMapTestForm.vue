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
        var markerPosition  = new kakao.maps.LatLng(center.lat, center.lng);
        var marker = new kakao.maps.Marker({
        position: markerPosition
        
});
        marker.setMap(mapInstance);
    }
}
</script>
<style scoped>
.kmap{
    width: 100%;
    height: 600px
}
</style>