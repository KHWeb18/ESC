import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SignupPage from '../views/member/SignupPage'
import FindByIdPage from '../views/member/FindByIdPage'
import FindByPwPage from '../views/member/FindByPwPage'
import MainHomePage from '../views/MainHomePage'
import DeleteMember from '../views/member/DeleteMember'

//게시판
import BoardRegister from '../views/board/BoardRegister'
import BoardListPage from '../views/board/BoardListPage'
import BoardReadPage from '../views/board/BoardReadPage'
import BoardModifyPage from '../views/board/BoardModifyPage'
import FreeBoardListPage from '../views/board/FreeBoardListPage'
import ChargingBoardListPage from '../views/board/ChargingBoardListPage'
import ParkingBoardListPage from '../views/board/ParkingBoardListPage'
import SuggestionBoardListPage from '../views/board/SuggestionBoardListPage'
//공지 게시판
import NoticeRegisterPage from '../views/board/notice/NoticeRegisterPage'
import NoticeListPage from '../views/board/notice/NoticeListPage'
import NoticeReadPage from '../views/board/notice/NoticeReadPage'
import NoticeModifyPage from '../views/board/notice/NoticeModifyPage'
//관리자페이지
import AdministratorPage from '../views/administrator/AdministratorPage'
import MemberManagement from '../views/administrator/MemberManagement'
import ReportedBoard from '../views/administrator/ReportedBoard'
import ReportedComment from '../views/administrator/ReportedComment'

import LoginPage from '../views/member/LoginPage'

import EvInfoPage from '../views/EvInfo/EvInfoPage'

//충전소찾기페이지
import DaumMaptest from '../views/charingSearchService/DaumMaptest'
import CharingSearchServiceBoardList  from '../views/charingSearchService/CharingSearchServiceBoardList'
import CharingSearchServiceReadPage from '../views/charingSearchService/CharingSearchServiceReadPage'
// 마이페이지
import IsMyPage from '../views/myPage/IsMyPage.vue'
import IsMyBoardPage from '../views/myPage/IsMyBoardPage.vue'
import IsLikePage from '../views/myPage/IsLikePage.vue'
import IsEditMemberPage from '../views/myPage/IsEditMemberPage.vue'
import ApiTestPage from "../views/ApiTestPage";
/////////////
import IsMyCommentListPage from '../views/myPage/IsMyCommentListPage.vue';
import ApiTestPage2 from "../views/ApiTestPage2";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signUpPage',
    name: 'SignupPage',
    component: SignupPage 
  },
  {
    path: '/findByIdPage',
    name: 'FindByIdPage',
    component: FindByIdPage
  },
  {
    path: '/findByPwPage',
    name: 'FindByPwPage',
    component: FindByPwPage
  },
  {
    path: '/mainHomePage',
    name: 'MainHomePage',
    component: MainHomePage
  },
  {
    path: '/deleteMember',
    name: 'DeleteMember',
    component: DeleteMember
  },
  {
    path: '/boardRegister',
    name: 'BoardRegister',
    component: BoardRegister
  },
  {
    path: '/boardListPage',
    name: 'BoardListPage',   
    component: BoardListPage
  },
  {
    path: '/boardReadPage/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage 
    },
    props: {
      default: true
    },
  },
  {
    path: '/boardModifyPage/:boardNo',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage  
    },   
    props: {
      default: true
    },
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/freeBoardListPage',
    name: 'FreeBoardListPage',   
    component: FreeBoardListPage
  },
  {
    path: '/parkingBoardListPage',
    name: 'ParkingBoardListPage',   
    component: ParkingBoardListPage
  },
  {
    path: '/chargingBoardListPage',
    name: 'ChargingBoardListPage',   
    component: ChargingBoardListPage 
  },
  {
    path: '/suggestionBoardListPage',
    name: 'SuggestionBoardListPage',   
    component: SuggestionBoardListPage 
  },
  {
    path: '/noticeRegisterPage',
    name: 'NoticeRegisterPage',   
    component: NoticeRegisterPage  
  },
  {
    path: '/noticeListPage',
    name: 'NoticeListPage',   
    component: NoticeListPage   
  },
  {
    path: '/noticeReadPage/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage  
    },
    props: {
      default: true
    },
  },
  {
    path: '/noticeModifyPage/:boardNo',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage     
    },
    props: {
      default: true
    },
  },
  {
    path: '/administratorPage',
    name: 'AdministratorPage',   
    component: AdministratorPage   
  },
  {
    path: '/memberManagement',
    name: 'MemberManagement',   
    component: MemberManagement   
  },
  {
    path: '/reportedBoard',
    name: 'ReportedBoard',   
    component: ReportedBoard    
  },
  {
    path: '/reportedComment',
    name: 'ReportedComment',   
    component: ReportedComment    
  },


  {
    path: '/evinfo',
    name: 'EvInfoPage',   
    component: EvInfoPage
  }, 
  //---------- 마이페이지 ---------------
  {
    path: '/isMyPage',
    name: 'IsMyPage',   
    component: IsMyPage
  },
  {
    path: '/isLikePage',
    name: 'IsLikePage',   
    component: IsLikePage
  },
  {
    path: '/isMyBoardPage',
    name: 'IsMyBoardPage',   
    component: IsMyBoardPage
  },
  {
    path: '/isEditMemberPage',
    name: 'IsEditMemberPage',   
    component: IsEditMemberPage
  },
  {
    path: '/isMyCommentListPage',
    name: 'IsMyCommentListPage',   
    component: IsMyCommentListPage
  },
  

    //api test
  {
    path: '/apiTest',
    name: ApiTestPage,
    component: ApiTestPage 
  },
  {
    path: '/apiTest2',
    name: ApiTestPage2,
    component: ApiTestPage2
  },
  //충전소찾기 페이지
  {
    path: '/daumMaptest',
    name: DaumMaptest,
    component: DaumMaptest
  },
  {
    path: '/charingSearchServiceBoardList',
    name: CharingSearchServiceBoardList,
    component: CharingSearchServiceBoardList
  },
  {
    path: '/charingSearchServiceReadPage/:statNm',
    name: 'CharingSearchServiceReadPage',
    components: {
      default: CharingSearchServiceReadPage     
    },
    props: {
      default: true
    },
    
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
