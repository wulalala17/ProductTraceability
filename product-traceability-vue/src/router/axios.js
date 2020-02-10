// store.js


// 引入 axios
import Vue from 'vue'
import axios from 'axios'
import store from '../store/store'

axios.defaults.baseURL = "http://localhost:8702/"

export default axios