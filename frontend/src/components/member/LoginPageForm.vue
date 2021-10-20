<template>
  <v-form v-model="valid">
    <v-container style="max-width: 550px">


        <h3>로그인</h3>

          <v-text-field
            v-model="memberId"
            prepend-icon="mdi-account" 
            label="아이디"
            required
          ></v-text-field>

        <v-text-field
            v-model="password"
            :rules="passwordRules"
            prepend-icon="mdi-lock"
            label="비밀번호"
            required
          ></v-text-field>
          <v-btn  type="submit">로그인</v-btn>

    </v-container>
  </v-form>
</template>


<script>

  export default {
    data: () => ({
      valid: false,
      memberId: '',
     
      password:'',
      passwordRules: [
        v => !! v || '비밀번호를 작성해주세요.',
        v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요'
    ],

    
    }),
      
   
  }
  

</script>