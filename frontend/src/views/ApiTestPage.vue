<template>
  <div>
    <v-btn @click="fetchData">fetch</v-btn>
    <div v-for="(a, i) in item" :key="i">
      <div>이름 : {{ a.statNm }}</div>
      <div>주소 : {{ a.addr }}</div>
      <v-divider></v-divider>
    </div>
    <v-divider></v-divider>
    {{ item[0] }}
  </div>
</template>

<script>
import axios from "axios";

//var convert = require('xml-js')

export default {
  name: "ApiTestPage",
  mounted() {

  },
  data() {
    return {
      requestLink: 'http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?',
      apiKey: '7Yn%2BwtpnhhN0JX1sYiW%2Bf0lHHNeWUIlA7FwpwyGl2UOGTNu%2FAZ2IUTCQFFwOM0IvRPMJOXiAiaHmlv54y6EwHA%3D%3D',
      item: [],
      heroku: 'https://esc-proxy.herokuapp.com/',

    }
  },
  methods:{
    fetchData(){
      axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=10&pageNo=1&zcode=41`)
          .then((res)=>{
            let xml = res.data.items[0].item
            console.log(res.data.items[0].item)
            console.log(typeof xml)
            return xml
            // let json = convert.xml2json(xml, { compact: true })
            // this.item = JSON.parse(json)
      }).then(this.setResults).catch((err)=>{
        console.log(err)
      })
    },
    setResults(results){
      this.item = results
    }
  }

}
</script>

<style scoped>

</style>
