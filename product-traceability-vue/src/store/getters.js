const getters = {
    // 菜单是否折叠
    isCollapse: state => state.common.isCollapse,
    // 获取菜单
    menu: state => state.user.menu,
    menuAll: state => state.user.menuAll,
}
export default getters