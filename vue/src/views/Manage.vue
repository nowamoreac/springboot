<template>
  <el-container style="min-height: 100vh">

    <el-aside :width="sideWidth + 'px'" style="box-shadow: 2px 0 6px rgb(0 21 41 / 35%);">
<!--引用侧边栏 并传入数值-->
        <Aside :isCollapse= "isCollapse" :logoTestShow="logoTextShow"/>

    </el-aside>
    <!--登陆用户操作-->
    <el-container>
      <el-header style=" border-bottom: 1px solid #ccc; ">
        <Header :collapseBtnClass="collapseBtnClass" @asideCollapse = "collapse"/>
      </el-header>

      <el-main>
<!--        当前页面的子路由会在router-view 里面展示-->
        <router-view />
      </el-main>

    </el-container>
  </el-container>
</template>

<script>

import Aside from "@/components/Aside"; //引入侧边栏组件
import Header from "@/components/Header"; //引入header组件

export default {
  name: 'Home',
  data() {
    return {
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false, // 默认是打开的
      sideWidth: 200,
      logoTextShow: true,
      pathName: String
    }
  },
  components: {//引入组件
   Aside,
    Header
  }
  ,
  methods: {
    collapse() {  // 点击收缩按钮触发
      this.isCollapse = !this.isCollapse
      if (this.isCollapse) {  // 收缩
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else {   // 展开
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true

      }
    }

  }
}
</script>

