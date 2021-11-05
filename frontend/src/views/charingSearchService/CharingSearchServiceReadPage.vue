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
        </table>
    </div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
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
                level: 3
            },

        }
    },
    computed: {
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
       // console.log(FirstmapInstance) 
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
            removable : iwRemoveable
});
        //console.log(infowindow)

        

        

    },
        

    created(){
     this.itemsList = this.$cookies.get('itemsList')
      
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