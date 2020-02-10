import Vue from 'vue'
import Router from 'vue-router'
import PageRouter from './page'
import ViewsRouter from './views'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [...PageRouter,...ViewsRouter]
})
