<template>
  <div>
    <h3>뉴스</h3>
    <news-form :newsList="newsList"></news-form>
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
