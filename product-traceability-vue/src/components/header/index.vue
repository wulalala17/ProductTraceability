<template>
  <div class="clearfix header">
   
  </div>
</template>
<script>
  export default {
    data() {
      return {
        loginState: false,
        current: ['mail'],
      };
    },
    methods:{
      test(){
        alert("aaaa")
      },
      dologin(){
        this.loginState = !this.loginState
        this.$emit('update',this.loginState)
      }
    }
  };
</script>
<style scoped>
.header{
  height: 200px;
  width: 100%;
  background-color: darkgray
}
.loginbtn{
  float: right;
  margin-right: 20px;
  margin-top:-39.5px;
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