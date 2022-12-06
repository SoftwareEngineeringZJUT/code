import React from 'react'
import { Card } from 'antd'
import './index.css'

function ProductManagement() {

    const renderItem = () => {
        
    }


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