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
                    height="250"
                    :src="item.carImage"
                ></v-img>

                <v-img max-height="100" max-width="70" class="ml-5 mb-n3" :src="item.brandImage"></v-img>

                <v-card-title class="text-subtitle-1">{{ item.cartype }}</v-card-title>

                <v-card-text>
                  <v-row align="center" class="mx-0">
                    <v-rating :value="4.5" color="amber" dense
                        half-increments readonly size="14"></v-rating>

                    <div class="grey--text ms-4">
                      4.5
                    </div>
                  </v-row>

                  <div class="my-4 text-subtitle-1">
                    $ • I{{ item.subsidy }}
                  </div>


                </v-card-text>

                <v-divider class="mx-4"></v-divider>


                <v-card-actions>
                  <v-btn color="deep-purple lighten-2" text class="white">
                    visit
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
                      탑승인원 : {{item.personnel}}<br/>
                      탑승인원 : {{item.personnel}}<br/>
                      탑승인원 : {{item.personnel}}<br/>
                      탑승인원 : {{item.personnel}}<br/>
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
