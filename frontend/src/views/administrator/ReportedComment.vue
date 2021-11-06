<template>
    <div>
      <administrator-memu/>
      <v-btn v-if="coin ==0" @click="load">정보받아오기</v-btn>
      <reported-comment-form v-if="ReportedCommentNoList" :ReportedCommentNoList="ReportedCommentNoList" />
      <p v-else>YOU HAVE TO FETCH.!</p>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
import AdministratorMemu from '../../components/administrator/AdministratorMemu.vue'
import ReportedCommentForm from '../../components/administrator/ReportedCommentForm.vue'
export default {
  components: { AdministratorMemu, ReportedCommentForm },
    name: 'ReportedCommentedForm',
    data() {
        return{
            ReportedCommentNoList: [],
            coin: 0,
        }
    },
    computed: {
        ...mapState(['reportedCommentList'])
    },
    methods:{
        ...mapActions(['getReportedCommentNoList']),
        load(){
            for(var i = 0  ;i < this.reportedCommentList.length; i++){
                axios.post(`http://localhost:7777/comment/getRePortedComment/${this.reportedCommentList[i].commentNo}`)
                .then( (res) => {
                    //this.ReportedCommentNoList.push(res.data)
                    this.ReportedCommentNoList.push(res.data)
                    this.coin = 1;
                })
                
            }
        },
        OnSubmit(){
          
        },
    },
    mounted(){
      
    },
    created(){
        this.getReportedCommentNoList()
        this.load()

    }
    
}
</script> 