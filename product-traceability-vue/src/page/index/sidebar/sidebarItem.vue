<template>
  <div class="menu-wrapper">
    <template v-for="(item,index) in menu">
      <!-- 无子菜单 -->
      <el-menu-item v-if="item.children.length===0 " :index="filterPath(item.href,index)" @click="open(item)" :key="item.label">
        <i :class="item.icon" class="icon-font"></i>
        <span slot="title">{{item.label}}</span>
      </el-menu-item>
      <!-- 有子菜单 -->
      <el-submenu v-else :index="filterPath(item.name,index)" :key="item.name">
        <template slot="title">
          <i :class="item.icon" class="icon-font"></i>
          <span slot="title" :class="{'el-menu--display':isCollapse}">{{item.label}}</span>
        </template>
        <template v-for="(child,cindex) in item.children">
          <el-menu-item :class="{'siderbar-active':nowTagValue==child.href}" :index="filterPath(child.href,cindex)" @click="open(child)" v-if="child.children.length==0" :key="cindex">
            <i :class="child.icon" class="icon-font"></i>
            <span slot="title">{{child.label}}</span>
          </el-menu-item>
          <sidebar-item v-else :menu="[child]" :key="cindex" :isCollapse="isCollapse"></sidebar-item>
        </template>
      </el-submenu>
    </template>
  </div>
</template>
<script>
// import { resolveUrlPath, setUrlPath } from '@/util/util'
export default {
  name: 'SidebarItem',
  data() {
    return {}
  },
  props: {
    menu: {
      type: Array
    },
    isCollapse: {
      type: Boolean
    }
  },
  created() {},
  mounted() {},
  computed: {
    nowTagValue: function() {
      // return setUrlPath(this.$route)
    }
  },
  methods: {
    filterPath(path, index) {
      return path == null ? index + '' : path
    },
    open(item) {
      this.$router.push({
        path: resolveUrlPath(item.href, item.label),
        query: item.query
      })
    }
  }
}
</script>
<style lang="scss" scoped>
//刷新激活状态
.siderbar-active {
  i,
  span {
    color: #fff;
  }
}
</style>

