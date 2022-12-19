import React, { useEffect } from 'react';
import { Card } from 'antd';
import { getData } from '../../http/getData';
import './index.css'

function ProductManagement() {

    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    
    async function getProducts(){
        let res = (await getData('/product/adminGetProducts', {account: userInfo.account})).data
        console.log(res)
    }

    const renderItem = () => {
        
    }

    useEffect(()=>{
        getProducts()
    },[])


    return (
        <div className='PMbox'>
            {/* <div className='productBox'>

            </div> */}
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
            <Card title="Default size card" extra={<a href="#">More</a>} hoverable={true} className='productCard'>
                <p>Card content</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>
        </div>
    )
}

export default ProductManagement