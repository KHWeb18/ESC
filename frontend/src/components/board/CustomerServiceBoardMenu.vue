<template>
    <div>
        <table >
        <tr>
     
            <v-btn depressed route :to="{name: 'NoticeListPage'}">
                공지사항
            </v-btn>
            
            <v-btn depressed route :to="{name: 'SuggestionBoardListPage'}">
                건의게시판
            </v-btn>
        </tr>
    </table>

    </div>
</template>

<script>
export default {
        name: 'CustomerServiceBoardMenu',

}
</script>