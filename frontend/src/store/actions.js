import axios from 'axios'
import {
    FETCH_MEMBER_LIST
    COOKIE_TO_SESSION, REMOVE_IS_LOGIN, REMOVE_SESSION, SET_IS_LOGIN,

} from './mutation-types'

export default {
  
    fetchMemberList({ commit }) {
        return axios.post('http://localhost:7777/member/getMemberList')
        .then( (res) => {
            console.log(res.data)
            commit(FETCH_MEMBER_LIST, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
}
    // 쿠키값을 state.session에 저장함
    cookieToSession ({ commit }) {
        let data
        if(this.$cookies.get("user") !== null){
            data = this.$cookies.get("user")
        }else {
            data = null
        }
        commit(COOKIE_TO_SESSION, data)
    },
    // 로그인 유무 확인
    setIsLogin ({ commit }) {
        let temp
        if(this.$cookies.get("user") !== null) {
            temp = true
        }else{
            temp = false
        }
        commit(SET_IS_LOGIN, temp)
    },
    logout ({ commit }) {
        this.$cookies.remove('user')
        commit(REMOVE_SESSION, null)
        commit(REMOVE_IS_LOGIN, false)
    },
}
