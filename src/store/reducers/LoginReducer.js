import types from "../types";

const initValue = false

const LoginReducer=(state=initValue, action)=>{
    let {type}= action

    switch (type){
        case types.LOGIN:
            return action.isLogin
        default:
            return state
    }
}

export default LoginReducer