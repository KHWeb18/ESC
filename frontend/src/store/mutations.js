import {

    COOKIE_TO_SESSION, REMOVE_IS_LOGIN, REMOVE_SESSION, SET_IS_LOGIN, FETCH_MEMBER_LIST,
    FETCH_BOARD_LIST, FETCH_BOARD, FETCH_TARGET_LIST,
    FETCH_COMMENT_LIST, FETCH_COMMENT, FETCH_REPLY_LIST, FETCH_COMMENT_LIKES,SET_MEMBER_NO,FIND_MEMBER_INFO,
    GET_NOTICE_LIST,GET_NOTICE,


} from './mutation-types'

export default {
    [COOKIE_TO_SESSION] (state,payload) {
        state.session = payload;
    },
    [SET_IS_LOGIN] (state,payload) {
        state.isLogin = payload;
    },
    [SET_MEMBER_NO] (state,payload) {
        state.loginMemberNo  = payload
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
    },
    [FETCH_TARGET_LIST] (state,TargetList) {
        state.TargetList = TargetList
    },
    [FIND_MEMBER_INFO] (state, payload) {
        state.memberInfo = payload
    },
    //공지
    [GET_NOTICE_LIST] (state,payload) {
        state.noticeList = payload
    },
    [GET_NOTICE] (state,payload) {
        state.notice = payload
    },

    //comment
    [FETCH_COMMENT_LIST] (state,comments) {
        state.comments = comments;
    },
    [FETCH_COMMENT] (state,comment) {
        state.comment = comment;
    },
    [FETCH_REPLY_LIST] (state,replies) {
        state.replies = replies;
    },
    [FETCH_COMMENT_LIKES] (state,commentLikes) {
        state.commentLikes = commentLikes
    },
}

