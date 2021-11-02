<template>
    <div>
        <notice-register-page-form @submit="OnSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import NoticeRegisterPageForm from '../../../components/board/notice/NoticeRegisterPageForm.vue'
export default {
  components: { NoticeRegisterPageForm },
    name: 'NoticeRegisterPage',
    methods:{   
        OnSubmit(payload){
            const {memberId, title, content, img, category} = payload
            axios.post('http://localhost:7777/notice/register',{memberId, title, content, img, category})
            .then ( () =>{
                alert("공지가 등록되었습니다.")
                this.$router.go()
            })
        }
    }
}
</script> 