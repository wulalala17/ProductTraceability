export default[
    {
        path: '/login',
        name: '登录页',
        component:()=> import("@/page/login/index")
    },
    {
        path: '/',
        name: '主页',
        redirect:'/login'
    },
    //添加token验证跳转login界面后需使用此路由
    // {
    //     path: '/',
    //     name: '主页',
    //     redirect:'/home'
    // }
]