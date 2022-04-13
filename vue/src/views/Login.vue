<template>
  <div class="login">
    <img src="../assets/bg.jpg" width="100%" height="100%" alt="" />
    <div class="loginPart">
      <h2>用 户 登 录</h2>
      <el-form :model="user" :rules="rules" ref="userForm">
        <div class="inputElement">
          <el-form-item prop="username" >
            <el-input  v-model="user.username" placeholder="请输入账号 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="password">
            <el-input show-password  v-model="user.password" placeholder="请输入密码 "></el-input>
          </el-form-item>
        </div>
        <el-form-item style="margin: 10px 0; text-align: left">
          <el-button type="primary" size="small"  autocomplete="off" @click="login">登录</el-button>
        </el-form-item>
        <div style="text-align: right;color: white">
          <el-link type="warning" @click="$router.push('/register')">
            没有账号？点击去注册！
          </el-link>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      user: {},  //登录校验对象
      rules: {
        username: [
          { required: true, message: '账号是必须的',trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        password: [
           { required: true, message: '密码是必须的', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    login() {  //合法才会发请求
      this.$refs['userForm'].validate((valid) => {
        if (valid) {  // 表单校验合法
          this.request.post("/user/login", this.user).then(res => {
            if(res.code === '200') {
              localStorage.setItem("user",JSON.stringify(res.data)) // 存储用户信息到浏览器
              this.$router.push("/")
              this.$message.success("欢迎回来")
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    }
  }
}
</script>
