<template>
    <div>
        <v-card dark>
            <v-card-subtitle>
                <v-btn style="margin-left: 36%" @click="GoParkingSearchServiceList()" >
                    주차장표준데이터   
                </v-btn>
                <v-btn @click="GokakaomapTest()">
                    카카오로찾기
                </v-btn>
            </v-card-subtitle>
        </v-card>
    </div>
</template>

<script>
export default {
    
    methods:{
        GoParkingSearchServiceList(){
            this.$router.push('/parkingSearchServiceList')
        },
        GokakaomapTest(){
            this.$router.push('/kakaomapService')
        }
    }
}
</script>