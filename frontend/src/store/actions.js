import Vue from "vue";
import axios from 'axios'
import cookies from "vue-cookies";
Vue.use(cookies)
import {
    FETCH_MEMBER_LIST,
    COOKIE_TO_SESSION,
    REMOVE_IS_LOGIN,
    REMOVE_SESSION,
    SET_IS_LOGIN,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_TARGET_LIST,
    FETCH_COMMENT_LIST, FETCH_COMMENT, FETCH_REPLY_LIST, FETCH_COMMENT_LIKES

} from './mutation-types'

export default {
  
    fetchMemberList({ commit }) {
        return axios.post('http://localhost:7777/member/getMemberList')
        .then( (res) => {
            console.log(res.data)
            commit(FETCH_MEMBER_LIST, res.data)
        }).catch(err=>{alert(err.response.data.message)})
    },
    // 쿠키값을 state.session에 저장함
    cookieToSession ({ commit }) {
        let data
        if(Vue.$cookies.get("user") !== null){
            data = Vue.$cookies.get("user")
        }else {
            data = null
        }
        commit(COOKIE_TO_SESSION, data)
    },
    // isLogin(로그인 확인용) 세팅
    setIsLogin ({ commit }) {
        let temp
        if(Vue.$cookies.get("user") !== null) {
            temp = true
        }else{
            temp = false
        }
        commit(SET_IS_LOGIN, temp)
    },
    logout ({ commit }) {
        Vue.$cookies.remove('user')
        commit(REMOVE_SESSION, null)
        commit(REMOVE_IS_LOGIN, false)
    },
    //게시판
    fetchBoardList({commit}) {
        return axios.post('http://localhost:7777/board/getBoardList')
        .then( (res) => {
            commit( FETCH_BOARD_LIST,res.data )
        })
    },
    fetchBoard({commit},boardNo) {
        return axios.post(`http://localhost:7777/board/getBoard/${boardNo}`)
        .then( (res) => { console.log(res.data)
            commit (FETCH_BOARD,res.data)
        })
    },
    fetchTargetList({commit},target) {
        
        return axios.post(`http://localhost:7777/board/getTargetList/${target}`)
        .then( (res) =>{
            commit(FETCH_TARGET_LIST,res.data) 
        }) 
    },
    // 댓글
    fetchCommentList ({ commit }, boardNo) {
        return axios.get(`http://localhost:7777/comment/lists/${boardNo}`)
            .then((res) => {
                commit(FETCH_COMMENT_LIST, res.data)
            })
    },
    fetchComment ({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/comment/${commentNo}`)
            .then((res) => {
                commit(FETCH_COMMENT, res.data)
            })
    },
    fetchReplies({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/reply/lists/${commentNo}`)
            .then((res) => {
                commit(FETCH_REPLY_LIST, res.data)
            })
    },
    fetchCommentLikes({ commit }, commentNo) {
        return axios.get(`http://localhost:7777/comment/like/lists/${commentNo}`)
            .then((res) => {
                commit(FETCH_COMMENT_LIKES, res.data)
            })
    },
}
