import React from 'react'
import { Layout } from 'antd';
import NavHeader from '../components/NavHeader/NavHeader';
import { Routes, Route } from 'react-router-dom';
import Home from '../pages/Home/Home';
import ProductManagement from '../pages/ProductManagement/ProductManagement';
import ProductConfiguration from '../pages/ProductConfiguration/ProductConfiguration';
import UserManagement from '../pages/UserManagement/UserManagement';
import NotFound from '../pages/NotFound/NotFound';
import PersonalCenter from '../pages/PersonalCenter';
import OrderManagement from '../pages/OrderManagement/OrderManagement';
import ProductStore from '../pages/ProductStore/ProductStore';
import UserOrder from '../pages/UserOrder/UserOrder';

const { Content } = Layout;

function PageBox() {
    return (
        <>
            <NavHeader />
            <Content className='content'>
                <div className='contentBox'>
                    <Routes>
                        <Route path='/home' element={<Home />}></Route>
                        <Route path='/ProductManagement' element={<ProductManagement />}></Route>
                        <Route path='/ProductConfiguration' element={<ProductConfiguration />}></Route>
                        <Route path='/UserManagement' element={<UserManagement/>}></Route>
                        <Route path='/PersonalCenter'element={<PersonalCenter/>} ></Route>
                        <Route path='/OrderManagement' element={<OrderManagement/>}></Route>
                        <Route path='/ProductStore' element={<ProductStore/>}></Route>
                        <Route path='/UserOrder' element={<UserOrder/>}></Route>
                        <Route path='/*' element={<NotFound />} />
                    </Routes>
                </div>
            </Content>
        </>
    )
}

export default PageBox