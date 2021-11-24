<template>
  <div>
    <v-container>
      <table>
        <tr>
          <td>주차장명</td>
          <td>주소</td>
          <td>운영요일</td>
          <td>전화번호</td>
          <td>구분</td>
          <td>지우기</td>
        </tr>
            <tr v-for="items in paginatedData " :key="items">
                <a @click="goDetail(items)"><td>{{items.parkingNm}}</td></a>
                <td @click="goDetail(items)" v-if="items.addr1 !==''">{{items.addr1}}</td>
                <td  @click="goDetail(items)" v-if="items.addr1 =='' ">등록된정보가없습니다</td>
                <td>{{items.operatingday}}</td>
                <td v-if="items.call1 !==''">{{items.call1}}</td>
                <td v-if="items.call1 ==''">미등록!!!</td>
                <td>{{items.kind1}}</td>
          <td>
            <v-btn @click="deleteMyParkingState(items.rowNo)">삭제</v-btn>
          </td>
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
import { mapActions, mapState } from "vuex";
import axios from "axios";
Vue.use(cookies);
export default {
  data() {
    return {
      pageNum: 0,
    };
  },
  computed: {
    ...mapState(['session', 'myParkingStates']),
    pageCount() {
      let listLeng = this.myParkingStates.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize);
      if (listLeng % listSize > 0) page += 1;

      return page;
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize;
      return this.myParkingStates.slice(start, end);
    },
  },
  props: {
    myParkingStates: {
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
    ...mapActions(["SetitemList", "getMyParkingStateList"]),
goDetail(items){

      console.log(items)

        this.SetitemList(items)
        this.$cookies.set('itemsList', items, '1h')
        this.$cookies.set('itemslat', items.lat, '1h')
        this.$cookies.set('itemslng', items.lng, '1h')
        this.$router.push({name: 'MyParkingDetail',})

    },
    deleteMyParkingState(rowNo) {
      axios
        .post(`https://evsbackend.herokuapp.com/member/deleteMyParkingState/${rowNo}`)
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
