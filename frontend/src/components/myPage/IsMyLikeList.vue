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
          <td>지우기</td>
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
          <td>
            <v-btn @click="deleteMyState(items.rowNo)">삭제</v-btn>
          </td>
          <td></td>
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
      </div>
    </v-container>
  </div>
</template>

<script>
import Vue from "vue";
import cookies from "vue-cookies";
import { mapActions } from "vuex";
import axios from "axios";
/* import axios from "axios"; */

Vue.use(cookies);
export default {
  data() {
    return {
      pageNum: 0,
    };
  },
  computed: {
    pageCount() {
      let listLeng = this.myLikeList.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
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
    ...mapActions(["SetitemList", "fetchMyLikeList"]),
    goDetial(items) {
      this.SetitemList(items);
      this.$cookies.set("itemsList", items, "1h");
      this.$cookies.set("itemslat", items.lat, "1h");
      this.$cookies.set("itemslng", items.lng, "1h");
      this.$router.push({ name: "CharingSearchServiceReadPage" });
    },
    deleteMyState(rowNo) {
      axios
        .post(`https://evsbackend.herokuapp.com/member/deleteMyState/${rowNo}`)
        .then(() => {
          this.$router.go();
        });
    },
    nextPage() {
      this.pageNum += 1;
    },
    prevPage() {
      this.pageNum -= 1;
    },
  },
};
</script>
