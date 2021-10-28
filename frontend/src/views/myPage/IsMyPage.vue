<template>
    <div>
        <my-page-menu/>
        <is-my-page-form :TargetList="TargetList"/>
    </div>
</template>



<script>

import MyPageMenu from '../../components/myPage/MyPageMenu.vue'
import IsMyPageForm from '../../components/myPage/IsMyPageForm.vue'
export default {
      name: 'IsMyPage',
  components: {MyPageMenu, IsMyPageForm  },
}
</script>
