<template>
    <div>
        <table >
        <tr>
     
            <v-btn depressed route :to="{name: 'FreeBoardListPage'}">
                자유게시판
            </v-btn>
            
            <v-btn depressed route :to="{name: 'ChargingBoardListPage'}">
                충전소게시판
            </v-btn>

            <v-btn depressed route :to="{name: 'ParkingBoardListPage'}">
                주차장게시판
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