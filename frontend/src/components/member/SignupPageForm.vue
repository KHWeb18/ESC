<template>
<v-container style="max-width: 550px">
   <form @submit.prevent="OnSubmit">
             <h3>회원가입</h3>
            <v-text-field  :rules="nameRules"  required v-model="name"
            label="회원이름" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
            <v-text-field    v-model="memberId"
            label="아이디" type="text" prepend-icon="mdi-account" flat solo>
            </v-text-field>
             <v-text-field    :rules="passwordRules" required  v-model="memberPw"
            label="비밀번호" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
            <v-text-field    :rules="memberPwCheck" required  
            label="비밀번호확인" type="password" prepend-icon="mdi-lock" flat solo>
            </v-text-field>
              <v-text-field :rules="emailRules" required v-model="email"
            label="이메일" type="text" prepend-icon="mdi-email-multiple" flat solo>
            </v-text-field>
            <v-text-field  required v-model="memberBirthDay"
             type="Date" prepend-icon="mdi-cake" flat solo>
            </v-text-field>
            <v-select :items="SelectCarList"  v-model="memberCar" label="보유차종선택"> </v-select>  
            <v-btn  type="submit">가입</v-btn>
   </form>
</v-container>
</template>

<script>
import { mapState} from 'vuex'
export default {
    name: 'SignupPageForm',
    props: {
        memberList: {
            type:Array
        }
    },
    data() {
        return {
            memberId: '',
            memberPw: '',
            memberBirthDay: '',
            name: '',
            email: '',
            memberCar: '',
            memberPwCheck: [v => this.memberPw ===v || '비밀번호가 일치하지않습니다' ],
            SelectCarList: [
                {text: '전기차',value: '전기차'},
                {text: '일반차',value: '일반차'},
                {text: '하이브리드차',value: '하이브리드차'},
                {text: '없음',value: '없음'} ],
            loginAlert: '보유차종을 선택하여주십시오.'               
            
        }
    },
    methods: {
        
        OnSubmit() {

            const {memberId, memberPw , name, email, memberCar, memberBirthDay} = this
            let coin = null;
                for(var i = 0 ; i < this.memberList.length ; i ++){

                      if(this.memberList[i].memberId === this.memberId){
                    alert('등록된 아이디가있습니다.')
                    return coin = 1;
                                                                 }
                
                                                                }
              if(coin ==null){                                                  
            if(this.memberCar !=''){this.$emit('submit', {memberId, memberPw , name, email, memberCar,memberBirthDay})}
            else{ alert(this.loginAlert)}
              }
        }
    },
    computed: {
        ...mapState(['emailRules','nameRules','passwordRules'])
    },
    
}
</script>


