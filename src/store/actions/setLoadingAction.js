import types from "../types";

export const setLoadingAction = (isLoading)=>{
    return {
        type:types.SET_LOADING,
        isLoading:isLoading,
    }
}