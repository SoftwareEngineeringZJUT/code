import React from 'react'
import { Routes, Route ,Navigate} from 'react-router-dom'
import {useSelector} from 'react-redux';
import LoginPage from '../pages/LoginPage/LoginPage'
import PageBox from './PageBox'


function IndexRouter() {
    const {isLogin} = useSelector((stet)=>stet.LoginReducer)
    return (
        <Routes>
            <Route path='/login' element={<LoginPage/>}/>
            <Route path='/*' element={
                isLogin? <PageBox/>:<Navigate to="/login"/>
            }/>
            <Route path="/" element={<Navigate to="/home"/>} />
        </Routes>
    )
}

export default IndexRouter