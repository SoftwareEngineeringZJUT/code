import types from '../types'

const initValue = false

const setLoadingReducer=(state=initValue,action)=>{
    let {type} = action

    switch(type){
        case types.SET_LOADING:
            return action.isLoading
        default:
            return state
    }
}

export default setLoadingReducer