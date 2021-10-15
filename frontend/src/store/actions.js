import axios from 'axios'
import {
    FETCH_MEMBER_LIST
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