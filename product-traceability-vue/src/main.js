// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import { iconfontUrl, iconfontVersion } from '@/config/env'
import { loadStyle } from './util/util'
//全局样式设置
import './styles/common.scss'
import './assets/iconfont/iconfont.css'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);

Vue.config.productionTip = false

iconfontVersion.forEach((ele) => {
  loadStyle(iconfontUrl.replace('$key', ele))
})
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})


