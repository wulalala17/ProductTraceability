import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'
import getters from './getters'
import common from './modules/common'


Vue.use(Vuex)
const store = new Vuex.Store({
  state: {

  },
  modules: {
    user,
    common
  },
  getters,
  actions: {

  },
  mutations: {

  }
})

export default store
