<template>
  <div>
    <v-btn @click="dataTest">클릭</v-btn>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ApiTestPage2",
  methods: {
    dataTest(){
      axios.get(`https://openapi.gg.go.kr/ParkingPlace?Key=b56bbd16a7da473c9875f0856c67006a&Type=json&pIndex=1&pSize=100&SIGUN_NM=%EA%B3%A0%EC%96%91%EC%8B%9C`)
          .then((res)=>{
            console.log(res.data)
          })
    },
  }
}
</script>

<style scoped>

</style>
