<template>
  <div class="sidebar-container">
    <logo :isCollapse="isCollapse" class="avue-logo"></logo>
    <!-- 导航栏标签 -->
    <el-scrollbar style="height:100%">
    <el-menu unique-opened
             :default-active="nowTagValue"
             mode="vertical"
             :show-timeout="200"
             background-color="rgb(32,34,42)"
             text-color="hsla(0,0%,100%,.65)"
             active-text-color="#409eff"
             :collapse="isCollapse"
             class="el-menu-vertical">
      <!-- 导航栏内容 -->
      <sidebar-item :menu="menu"
                    :isCollapse="isCollapse"></sidebar-item>
                    
    </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
// import MENU from '@/mock/menu'
// import { setUrlPath } from '@/util/util'
import { mapGetters } from 'vuex'
import SidebarItem from './sidebarItem'
import logo from './logo'
export default {
  name: 'sidebar',
  components: { 
    SidebarItem,
    logo 
    },
  data () {
    return {
      nowTagValue:''
    }
  },
  created () {
    // this.$store.dispatch('GetMenu').then(data => { })
  },
  computed: {
    ...mapGetters(['menu','isCollapse']),

    // nowTagValue: function () {
    //   return setUrlPath(this.$route)
    // }
  },
  mounted () { },
  methods: {}
}
</script>
<style lang="scss" scoped>
  .el-menu-vertical:not(.el-menu--collapse) {
    width: 230px;
    // min-height: 400px;
  }
</style>

