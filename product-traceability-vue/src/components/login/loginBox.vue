<template>
  <el-card class="login-box">
    <div slot="header" class="clearfix">
      <span>请输入用户名及密码</span>
    </div>
    <el-form label-width="80px" :model="loginForm">
      <el-form-item prop="username" label="用户名">
        <el-input  size="mini" style="width:200px" v-model="loginForm.username"></el-input>
      </el-form-item>
      <el-form-item prop="password" label="密码">
        <el-input  size="mini" type="password" style="width:200px" v-model="loginForm.password"></el-input>
      </el-form-item>
      <el-form-item label="账号类型" >
        <el-select size="mini" placeholder="账号类型" v-model="userType">
          <el-option  v-for="usertype in userTypes" :label="usertype.label" :value="usertype.value" :key="usertype.key"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button size="mini" type="primary" style="width:80px" @click="handleSubmit(loginForm)">登&nbsp;&nbsp;录</el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>
<script>

export default {
  data () {
    return {
      userTypes:[
        {
          label:"果蔬公司",
          value:"a",
          key:0
        },{
          label:"经销商",
          value:"b",
          key:1
        },{
          label:"仓储",
          value:"c",
          key:2
        },{
          label:"庄园",
          value:"d",
          key:3
        }],  
        userType:'',
        loginForm:{
          username:'',
          password:''
        }
    }
  },
  methods:{
     handleSubmit(value){
       console.log(value)
     }
  }
}
</script>
<style >
  .login-box{
    width:360px;
    height: 300px; 
  }
  .el-form-item{
    margin-bottom: 5px;
  }
  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
</style>
