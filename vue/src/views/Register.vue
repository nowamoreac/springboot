<template>
  <div class="login">
    <img src="../assets/bg.jpg" width="100%" height="100%" alt="" />
    <div class="loginPart">
      <h2>用 户 注 册</h2>
      <el-form :model="user" :rules="rules" ref="userForm">
        <div class="inputElement">
          <el-form-item prop="username" >
            <el-input  v-model="user.username" placeholder="请输入账号 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="inputNickname">
            <el-input v-model="user.inputNickname" placeholder="请输入昵称 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="password">
            <el-input show-password  v-model="user.password" placeholder="请输入密码 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="confirmPassword">
            <el-input show-password  v-model="user.confirmPassword" placeholder="请确认密码 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="inputPhone">
            <el-input  v-model="user.inputPhone" placeholder="请输入手机号 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="inputMail">
            <el-input  v-model="user.inputMail" placeholder="请输入邮箱 "></el-input>
          </el-form-item>
        </div>
        <div class="inputElement">
          <el-form-item prop="inputAddress">
            <el-input v-model="user.inputAddress" placeholder="请输入地址 "></el-input>
          </el-form-item>
        </div>
        <el-form-item style="margin: 10px 0; text-align: right">
          <el-button type="primary" size="small"  autocomplete="off" @click="login">注册</el-button>
        </el-form-item>
        <div style="text-align: left;color: white">
          <el-link type="warning" @click="$router.push('/login')">
            已有帐号？点击去登陆！
          </el-link>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import user from "@/views/User";

export default {
  name: "Login",
  data() {
    return {
      user: {},  //登录校验对象
      rules: {
        username: [  //用户名称
          { required: true, message: '账号是必须的',trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        password: [  //密码
           { required: true, message: '密码是必须的', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        confirmPassword: [  //校验密码
          { required: true, message: '请确认密码', trigger: 'blur' },
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        inputMail: [  //邮箱
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        inputAddress: [  //地址
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        inputPhone: [  //手机号
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ],
        inputNickname: [  //昵称
          { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
        ]

      }
    }
  },
  methods: {
    login() {  //合法才会发请求
      this.$refs['userForm'].validate((valid) => {
        if (valid) {  // 表单校验合法
          if(this.user.password !== this.user.confirmPassword){
            this.$message.error("两次输入的密码不一致")
            return false
          }
          this.request.post("/user/register", this.user).then(res => {
            if(res.code === '200') {
              this.$message.success("注册成功")
             // this.$router.push("/login")
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
