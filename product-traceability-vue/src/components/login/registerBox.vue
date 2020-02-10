<template>
 <modal name="register-box"
         :width="400"
         :height="560"
         :clickToClose="false">

  <a-card title="用户注册" style="width:400px;height:560px">
      <a-button  size="small" @click="$modal.hide('register-box')" class="closebtn">
        <a-icon type="close" />
      </a-button>
  <a-form :form="form" @submit="handleSubmit"  class="register-form">
    <div>
        <a-radio-group @change="handleChange" v-model="role" buttonStyle="solid" class="choose-user" style="margin-left: 100px;margin-bottom: 10px">
        <a-radio-button value="student">学生</a-radio-button>
        <a-radio-button value="teacher">教师</a-radio-button>
        <a-radio-button value="admin">管理员</a-radio-button>
      </a-radio-group>
    </div>
    <a-form-item v-bind="formItemLayout" :label="username">
      <a-input
        v-decorator="[
          'username',
          {
            rules: [
              {
                required: true,
                message: '请输入账号!',
              },
            ],
          },
        ]"
      />
    </a-form-item>
    <a-form-item v-bind="formItemLayout" label="密码">
      <a-input
        v-decorator="[
          'password',
          {
            rules: [
              {
                required: true,
                message: '请输入密码!',
              },
              {
                validator: validateToNextPassword,
              },
            ],
          },
        ]"
        type="password"
      />
    </a-form-item>
    <a-form-item v-bind="formItemLayout" label="确认密码">
      <a-input
        v-decorator="[
          'confirm',
          {
            rules: [
              {
                required: true,
                message: '请再次输入密码!',
              },
              {
                validator: compareToFirstPassword,
              },
            ],
          },
        ]"
        type="password"
        @blur="handleConfirmBlur"
      />
    </a-form-item>
    <a-form-item v-bind="formItemLayout" label="姓名">
      <a-input
        v-decorator="[
          'name',
          {
            rules: [{ required: true, message: '请输入姓名!', whitespace: true }],
          },
        ]"
      />
    </a-form-item>
    <a-form-item v-bind="formItemLayout" label="电话号码">
      <a-input
        v-decorator="[
          'phone',
          {
            rules: [{ required: true, message: '请输入电话号码!' }],
          },
        ]"
        style="width: 100%"
      >
        <a-select
          slot="addonBefore"
          v-decorator="['prefix', { initialValue: '86' }]"
          style="width: 70px"
        >
          <a-select-option value="86">
            +86
          </a-select-option>
        </a-select>
      </a-input>
    </a-form-item>
   
    <a-form-item v-bind="tailFormItemLayout">
      <a-checkbox v-decorator="['agreement', { valuePropName: 'checked' }]">
        我已经阅读
        <a href="">
          用户需知
        </a>
      </a-checkbox>
    </a-form-item>
    <a-form-item v-bind="tailFormItemLayout">
      <a-button type="primary" html-type="submit" class="btns">
        注册
      </a-button>
    <a-button type="primary"  class="btns" @click="dologin">
        返回登录
      </a-button>
    </a-form-item>
  </a-form>
  </a-card>
 </modal>
</template>

<script>
export default {
  name: 'registerBox',
  data() {
    return {
      confirmDirty: false,
      role: 'student',
      username:'学号',
      autoCompleteResult: [],
      formItemLayout: {
        labelCol: {
          xs: { span: 24 },
          sm: { span: 8 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
      },
      tailFormItemLayout: {
        wrapperCol: {
          xs: {
            span: 24,
            offset: 0,
          },
          sm: {
            span: 16,
            offset: 8,
          },
        },
      },
    };
  },
  beforeCreate() {
    this.form = this.$form.createForm(this, { name: 'register' });
  },
  methods: {
    handleSubmit(e) {

      e.preventDefault();
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          console.log(values);
          this.$http({
            method:'post',
            url:"user/reg",
            data: this.$qs.stringify({
                username: values.username,
                password: values.password,
                name: values.name,
                phone: values.prefix+values.phone,
                role: this.role
              })
          })
        }
      });
    },
    handleConfirmBlur(e) {
      const value = e.target.value;
      this.confirmDirty = this.confirmDirty || !!value;
    },
    compareToFirstPassword(rule, value, callback) {
      const form = this.form;
      if (value && value !== form.getFieldValue('password')) {
        callback('Two passwords that you enter is inconsistent!');
      } else {
        callback();
      }
    },
    validateToNextPassword(rule, value, callback) {
      const form = this.form;
      if (value && this.confirmDirty) {
        form.validateFields(['confirm'], { force: true });
      }
      callback();
    },
    handleWebsiteChange(value) {
      let autoCompleteResult;
      if (!value) {
        autoCompleteResult = [];
      } else {
        autoCompleteResult = ['.com', '.org', '.net'].map(domain => `${value}${domain}`);
      }
      this.autoCompleteResult = autoCompleteResult;
    },
    handleChange(){
      switch(this.role){
        case "student":
          this.username = "学号";
          break;
        case "teacher":
          this.username = "工号";
          break;
        case "admin":
          this.username = "账号";
          break;
      }
    },
    dologin(){
    this.$emit('showLogin')
    },
  }
};
</script>
<style scoped>
.closebtn{
  position: absolute;
  top: 0;
  right: 0;
  border: 0;
  color: gray;
  
}
.register-form{
    width: 320px;
}
.btns{
    margin-left: 10px;
}
</style>