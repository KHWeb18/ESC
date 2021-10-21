import {
  
    COOKIE_TO_SESSION, REMOVE_IS_LOGIN, REMOVE_SESSION, SET_IS_LOGIN, FETCH_MEMBER_LIST,
    FETCH_BOARD_LIST,FETCH_BOARD

} from './mutation-types'

export default {
    [COOKIE_TO_SESSION] (state,payload) {
        state.session = payload;
    },
    [SET_IS_LOGIN] (state,payload) {
        state.isLogin = payload;
    },
    [REMOVE_SESSION] (state,payload) {
        state.session = payload;
    },
    [REMOVE_IS_LOGIN] (state,payload) {
        state.isLogin = payload;
    },
    [FETCH_MEMBER_LIST] (state,memberList) {
       state.memberList = memberList
    },
    //게시판
    [FETCH_BOARD_LIST] (state, boardList) {
        state.boardList = boardList
    },
    [FETCH_BOARD] (state, board) {
        state.board = board
    }
  
}

