<template>
  <div>
    <v-card>
      <v-card-title>
        <h4>오늘의 전기차 뉴스</h4>
        <v-spacer></v-spacer>
        <v-text-field
            v-model="search"
            append-icon="mdi-magnify"
            label="Search"
            single-line
            hide-details
            class="shrink"
        ></v-text-field>
      </v-card-title>
      <v-data-table @click:row="goNews"
                    :headers="headers"
                    :items="newsList"
                    :search="search"
                    :page.sync="page"
                    :items-per-page="itemsPerPage"
                    class="table"
                    hide-default-footer
                    @page-count="pageCount = $event"
      ></v-data-table>
      <div class="text-center pt-2">
        <v-pagination class="blue-grey lighten-4"
                      v-model="page"
                      :length="pageCount"
        ></v-pagination>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "NewsForm",
  props: {
    newsList: {
      type: Array
    }
  },
  mounted() {
    this.filterDate()
  },
  data () {
    return {
      search: '',
      page: 1,
      pageCount: 0,
      itemsPerPage: 15,
      headers: [
        {text: '제목', align: 'center', value: 'title', width: "70%"},
        {text: '', value: ''},
        {text: '', value: ''},
        {text: '등록일자',align: 'center', value: 'pubDate'},
      ],
    }
  },
  methods: {
    goNews(event, idx) {
      window.open(idx.item.link, '_blank');
    },
    filterDate(){
      console.log(this.newsList.pubDate)
    }
  }
}
</script>

<style scoped>
.table{
  cursor: pointer;
}
</style>
