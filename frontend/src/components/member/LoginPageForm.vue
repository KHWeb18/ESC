<template>
  <v-container style="max-width: 330px">
    <form @submit.prevent="OnSubmit">
      <v-text-field label="아이디" type="text" v-model="memberId" >
      </v-text-field>

      <v-text-field label="비밀번호" type="password" v-model="memberPw"  :rules="passwordRules">
      </v-text-field>
      <v-btn @click="OnSubmit">로그인</v-btn>
      <v-btn route :to="{name: 'SignupPage'}">회원가입</v-btn>
    <v-btn route :to="{name: 'FindByPwPage'}">비밀번호찾기</v-btn>
    </form>
  </v-container>
</template>


<script>
import { mapActions, mapState } from 'vuex'


  export default {
    name: 'LoginPageForm',
    data() {
      return {
        memberId: '',
        memberPw: '',

      }
    },
    computed: {
      ...mapState(['passwordRules','memberList'])
    },
    methods: {
      ...mapActions(['fetchMemberList']),

      OnSubmit(){
        
       for(var i = 0; i < this.memberList.length; i++){
             if(this.memberList[i].memberId == this.memberId){
                 
                 const {memberId ,memberPw } = this
                 this.$emit('submit' ,{ memberId ,memberPw})

                 return {
                     SelectedUser: 1
                 }
             }
            
             }
             let SelectedUser = null
        this.memberList.forEach(user =>{
            if(user.memberId === this.memberId) SelectedUser = user})
        if(SelectedUser ===null)alert('등록된 회원정보가없습니다.')
             
           }
        

        
      
    },
    created(){
      this.fetchMemberList()
    }
      
   
  }
  

</script>