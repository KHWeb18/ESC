<template>
  <div>
    <v-container>
      <table>
        <tr>
          <td>지점명</td>
          <td>주소</td>
          <td>충전타입</td>
          <td>사용시간</td>
          <td>CALL</td>
        </tr>
        <tr
          v-for="items in paginatedData"
          :key="items.lat + items.statNm + items.statUpdDt"
        >
          <td>{{ items.statNm }}</td>
          <a @click="goDetial(items)"
            ><td>{{ items.addr }}</td></a
          >
          <td>{{ items.chgerType }}</td>
          <td>{{ items.useTime }}</td>
          <td>{{ items.busiCall }}</td>
        </tr>
      </table>

      <div class="btn-cover">
        <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
          <v-icon>mdi-arrow-left-bold</v-icon>
        </button>
        <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }}</span>
        <button
          :disabled="pageNum >= pageCount - 1"
          @click="nextPage"
          class="page-btn"
        >
          <v-icon>mdi-arrow-right-bold</v-icon>
        </button>
      </div>
      <div>
        <!-- <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on">
              <span class="profileBtn">지역선택</span>
              <v-icon>arrow_drop_down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item
              v-for="location in locationList"
              :key="location.value"
              class="pointer"
              @click="FetchData(location.value)"
            >
              <v-list-item-title>{{
                location.text
              }}</v-list-item-title></v-list-item
            >
          </v-list>
        </v-menu> -->

<!--         <v-icon style="margin-left: 40px;">mdi-magnify</v-icon>
        <input
          style="border: 1px; margin-right: 18%"
          v-model="search"
          placeholder="지점명 검색"
          @input="handleSearchInput"
          @keydown.tab="KeydownTab"
        /> -->
      </div>
    </v-container>
  </div>
</template>

<script>
import Vue from "vue";
import cookies from "vue-cookies";
import { mapActions } from "vuex";
/* import axios from "axios"; */

Vue.use(cookies);
export default {
  data() {
    return {
/*       locationList: [
        { text: "강원도", value: 42 },
        { text: "경기도", value: 41 },
        { text: "경상남도", value: 48 },
        { text: "경상북도", value: 47 },
        { text: "광주광역시", value: 29 },
        { text: "대구광역시", value: 27 },
        { text: "대전광역시 ", value: 30 },
        { text: "부산광역시", value: 26 },
        { text: "서울특별시", value: 11 },
        { text: "전라남도 ", value: 46 },
        { text: "전라북도", value: 45 },
        { text: "제주특별자치도 ", value: 50 },
        { text: "울산광역시", value: 31 },
        { text: "인천광역시", value: 28 },
      ], 
      searchList: [],
      search: "", */
      pageNum: 0,
    };
  },
    computed: {
    pageCount () {
      let listLeng = this.myLikeList.length,
          listSize = this.pageSize,
          page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData () {
      const start = this.pageNum * this.pageSize,
            end = start + this.pageSize;
      return this.myLikeList.slice(start, end);
    },
    
  },
  props: {
    myLikeList: {
      type: Array,
      require: true,
    },
        pageSize: {
      type: Number,
      required: false,
      default: 10,
    },
  },
  methods: {
    ...mapActions(["SetitemList"]),
    goDetial(items) {
      this.SetitemList(items);
      this.$cookies.set("itemsList", items, "1h");
      this.$cookies.set("itemslat", items.lat, "1h");
      this.$cookies.set("itemslng", items.lng, "1h");
      this.$router.push({ name: "CharingSearchServiceReadPage" });
    },
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
    /*         handleSearchInput(e) { 
      
      this.search = e.target.value
      if(this.search.length !== 0){
        clearTimeout(this.debounce)
        this.debounce = setTimeout(() => { 
          const filteredList = this.item.filter(item => item.statNm.includes(this.search))
        this.item = filteredList; if(this.pageNum > 0){this.pageNum = 0} }, 500);}
        else if(this.search.length == 0){
        clearTimeout(this.debounce); this.debounce = setTimeout(() => { 
          axios.get(`${this.heroku}${this.requestLink}serviceKey=${this.apiKey}&numOfRows=${this.numOfRows}&pageNo=1&zcode=${this.zcode}`)
          .then( (res) =>{
          this.item = res.data.items[0].item
          })},500); 
          }}, */
  },
};
</script>
