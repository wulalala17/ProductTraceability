<template>
  <div class="top-user">
    <el-tooltip class="item"
                  effect="dark"
                  content="用户头像"
                  placement="bottom">
        <img v-if="urlSmall"
             class="top-userImg"
             :src="urlSmall">
      </el-tooltip>
      <el-dropdown trigger="click">
        <span class="el-dropdown-link" @click="handlleClick">
          用户1
          <i class="el-icon--right" :class="dropDown?'el-icon-arrow-down':'el-icon-arrow-up'"></i>
        </span>
        <el-dropdown-menu slot="dropdown">
          <!-- <el-dropdown-item>
            <router-link to="/">首页</router-link>
          </el-dropdown-item> -->
          <el-dropdown-item>
              修改密码
          </el-dropdown-item>
          <el-dropdown-item @click.native="logout"
                            divided>退出系统</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
  </div>
</template>
<script>

export default {
  name: 'top-user',
  data() {
    return {
      urlSmall: '/static/image/logo-small.png',
      dialogVisible: false,
      dropDown: false
    }
  },
  filters: {},
  created() {},
  mounted() {
    // listenfullscreen(this.setScreen)
    // this.getUserInfo()
  },
  computed: {
  },
  methods: {
    handlleClick(){
      this.dropDown = !this.dropDown
    }
  },
}
</script>

<style lang="scss" scoped>

</style>

