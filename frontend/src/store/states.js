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
    memberList: [],
    session: null,
    isLogin: false,
    loginMemberNo: [],
    auth: null,

    //게시판
    boardList: [],
    board: null,
    TargetList: [],
    memberInfo: null,
    //공지
    noticeList: [],
    notice: null,

    // 댓글
    comments: [],
    comment: null,
    // 대댓글
    replies: [],
    // 댓글 좋아요
    commentLikes: [],
}

