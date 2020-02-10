const common = {
    state: {
        isCollapse:false,
    },
    mutations: {
        SET_COLLAPSE: (state,action)=>{
            state.isCollapse = !state.isCollapse
        }
    }
}
export default common