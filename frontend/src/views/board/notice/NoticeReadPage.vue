<template>
    <div>
        <notice-read-page-form v-if="notice" :notice="notice"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeReadPageForm from '../../../components/board/notice/NoticeReadPageForm.vue'
export default {
  components: { NoticeReadPageForm },
    props:{
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