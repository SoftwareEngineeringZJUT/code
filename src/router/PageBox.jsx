import React from 'react'
import { Layout } from 'antd';
import NavHeader from '../components/NavHeader/NavHeader';
import { Routes, Route } from 'react-router-dom';
import Home from '../pages/Home/Home';
import ProductManagement from '../pages/ProductManagement/ProductManagement';
import ProductConfiguration from '../pages/ProductConfiguration/ProductConfiguration';
import NotFound from '../pages/NotFound/NotFound';

const { Content } = Layout;

function PageBox() {
    return (
        <Layout>
            <NavHeader />
            <Content className='content'>
                <div className='contentBox'>
                    <Routes>
                        <Route path='/home' element={<Home />}></Route>
                        <Route path='/ProductManagement' element={<ProductManagement/>}></Route>
                        <Route path='/ProductConfiguration' element={<ProductConfiguration/>}></Route>
                        <Route path='/*' element={<NotFound/>}/>
                    </Routes>
                </div>
            </Content>
        </Layout>
    )
}

export default PageBox