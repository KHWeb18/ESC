<template>
    <div>
        <board-register-form @submit="OnSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import BoardRegisterForm from '../../components/board/BoardRegisterForm.vue'
export default {
  components: { BoardRegisterForm },
    name: 'BoardRegister',

    methods: {
        OnSubmit(payload) {
            const  { memberId, title, content, img,category} = payload
            console.log( memberId, title, content, img)
            axios.post('http://localhost:7777/board/boardRegister',{memberId, title, content, img,category})
            .then( () =>{
                alert('글이등록되었습니다.')
                this.$router.push({name:"FreeBoardListPage"})
            })
        }
    }

}
</script>