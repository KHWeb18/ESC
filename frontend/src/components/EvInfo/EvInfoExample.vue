<template>
<div>
  <section>
    <v-container>
      <v-layout>
        <v-flex>
          <v-row>

            <v-col class="white-space" v-for="(item, idx) in carInfo.cars" :key="idx">
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
                    {{ item.cartype }}
                  </div>
                </v-card-title>
                </v-img>

                <v-img max-height="100" max-width="130" class="ml-5 mb-n3" :src="item.brandImage"></v-img>

                

                <v-card-text>
                  <v-row align="center" class="mx-0">    
                  </v-row>
                  <div class="my-4 text-subtitle-1">
                    국고보조금 : {{ item.subsidy }}
                  </div>
                </v-card-text>
                <v-divider class="mx-4"></v-divider>


                <v-card-actions>
                  <v-btn color="deep-purple lighten-2" text class="white" :href="item.url">
                    차량 홈페이지 이동
                  </v-btn>
                  <v-spacer></v-spacer>
                  <v-btn icon @click="show = idx" class="white">
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
import {mapState} from "vuex";

export default {
  name: "EvInfoExample",
  computed: {
    ...mapState(['carInfo', ]),

  },
  data() {
    return {
      show : false,
    }
  },
  methods:{

  }
}
</script>

<style scoped>

</style>
