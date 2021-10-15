import {
   FETCH_MEMBER_LIST
} from './mutation-types'

export default {
   [FETCH_MEMBER_LIST] (state,memberList) {
       state.memberList = memberList
   }
}

