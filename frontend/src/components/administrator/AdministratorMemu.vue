<template>
    <div>
        <table >
        <tr>
     
            <v-btn depressed route :to="{name: 'MemberManagement'}">
                회원관리
            </v-btn>
            
            <v-btn depressed route :to="{name: 'ReportedBoard'}">
                신고된게시글    
            </v-btn>

            <v-btn depressed route :to="{name: 'ReportedComment'}">
                신고된댓글
            </v-btn>


        </tr>
    </table>

    </div>
</template>

<script>
export default {
        name: 'BoardListMenu',

}
</script>