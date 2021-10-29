<template>
    <div>
        <notice-list-page-form :noticeList="noticeList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeListPageForm from '../../../components/board/notice/NoticeListPageForm.vue'
export default {
  components: { NoticeListPageForm },
    name: 'NoticeListPage',
    computed:{
        ...mapState(['noticeList'])
    },
    methods: {
        ...mapActions(['GetNoitceList'])
    },
    created(){
        this.GetNoitceList()
    }
}
</script>