<template>
    <div>
        
        <my-page-menu/>
        <is-my-board-form/>
    </div>
</template>



<script>

import MyPageMenu from '../../components/myPage/MyPageMenu.vue'
import IsMyBoardForm from '../../components/myPage/IsMyBoardForm.vue'
export default {
      name: 'IsMyBoardPage',
  components: {MyPageMenu, IsMyBoardForm},
}
</script>

