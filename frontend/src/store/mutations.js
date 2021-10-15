import {
    COOKIE_TO_SESSION, REMOVE_IS_LOGIN, REMOVE_SESSION, SET_IS_LOGIN

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
}

