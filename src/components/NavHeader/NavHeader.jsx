import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Layout, Menu} from 'antd';
import './index.css';
import titleImage from '../../assets/title.png'


const { Header } = Layout;


function NavHeader() {

    const navigate = useNavigate();

    const items = [
        {label:'首页', key:'Home'},
        {label:'产品配置', key:'ProductConfiguration'},
        {label:'产品管理', key:'ProductManagement'},
        {label:'订单管理', key:'OrderManagement'},
        {label:'用户管理', key:'UserManagement'},
        {label:'权限管理', key:'RightsManagement'},
    ]

    const handelClick = ({item, key})=>{
        navigate(`/${key}`);
    }

    return (
        <Header className='header'>
            <div className='headBar'>
                <img src={titleImage} alt='三湘银行' className='titleImage'/>
                <Menu mode="horizontal" items={items} theme='light' onClick={handelClick}></Menu>
            </div>
        </Header>
    )
}

export default NavHeader