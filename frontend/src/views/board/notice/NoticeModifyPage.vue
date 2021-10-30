<template>
    <div>
        <notice-modify-page-form v-if="notice" :notice="notice"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeModifyPageForm from '../../../components/board/notice/NoticeModifyPageForm.vue'
export default {
  components: { NoticeModifyPageForm },
  name: 'NoticeModifyPage',
    props: {
        boardNo:{
            requeired: true
        }
    },
    computed:{
        ...mapState(['notice'])
    },
    methods: {
        ...mapActions(['GetNotice'])
    },
    created(){
        this.GetNotice(this.boardNo)
    }
}
</script>