<template>
    <div>

        <my-page-menu/>
        <is-edit-member-form :TargetList="TargetList"/>
    </div>
</template>



<script>

import MyPageMenu from '../../components/myPage/MyPageMenu.vue'
import IsEditMemberForm from '../../components/myPage/IsEditMemberForm.vue'
export default {
      name: 'IsEditMemberPage',
  components: {IsEditMemberForm, MyPageMenu  },
}
</script>
