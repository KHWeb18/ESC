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
            
            axios.post('https://evsbackend.herokuapp.com/member/register', {memberId, memberPw , name, email, memberCar,memberBirthDay})
            .then( () => {
                alert('회원가입 완료')
                this.$router.push('/mainHomePage')
            })
        }
    },
    created() {
        this.fetchMemberList()
    }
}
</script>
