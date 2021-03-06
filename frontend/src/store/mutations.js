import {

  COOKIE_TO_SESSION,
  REMOVE_IS_LOGIN,
  REMOVE_SESSION,
  SET_IS_LOGIN,
  FETCH_MEMBER_LIST,
  FETCH_BOARD_LIST,
  FETCH_BOARD,
  FETCH_TARGET_LIST,
  FETCH_COMMENT_LIST,
  FETCH_COMMENT,
  FETCH_REPLY_LIST,
  FETCH_COMMENT_LIKES,
  SET_MEMBER_NO,
  FIND_MEMBER_INFO,
  GET_NOTICE_LIST,
  GET_NOTICE,
  SET_AUTH,
  SET_CARD_MODE,
  SET_TABLE_MODE,
  GET_REPORTED_BOARD_LIST,
  GET_REPORTED_COMMENT_LIST,
  SET_ITEM_LIST,
  FETCH_MY_BOARD_LIST,
  FETCH_MY_COMMENT_LIST,
  FETCH_MY_LIKE_LIST,
  GET_MY_PARKING_STATES,
  FETCH_NEWS,
  FETCH_MY_CAR

} from './mutation-types'



export default {
  [COOKIE_TO_SESSION](state, payload) {
    state.session = payload;
  },
  [SET_IS_LOGIN](state, payload) {
    state.isLogin = payload;
  },
  [SET_MEMBER_NO](state, payload) {
    state.loginMemberNo = payload;
  },
  [REMOVE_SESSION](state, payload) {
    state.session = payload;
  },
  [SET_AUTH](state, payload) {
    state.auth = payload;
  },
  [REMOVE_IS_LOGIN](state, payload) {
    state.isLogin = payload;
  },
  [FETCH_MEMBER_LIST](state, memberList) {
    state.memberList = memberList;
  },
  //게시판
  [FETCH_BOARD_LIST](state, boardList) {
    state.boardList = boardList;
  },
  [FETCH_BOARD](state, board) {
    state.board = board;
  },
  [FETCH_TARGET_LIST](state, TargetList) {
    state.TargetList = TargetList;
  },
  [FIND_MEMBER_INFO](state, payload) {
    state.memberInfo = payload;
  },
  [SET_CARD_MODE](state, payload) {
    state.cardMode = payload;
  },
  [SET_TABLE_MODE](state, payload) {
    state.tableMode = payload;
  },
  //관리자페이지
  [GET_REPORTED_BOARD_LIST](state, payload) {
    state.ReportedBoardList = payload;
  },
  [GET_REPORTED_COMMENT_LIST](state, payload) {
    state.reportedCommentList = payload;
  },
  //공지
  [GET_NOTICE_LIST](state, payload) {
    state.noticeList = payload;
  },
  [GET_NOTICE](state, payload) {
    state.notice = payload;
  },

  //comment
  [FETCH_COMMENT_LIST](state, comments) {
    state.comments = comments;
  },
  [FETCH_COMMENT](state, comment) {
    state.comment = comment;
  },
  [FETCH_REPLY_LIST](state, replies) {
    state.replies = replies;
  },
  [FETCH_COMMENT_LIKES](state, commentLikes) {
    state.commentLikes = commentLikes;
  },
  //충전소 찾기페이지
  [SET_ITEM_LIST] (state,payload){
    state.items =payload
  },
  // 마이페이지
  [FETCH_MY_BOARD_LIST](state, myBoardList) {
    state.myBoardList = myBoardList;
  },
  [FETCH_MY_COMMENT_LIST](state, myCommentList) {
    state.myCommentList = myCommentList;
  },
  //마이페이지 즐겨찾기 
  [FETCH_MY_LIKE_LIST](state, myLikeList) {
    state.myLikeList = myLikeList;
  },
  [GET_MY_PARKING_STATES](state, payload){
    state.myParkingStates = payload
  },
  [FETCH_NEWS](state, payload){
    state.newsList = payload
  },
  [FETCH_MY_CAR](state, interestedCar) {
    state.interestedCar = interestedCar;
  },
};
