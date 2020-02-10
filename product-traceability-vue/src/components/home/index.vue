<template>
  <el-row class="subMenu" >
  <el-col :span="12">
    <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>导航一</span>
        </template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="1-1">选项1</el-menu-item>
          <el-menu-item index="1-2">选项2</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="分组2">
          <el-menu-item index="1-3">选项3</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="1-4">
          <template slot="title">选项4</template>
          <el-menu-item index="1-4-1">选项1</el-menu-item>
        </el-submenu>
      </el-submenu>
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">导航二</span>
      </el-menu-item>
      <el-menu-item index="3" disabled>
        <i class="el-icon-document"></i>
        <span slot="title">导航三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <span slot="title">导航四</span>
      </el-menu-item>
    </el-menu>
  </el-col>
</el-row>
</template>
<script>
  export default {
    data() {
      return {
          allCourse:[],
          selected:[false,true],
          pagination:{
          defaultPageSize:3,
            }
      };
    },
    computed:{

    },
    watch:{
      
    },
    beforeCreate(){
       this.$http({
            method:'get',
            url:"http://localhost:8100/course/get",
          }).then(res =>{
            var data=new Array()
            data = res.data
            data.forEach(element => {
              element.tags = element.tags.split(",")
            });
            this.allCourse = res.data
          })
    },
    methods: {
      callback(val) {
      },
      click(key){
        this.$set(this.allCourse[key-1],'selected',!this.allCourse[key-1].selected)
      },
      refresh(key){
        alert(this.activeKey)
        switch(key){
          case 1:
            this.$http({
            method:'get',
            url:"http://localhost:8100/course/get",
          }).then(res =>{
            var data=new Array()
            data = res.data
            data.forEach(element => {
              element.tags = element.tags.split(",")
            });
            this.allCourse = res.data
          })
        }
      }
    },
  };
</script>
<style scoped>
.subMenu{
  width: 400px;
  top: 0;
  bottom: 0;
}
</style>
