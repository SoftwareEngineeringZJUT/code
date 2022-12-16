import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Layout} from 'antd';
import './index.css';
import titleImage from '../../assets/title.png'
import {Menu} from 'antd'


const { Header } = Layout;


function NavHeader() {

    const navigate = useNavigate();

    const items = [
        {label:'首页', key:'Home'},
        {label:'产品配置', key:'ProductConfiguration'},
        {label:'产品管理', key:'ProductManagement'},
        {label:'订单管理', key:'OrderManagement'},
        {label:'用户管理', key:'UserManagement'},
        {label:'个人中心', key:'PersonalCenter'},
    ]

    const handelClick = ({item, key})=>{
        navigate(`/${key}`);
    }

    return (
        <Header className='header'>
            <div className='headBar'>
                <img src={titleImage} alt='三湘银行' className='titleImage'/>
                {/* <Menu mode='horizontal' theme='light'>
                    <Menu.Item key='Home'>首页</Menu.Item>
                    <Menu.Item key='ProductConfiguration'>产品配置</Menu.Item>
                    <Menu.Item key='ProductManagement'>产品管理</Menu.Item>
                    <Menu.Item key='OrderManagement'>订单管理</Menu.Item>
                    <Menu.Item key='UserManagement'>用户管理</Menu.Item>
                    <Menu.Item key='RightsManagement'>权限管理</Menu.Item>
                </Menu> */}
                <Menu mode="horizontal" items={items} theme='light' onClick={handelClick}></Menu>
            </div>
        </Header>
    )
}

export default NavHeader