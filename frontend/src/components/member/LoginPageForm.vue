<template>
    
  <v-container style="max-width: 330px">
    <v-form v-model="valid">
   
    <h1 align="center">EVS</h1> 
    <br/> 
  
    <form @keyup.enter="OnSubmit">
      <v-text-field 
      
      single-line
       label="아이디" type="text" v-model="memberId" >
      </v-text-field>
      <v-text-field single-line 
      
       v-model="memberPw"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"  
      :rules="passwordRules"
      :type="show ? 'text' : 'password'" 
      name="input-10-1"
      label="비밀번호" 
      counter
      @click:append="show = !show">
      </v-text-field>
      <br/>
      
     
      <v-btn 
      width="310"
      color="gray"
      dark
      
     @click="OnSubmit">로그인</v-btn>
    
   
    <br/><br/>

    <v-btn text route :to="{name: 'FindByPwPage'}">아이디/비밀번호 찾기</v-btn>

      <v-btn text route :to="{name: 'SignupPage'}">회원가입</v-btn>
      <br/>
    </form>
      </v-form>
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
        show: false,

        password: 'Password',
        rules: {
          required: value => !!value || 'Required.',
          min: v => v.length >= 8 || 'Min 8 characters',
        },
      }
    },
    computed: {
      ...mapState(['passwordRules', 'memberList'])
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
