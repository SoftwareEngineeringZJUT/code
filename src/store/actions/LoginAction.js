import types from "../types";

export const LoginAction = (state)=>{
    if(state === 'exit'){
        return {
            type:types.LOGIN,
            isLogin:false,
        }
    }
    else {
        return {
            type:types.LOGIN,
            isLogin:true
        }
    }
}