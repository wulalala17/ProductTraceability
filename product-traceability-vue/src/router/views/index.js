//前端布局菜单框架
import Layout from '@/page/index/'
export default[
    {
        path: '/home',
        component:Layout,
        redirect: '/home/index',
        children:[{
            path:'index',
            component:()=> import("@/views/home"),
        }]
    },
    {
        path: '/guide',
        component:Layout,
        redirect: '/guide/index',
        children:[{
            path:'index',
            component:()=> import("@/views/home"),
        }]
    }
]