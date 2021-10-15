<template>
    <div>
        <signup-page-form @submit="OnSubmit" :memberList="memberList"/>
    </div>
</template>

<script>
import axios from 'axios'
import {mapActions, mapState} from 'vuex'
import SignupPageForm from '../../components/member/SignupPageForm.vue'
export default {
    name: 'SignupPage',
    components: {
        SignupPageForm
    },
    computed:{
        ...mapState(['memberList'])
    },
    methods: {
        ...mapActions(['fetchMemberList']),
        OnSubmit(payload) {
            const  {memberId, memberPw , name, email, memberCar,memberBirthDay} = payload
            
            axios.post('http://localhost:7777/member/register', {memberId, memberPw , name, email, memberCar,memberBirthDay})
            .then( () => {
                alert('회원가입 완료')
            })
        }
    },
    created() {
        this.fetchMemberList()
    }
}
</script>