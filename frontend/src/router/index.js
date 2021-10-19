import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SignupPage from '../views/member/SignupPage'
import FindByIdPage from '../views/member/FindByIdPage'
import FindByPwPage from '../views/member/FindByPwPage'
import MainHomePage from '../views/MainHomePage'
import DeleteMember from '../views/member/DeleteMember'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
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
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
