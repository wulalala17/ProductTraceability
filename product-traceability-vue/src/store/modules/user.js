import menu from '@/const/menu'
const user = {
    state: {
      menu: menu,
      menuAll: [],
    },
    actions: {
      
    },
    mutations: {
      SET_TOKEN: (state, token) => {
        state.token = token
        sessionStorage.setItem('auth-token', token)
        setStore({ name: 'token', content: state.token, type: 'session' })
      },
      SET_USERIFNO: (state, userInfo) => {
        state.userInfo = userInfo
      },
      SET_MENU: (state, menu) => {
        const list = menu.filter((ele) => {
          if (validatenull(ele.meta)) return true
          if (validatenull(ele.meta.roles)) return true
          if (ele.meta.roles.indexOf(state.roles[0]) != -1) {
            return true
          }
          return false
        })
        state.menu = list
      },
      SET_MENU_ALL: (state, menuAll) => {
        state.menuAll = menuAll
      },
      SET_ROLES: (state, roles) => {
        state.roles = roles
      },
      SET_PERMISSION: (state, permission) => {
        state.permission = {}
        permission.forEach((ele) => {
          state.permission[ele] = true
        })
      },
    },
  }
  export default user
  