<template>
  <div class="top">
    <!-- 左侧导航栏按钮 -->
    <div class="top-button is-left">
      <div class="tags-breadcrumb">
        <i class="icon-navicon tag-collapse icon-font"
           :class="[{ 'tag-collapse_right': isCollapse }]"
           @click="showCollapse"></i>
      </div>
    </div>
    <topUser ></topUser>
  </div>
</template>
<script>
import { mapGetters } from 'vuex'
// import { fullscreenToggel, listenfullscreen } from '@/util/util'
// import topLock from './top-lock'
// import topMenu from './top-menu'
// import topBreadcrumb from './top-breadcrumb'
// import topColor from './top-color'
// import topTheme from './top-theme'
// import * as commonApi from '../../../api/common.js'
// import * as userApi from '../../../api/user.js'
import topUser from './top-user'

export default {
  components: { 
    topUser
    // topLock, 
    // topMenu,
    // topBreadcrumb, 
    // topColor, 
    // topTheme 
    },
  name: 'top',
  data() {
    return {
      urlSmall: '/static/image/logo-small.png',
      dialogVisible: false,
      form: {
        oldPassword: '',
        newPassword: '',
        confirmPassword: '',
      },
    }
  },
  filters: {},
  created() {},
  mounted() {
    // listenfullscreen(this.setScreen)
    // this.getUserInfo()
  },
  computed: {
    ...mapGetters([ 'isCollapse']),
  },
  methods: {
    // async getUserInfo() {
    //   const response = await commonApi.getUserInfo()
    //   if (response.success) {
    //     this.$store.commit('SET_USERIFNO', response.data)
    //   }
    // },
    // handleScreen() {
    //   fullscreenToggel()
    // },
    showCollapse() {
      this.$store.commit('SET_COLLAPSE')
    },
    // setScreen() {
    //   this.$store.commit('SET_FULLSCREN')
    // },
    // logout() {
    //   this.$confirm('是否退出系统, 是否继续?', '提示', {
    //     confirmButtonText: '确定',
    //     cancelButtonText: '取消',
    //     type: 'warning',
    //   }).then(() => {
    //     this.$store.dispatch('LogOut').then(() => {
    //       this.$router.push({ path: '/login' })
    //     })
    //   })
    // },
    // async handleEditPassword() {
    //   if (
    //     !this.form.newPassword ||
    //     !this.form.oldPassword ||
    //     this.form.newPassword !== this.form.confirmPassword
    //   ) {
    //     this.$message({
    //       message: '请输入提示的信息',
    //       type: 'warning',
    //     })
    //     return
    //   }
    //   delete this.form.confirmPassword
    //   const response = await userApi.requestEditPassword(this.form)
    //   if (response.success) {
    //     this.dialogVisible = false
    //   } else {
    //     this.$message({
    //       type: 'error',
    //       message: '修改密码失败',
    //     })
    //   }
    // },
  },
}
</script>

<style lang="scss" scoped>
</style>

