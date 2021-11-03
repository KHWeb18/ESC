<template>
    <div>
        <daum-map-test-form :options="MapOptions"/>
    </div>
</template>

<script>
import DaumMapTestForm from '../../components/test/DaumMapTestForm.vue'

/*eslint no-mixed-spaces-and-tabs: ["error", "smart-tabs"]*/
export default {
  components: { DaumMapTestForm },
    name: 'kakaoMapDemo',
    component: {

    },
    data(){
        return{
            MapOptions : {
                center:  {
                    lat: 37.26286532,
                    lng: 127.02963007,
                },
                level: 8
            }
        }
    },
}
</script>

<style scoped>
.kmap{
    width: 100%;
    height: 600px
}
</style>