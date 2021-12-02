<template>
<div>
  <section>
    <v-container>
      <v-layout>
        <v-flex >
          <v-card>
                <v-tabs
                  v-model="tab"
                  background-color="deep-blue accent-4"
                  center-active
                  dark
                  show-arrows
                  class="hidden-md-and-down"
                >
                  <v-tab @click="filterBrand(item.name)" v-for="item in items" :key="item.name" >
                    <span >{{item.name}}</span>
                  </v-tab>
                </v-tabs>

                <v-tabs
                  v-model="tab"
                  background-color="deep-blue accent-4"
                  center-active
                  dark
                  show-arrows
                  class="hidden-xs-and-down hidden-lg-and-up"
                >
                  <v-tab @click="filterBrand(item.name)" v-for="item in items" :key="item.name" >
                    <span >{{item.name}}</span>
                  </v-tab>
                </v-tabs>   
          </v-card>
          
          <v-row>
            <v-col class="white-space" v-for="(item, idx) in filteredItems" :key="idx">
              <v-card
                  class="mx-auto my-12"
                  max-width="400"
              >

                <v-img
                    class="white--text align-end"
                    height="250"
                    :src="item.carImage"
                >
                <v-card-title >
                  <div>
                    {{ item.carType }}
                  </div>
                </v-card-title>
                </v-img>

          
                <v-img max-height="100" max-width="130" class="ml-5 mb-n3"  :src="item.brandImage">
                </v-img>
                

                <v-card-text>
                  <v-row align="center" class="mx-0" >    
                  </v-row>
                  <div class="my-4 text-subtitle-1 d-flex jusify-space-between">
                    국고보조금 : {{ item.subsidy }}
                    <v-spacer></v-spacer>
                    즐겨찾기 추가 : <button @click="addMyCar(item)" class="starBtn">
                                      <v-icon class="star">mdi-star</v-icon></button>
                    </div>
                </v-card-text>
                <v-divider class="mx-4"></v-divider>


                <v-card-actions>
                  <v-btn color="deep-purple lighten-2" text class="white" :href="item.url">
                    차량 홈페이지 이동
                  </v-btn>
                  <v-spacer></v-spacer>
                  <v-btn icon @click="changeShow(idx)" class="white">
                    <v-icon>{{ show === idx ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                  </v-btn>
                </v-card-actions>
                <v-expand-transition>
                  <div v-show="show === idx">
                    <v-divider></v-divider>
                    <v-card-text>
                      승차인원 : {{item.personnel}}<br/>
                      최고속도출력 : {{item.speed}}<br/>
                      1회충전주행거리 : {{item.charge}}<br/>
                      배터리 : {{item.battery}}<br/>
                      </v-card-text>
                  </div>
                </v-expand-transition>
              </v-card>
            </v-col>

          </v-row>
        </v-flex>
      </v-layout>
    </v-container>
  </section>
</div>
</template>

<script>
import Vue from 'vue'
import cookies from 'vue-cookies'
import axios from 'axios'
Vue.use(cookies)
import {mapState} from "vuex";
export default {
  name: "EvInfo",
  computed: {
    ...mapState(['carInfo', 'session' ]),
    
  },
  mounted() {
    this.filteredItems = this.carInfo
    console.log(this.filteredItems)
  },
  data() {
    return {
      show : null,
      tab: null,
      filteredItems: null,
      items:[
        {name: 'KIA'},
        {name: 'HyundaiMotorCompany'},
        {name: 'Chevrolet'},
        {name: 'BMW'},
        {name: '한불모터스'},
        {name: 'CEVO MOBILITY'},
        {name: 'EDISON EV'},
        {name: 'Jaguar Cars'},
        {name: 'KST Electric'},
        {name: 'Mercedes-Benz'},
        {name: 'RenaultSamsungMotors'},
        {name: 'SsangYongMotor'},
        {name: 'Tesla'},
      ]
    }
  },
  methods:{
    filterBrand(selected){
      let copy = this.carInfo
      // let result = copy.filter(x => x.brand.includes(selected))
      let result = copy.filter(x => x.brand === selected)
      this.filteredItems = result
      console.log(result)
    },
    changeShow(idx){
      if(this.show === idx){
        this.show = null
      }else{
        this.show = idx
      }
    },
    addMyCar(items){
      /* console.log(items) */
      if(this.session){
        const {brand , carType, personnel, speed , charge , battery, subsidy } = items
        /* console.log(carType) */
        axios.post(`http://localhost:7777/member/addMyCar/${this.session.memberNo}`,{brand , carType, personnel, speed , charge , battery, subsidy})
        .then( (res) => {
          alert(res.data)
        })
      }
      else if(!this.session){
        alert('로그인후 이용해주세요')
      }
    },
  },
 
}
</script>

<style scoped>
*{
  margin: 1;
  padding: 1;
  box-sizing: border-box;
  font-family: "Montserrat", sans-serif;
  user-select: none;
}
</style>