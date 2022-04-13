<template>
<div style="line-height: 60px; display: flex" >
  <div style="flex: 1; ">
    <span :class="collapseBtnClass" style="cursor: pointer; font-size: 18px" @click="collapse" />
    <el-breadcrumb separator="/" style="display: inline-block; margin-left: 10px">
      <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
      <el-breadcrumb-item>{{ currentPathName }}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
  <el-dropdown style="width: 70px; cursor: pointer">
    <span>田所浩二</span><i class="el-icon-arrow-down" ></i>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item style="font-size: 14px; padding: 5px 0">个人信息</el-dropdown-item>
      <el-dropdown-item style="font-size: 14px; padding: 5px 0">退出</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</div>
</template>

<script>
export default {
  name: "Header",
  props: {
    collapseBtnClass: String,
  },
  methods: {
    collapse() {
      this.$emit("asideCollapse")
    }
  },
  watch: { //监听路由变化
    '$route':function (){
      this.currentPathName = localStorage.getItem("currentPathName")
    }
    },
  data(){
    return{
      currentPathName: ''
    }
  }
  }
</script>

<style scoped>

</style>