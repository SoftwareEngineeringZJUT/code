import {combineReducers} from 'redux'
import LoginReducer from './LoginReducer'
import setLoadingReducer from './setLoadingReducer'

export default combineReducers({
    LoginReducer,
    setLoadingReducer
})