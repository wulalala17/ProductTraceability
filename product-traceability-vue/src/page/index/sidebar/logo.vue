<template>
  <div class="logo">
    <!-- <transition name="fade">
      <span v-if="isCollapse" class="logo_title is-bold " key="0" :class="{'is-text':!type,'is-img':type}">
        <template v-if="type">
          <img :src="website.logo" width="40" height="40" />
        </template>
        <template v-else>
        <el-image
              class="logo-small"
              :src="urlSmall"
              key=""></el-image>
        </template>
      </span>
    </transition>
    <transition-group name="fade">
      <template v-if="!isCollapse">
        <el-image
              class="logo-large"
              style="background-color:white"
              :src="urlLarge"
              key=""></el-image>
      </template>
    </transition-group> -->
    <transition name="fade">
      <template v-if="isCollapse">
        <el-image
              class="logo-small"
              :src="urlSmall"
              key=""></el-image>
      </template>
    </transition>
    <transition name="fade">
      <template v-if="!isCollapse">
        <el-image
              class="logo-large"
              style="background-color:white"
              :src="urlLarge"
              key=""></el-image>
      </template>
    </transition>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "logo",
  data() {
    return {
     urlSmall: '/static/image/logo-small.png',
     urlLarge: '/static/image/logo-large.png'
    };
  },
  props: ["isCollapse"],
  computed: {},
  created() {},
  computed: {
    // ...mapGetters(["website"]),
    // type: function(val) {
    //   return this.website.logo.indexOf("static") != -1;
    // }
  },
  methods: {}
};
</script>

<style scoped="scoped" lang="scss">
.fade-leave-active {
  transition: opacity 0.2s;
}
.fade-enter-active {
  transition: opacity 2.5s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
.logo {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  // width: 220px;
  height: 64px;
  // line-height: 64px;
  // background: #002140;
  color: #fdfdfd;
  text-align: center;
  font-size: 20px;
  font-weight: 600;
  overflow: hidden;
  box-sizing: border-box;
}
.logo_title {
  padding: 0 5px 0 0;
  color: #409eff;
  font-size: 28px;
  &.is-bold {
    font-weight: 700;
  }
}
.is-text {
  position: absolute;
  top: 0;
  left: 20px;
}
.is-img {
  position: absolute;
  top: 10px;
  left: 10px;
}
.logo_subtitle {
  font-size: 16px;
  padding-top: 5px;
}
.logo-small{
  height: 40px;
  width: 40px;
}
</style>