<template>
  <el-container class="avue-container">
    <el-aside :style="{width: isCollapse ? asideWidthCollapse : asideWidth}" class="el-scrollbar">
      <!-- 左侧导航栏 -->
      <sidebar class="avue-sidebar"></sidebar>
    </el-aside>
    <el-container>
      <el-header height="auto"
        class="avue-tabs">
       
        <top />
        <!-- <tags /> -->
      </el-header>
      <el-main>
      </el-main>
      <el-main class="avue-main">
        <router-view></router-view>
        <!-- <keep-alive>
          <transition name="fade-transverse">
            <router-view class="avue-view"
              v-if="$route.meta.keepAlive" />
          </transition>
        </keep-alive>
        <transition name="fade-transverse">
          <router-view class="avue-view"
            v-if="!$route.meta.keepAlive" />
        </transition> -->
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { mapGetters } from 'vuex'
import tags from './tags'
import top from './top/'
import sidebar from './sidebar/'
// import { validatenull } from '@/util/validate'
// import { calcDate } from '@/util/date.js'
// import { setStore, getStore } from '@/util/store.js'

export default {
  components: {
    top,
    // tags,
    sidebar
  },
  name: 'index',
  data() {
    return {
       IsCollapse: true,
      // [侧边栏宽度] 正常状态
      asideWidth: '230px',
      // [侧边栏宽度] 折叠状态
      asideWidthCollapse: '65px',
      //刷新token锁
      // refreshLock: false,
      //刷新token的时间
      // refreshTime: ''
    }
  },
  created() {
    //实时检测刷新token
    // this.refreshToken()
  },
  mounted() {},
  computed: {
    ...mapGetters([ 'isCollapse','menu'])
    },
  props: [],
  methods: {
    // 实时检测刷新token
    // refreshToken() {
    //   this.refreshTime = setInterval(() => {
    //     const token = getStore({
    //       name: 'token',
    //       debug: true
    //     })
    //     const date = calcDate(token.datetime, new Date().getTime())
    //     if (validatenull(date)) return
    //     if (!(date.seconds >= this.website.tokenTime) && !this.refreshLock) {
    //       this.refreshLock = true
    //       this.$store
    //         .dispatch('RefeshToken')
    //         .then((res) => {
    //           clearInterval(this.refreshTime)
    //         })
    //         .catch((err) => {
    //           this.refreshLock = false
    //         })
    //     }
    //   }, 3000)
    // }
  }
}
</script>

<style lang="scss" scoped>
.avue-container {
  height: 100%;
}
.avue-sidebar {
  height: 100%;
}
.avue-tabs {
  padding: 0;
}
.avue-main {
  position: relative;
  padding: 0;
}
.avue-view {
  width: 100%;
  position: absolute;
  top: 0;
  left: 0;
}
.avue-container, .avue-sidebar, .avue-tabs, .avue-main, .avue-top, .avue-logo {
    -webkit-transition: all .3s;
    transition: all .3s;
}
.el-aside{
    -webkit-transition: all .3s;
    transition: all .3s;
}

</style>
