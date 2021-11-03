<template>
    <div>
        <table >
            <tr>
        
                <v-btn depressed route :to="{name: 'EvSubidy'}">
                    보조금 지원 및 전기차 리스트
                </v-btn>
                
                <v-btn depressed route :to="{name: 'ParkingBoardListPage'}">
                    전기차 뉴스
                </v-btn>


            </tr>
    </table>

    </div>
</template>

<script>
export default {
        name: 'EvInfoMenu',

}
</script>