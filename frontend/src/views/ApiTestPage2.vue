<template>
  <div>
    <div v-for="(item,idx) in news" :key="idx">
      <div>설명 : {{item.description}}</div>
      <div>링크 : {{item.link}}</div>
      <div>날짜 : {{item.pubDate}}</div>
      <div>제목 : {{item.title}}</div>
      <v-divider></v-divider>
    </div>
    <v-btn @click="dataTest">클릭</v-btn>

  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ApiTestPage2",
  data() {
    return {
      news: '',
      temp: ''
    }
  },
  methods: {
    dataTest(){
      axios.get(`http://localhost:5000/news`)
          .then((res)=>{
            let stringify = JSON.stringify(res.data.items)
            let replace = stringify.replace(/<b>/g, "").replace(/<\/b>/g, "")
            this.news = JSON.parse(replace)
            console.log(this.news)
          })
    },
  }
}
</script>

<style scoped>

</style>
