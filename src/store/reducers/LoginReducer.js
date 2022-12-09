import types from "../types";

const initValue = {
    count:0,
    isLogin:false,
}

const LoginReducer=(state=initValue, action)=>{
    let {type}= action

    switch (type){
        case types.LOGIN:
            return {
                count:state.count + 1,
                isLogin:action.isLogin
            }
        default:
            return state
    }
}

export default LoginReducer