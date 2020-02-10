import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import getters from './getters'
import common from './modules/common'
import login from './modules/login'


Vue.use(Vuex)
const store = new Vuex.Store({
  state: {

  },
  modules: {
    user,
    common,
    login
  },
  getters,
  actions: {

  },
  mutations: {

  }
})

export default store
