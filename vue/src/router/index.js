import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Manage.vue'
import form from "element-ui/packages/form";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: () => import( '../views/Manage.vue'),
        redirect: "/home",
        children: [ //子路由
            {path: 'home',name:"主页",component:() => import("../views/Home.vue")},
            {path: 'user',name:"用户管理",component:() => import("../views/User.vue")},


        ]
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})
router.beforeEach((to,from,next) => {
    localStorage.setItem("currentPathName",to.name)

    next()//放行
})

export default router
