import Vue from "vue";
import axios from "axios";
import cookies from "vue-cookies";
Vue.use(cookies);
import {
  FETCH_MEMBER_LIST,
  COOKIE_TO_SESSION,
  REMOVE_IS_LOGIN,
  REMOVE_SESSION,
  SET_IS_LOGIN,
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
  SET_TABLE_MODE,
  SET_CARD_MODE,
  GET_REPORTED_BOARD_LIST,
  GET_REPORTED_COMMENT_LIST,
  SET_ITEM_LIST,
  //마이페이지 내 게시글
  FETCH_MEMBER_BOARD_LIST, FETCH_MY_BOARD_LIST,
} from "./mutation-types";

export default {
  fetchMemberList({ commit }) {
    return axios
      .post("http://localhost:7777/member/getMemberList")
      .then((res) => {
        console.log(res.data);
        commit(FETCH_MEMBER_LIST, res.data);
      })
      .catch((err) => {
        alert(err.response.data.message);
      });
  },
  // 쿠키값을 state.session에 저장함
  cookieToSession({ commit }) {
    let data;
    let member;

    if (Vue.$cookies.get("user") !== null) {
      data = Vue.$cookies.get("user");
      member = data.memberId;
    } else {
      data = null;
    }
    commit(COOKIE_TO_SESSION, member);

    let numData;
    let memberNo;
    if (Vue.$cookies.get("userNo") !== null) {
      numData = Vue.$cookies.get("userNo");
      memberNo = numData.memberNo;
    } else {
      data = null;
    }
    commit(SET_MEMBER_NO, memberNo);

    // 마이페이지 내 정보
    let memberInfo;
    if (Vue.$cookies.get("user") !== null) {
      memberInfo = Vue.$cookies.get("user");
    } else {
      memberInfo = null;
    }
    commit(COOKIE_TO_SESSION, memberInfo);
  },
  // isLogin(로그인 확인용) 세팅
  setIsLogin({ commit }) {
    let temp;
    if (Vue.$cookies.get("user") !== null) {
      temp = true;
    } else {
      temp = false;
    }
    commit(SET_IS_LOGIN, temp);
  },
  setAuth({ commit }) {
    let data;

    if (Vue.$cookies.get("userAuth") !== null) {
      data = Vue.$cookies.get("userAuth");
    }
    commit(SET_AUTH, data);
  },
  logout({ commit }) {
    Vue.$cookies.remove("userAuth");
    Vue.$cookies.remove("userNo");
    Vue.$cookies.remove("user");
    commit(SET_AUTH, null);
    commit(REMOVE_SESSION, null);
    commit(REMOVE_IS_LOGIN, false);
  },
  //게시판
  fetchBoardList({ commit }) {
    return axios
      .post("http://localhost:7777/board/getBoardList")
      .then((res) => {
        commit(FETCH_BOARD_LIST, res.data);
      });
  },
  fetchBoard({ commit }, boardNo) {
    return axios
      .post(`http://localhost:7777/board/getBoard/${boardNo}`)
      .then((res) => {
        console.log(res.data);
        commit(FETCH_BOARD, res.data);
      });
  },
  fetchTargetList({ commit }, target) {
    return axios
      .post(`http://localhost:7777/board/getTargetList/${target}`)
      .then((res) => {
        commit(FETCH_TARGET_LIST, res.data);
      });
  },
  findMemberInfo({ commit }, memberNo) {
    return axios
      .post(`http://localhost:7777/member/findByMemberInfo/${memberNo}`)
      .then((res) => {
        commit(FIND_MEMBER_INFO, res.data);
      });
  },
  // 댓글
  fetchCommentList({ commit }, boardNo) {
    return axios
      .get(`http://localhost:7777/comment/lists/${boardNo}`)
      .then((res) => {
        commit(FETCH_COMMENT_LIST, res.data);
      });
  },
  fetchComment({ commit }, commentNo) {
    return axios
      .get(`http://localhost:7777/comment/${commentNo}`)
      .then((res) => {
        commit(FETCH_COMMENT, res.data);
      });
  },
  fetchReplies({ commit }, commentNo) {
    return axios
      .get(`http://localhost:7777/reply/lists/${commentNo}`)
      .then((res) => {
        commit(FETCH_REPLY_LIST, res.data);
      });
  },
  fetchCommentLikes({ commit }, commentNo) {
    return axios
      .get(`http://localhost:7777/comment/like/lists/${commentNo}`)
      .then((res) => {
        commit(FETCH_COMMENT_LIKES, res.data);
      });
  },
  GetNoitceList({ commit }) {
    return axios
      .post("http://localhost:7777/notice/getNoitceList")
      .then((res) => {
        commit(GET_NOTICE_LIST, res.data);
      });
  },
  GetNotice({ commit }, boardNo) {
    return axios
      .post(`http://localhost:7777/notice/getNotice/${boardNo}`)
      .then((res) => {
        commit(GET_NOTICE, res.data);
      });
  },
  SetTableMode({ commit }, payload) {
    if (payload == undefined) {
      commit(SET_TABLE_MODE, 1);
    } else if (payload) {
      console.log("여기는 액션의SetTableMode:" + payload);
      commit(SET_TABLE_MODE, payload);
    }
  },
  SetCardMode({ commit }, payload) {
    if (payload == undefined) {
      commit(SET_CARD_MODE, 2);
    } else if (payload) {
      commit(SET_CARD_MODE, payload);
    }
  },
  getReportedBoardList({ commit }) {
    return axios
      .post("http://localhost:7777/board/getReportedBoardList")
      .then((res) => {
        commit(GET_REPORTED_BOARD_LIST, res.data);
      });
  },

  getReportedCommentNoList({ commit }) {
    return axios
      .post("http://localhost:7777/comment/getReportedCommentNoList")
      .then((res) => {
        commit(GET_REPORTED_COMMENT_LIST, res.data);
      });
  },
  SetitemList({ commit }, item) {
    commit(SET_ITEM_LIST, item);
  },

  //마이페이지 내 게시글
  fetchMemberBoardList({ commit }, memberNo) {
    return axios
      .get(`http://localhost:7777/board/getMemberBoardList/${memberNo}`)
      .then((res) => {
        commit(FETCH_MEMBER_BOARD_LIST, res.data);
      })
      .catch((error) => {
        console.log(error);
      })
      .then((res) => {
        console.log(res);
      });
  },
  // 내 게시글 조회 예시
  fetchMyBoardList({ commit }, memberId) {
    return axios
        .get(`http://localhost:7777/board/getMyBoardList/${memberId}`)
        .then((res) => {
          commit(FETCH_MY_BOARD_LIST, res.data);
        });
  },
};
