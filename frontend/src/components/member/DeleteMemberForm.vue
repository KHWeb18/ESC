<template>
    <form @submit.prevent="OnSubmit">
      <v-dialog :retain-focus="false" v-model="dialog" persistent max-width="400">
        <template v-slot:activator="{ on}">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            회원 탈퇴
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="text-h5">
           회원탈퇴를 정말 진행 할까요?
          </v-card-title>
          <v-card-text>회원 탈퇴를 진행하게 되시면 모든 자료들이 삭제됩니다. 
              그래도 진행하시겠습니까?</v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click.native="MemberDeleteCancle">
              탈퇴 취소
            </v-btn>
            <v-btn color="red darken-1" text @click.native="MemberDelete(member.memberNo)">
              확인
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </form>
</template>

<script>

import cookies from 'vue-cookies'
import axios from 'axios'
import Vue from 'vue'

Vue.use(cookies)

export default {
    name: 'DeleteMemberForm',
    data() {
        return{
            dialog: false
        }
    },
    methods: {
     MemberDeleteCancle(){
         this.dialog = false
        },
         MemberEnd(memberNo){
            axios.delete(`https://evsbackend.herokuapp.com/jpamemberManage/deleteMember/${memberNo}`)
            .then( ()=>{
                alert('회원탈퇴가 정상적으로 처리되었습니다.')
                this.$cookies.remove('memberId')
                this.$cookies.remove('memberNo')
                this.$cookies.remove('setter')
                this.$cookies.remove('coin')
                this.$store.state.isLogin = false
                this.$store.state.session =null
                this.$store.state.loginMemberNo =null
                this.sheet = false
                this.dialog = false
                this.$router.push({name: 'Home'})
                this.$router.go()
            })
               
            
        }
    }
}

</script>
