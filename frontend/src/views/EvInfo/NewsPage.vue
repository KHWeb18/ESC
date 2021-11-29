<template>
  <div>
    <v-container style="max-width: 1200px">
      <news-form :newsList="newsList"></news-form>
    </v-container>
  </div>
</template>

<script>
import NewsForm from "../../components/EvInfo/NewsForm";
import {mapActions, mapState} from "vuex";
export default {
  name: "NewsPage",
  components: {NewsForm},
  computed: {
    ...mapState(['newsList'])
  },
  mounted() {
    this.fetchNews()
  },
  methods: {
    ...mapActions(['fetchNews'])
  }
}
</script>

<style scoped>
.table{
  cursor: pointer;
}
</style>
