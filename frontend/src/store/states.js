import data from '../assets/evinfo/evcarinfo.json'

export default {
  
    emailRules: [
        v => !! v || '이메일을 작성해주세요.',
        v => /.+@.+\..+/.test(v) || '이메일 형식으로 작성해주세요',
    ],
    nameRules: [
        v => !!v || '이름을 작성해주세요',
        v => !/[~!@#$%^&*()_+{}]/.test(v) || '이름에는 특수문자를 넣을수없습니다.',
        v => !(v && v.length >= 20) || '이름은 20자를 넘길수없습니다.'
    ],
    passwordRules: [
        v => !! v || '비밀번호를 작성해주세요.',
        v =>  /^[a-zA-Z0-9]*$/.test(v) || '영문+숫자로만 입력해주세요'
    ],
    emailchkRules: [
        v => !! v || '인증번호를 입력해주세요.',
    ],
    memberList: [],
    session: null,
    isLogin: false,
    loginMemberNo: null,
    auth: null,

    //게시판
    boardList: [],
    board: null,
    TargetList: [],
    memberInfo: null,
    tableMode: null,
    cardMode: null,


    //공지
    noticeList: [],
    notice: null,

    //관리자페이지
    ReportedBoardList: [],
    reportedCommentList: [],
    //충전소찾게페이지
    items: null,
    

    // 댓글
    comments: [],
    comment: null,
    // 대댓글
    replies: [],
    // 댓글 좋아요
    commentLikes: [],
    
    // 마이페이지
    myBoardList: [],
    myCommentList: [], 
    // 마이페이지 즐겨찾기 
    myLikeList: [],
    myParkingStates:[],

    //자동차 정보 페이지용 JSON 데이터
    carInfo: data,
    newsList: [],
}
