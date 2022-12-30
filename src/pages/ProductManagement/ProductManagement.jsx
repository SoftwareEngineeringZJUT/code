import React, { useEffect, useState } from 'react';
import { Card,Modal } from 'antd';
import { getData } from '../../http/getData';
import './index.css'

function ProductManagement() {

    const [pdList, setPdList] = useState([])
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [modalInfo, setModalInfo] = useState({})
    const showModal = (productInfo) => {
        setModalInfo(productInfo)
        setIsModalOpen(true);
    };
    const handleOk = () => {
        setIsModalOpen(false);
    };
    const handleCancel = () => {
        setIsModalOpen(false);
    };
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

    async function getProducts() {
        let res = (await getData('/product/adminGetProducts', { account: userInfo.account })).data
        console.log(res)
        setPdList(res)
    }

    const renderItem = (productlist) => {
        return productlist.map((item, index) => {
            return <Card className='productCard' hoverable={true} title={item.name} key={index}
                extra={<a onClick={()=>{showModal(item)}}>More</a>}
            >
                <p>description:{item.description}</p>
                <p>annual_rate:{item.annual_rate}</p>
                <p>risk:{item.risk}</p>
                <p>saled:{item.saled}</p>
                {/* <p></p> */}
            </Card>
        })
    }

    

    useEffect(() => {
        getProducts()
    }, [])


    return (
        <div className='PMbox'>
            <Modal title="详细信息" open={isModalOpen} onOk={handleOk} onCancel={handleCancel}>
                <p>product_id: {modalInfo.product_id}</p>
                <p>name: {modalInfo.name}</p>
                <p>description: {modalInfo.description}</p>
                <p>annual_rate: {modalInfo.annual_rate}</p>
                <p>risk: {modalInfo.risk}</p>
                <p>saled: {modalInfo.saled}</p>
                <p>daily_limit: {modalInfo.daily_limit}</p>
                <p>personal_limit: {modalInfo.personal_limit}</p>
                <p>expire: {modalInfo.expire}</p>
                <p>increment: {modalInfo.increment}</p>
                <p>gmt_create: {modalInfo.gmt_create}</p>
                <p>start_deposit: {modalInfo.deposite}</p>
                <p>settlement_type: {modalInfo.settlement_type}</p>
                <p>stock: {modalInfo.stock}</p>
            </Modal>
            {
                renderItem(pdList)
            }
        </div>
    )
}

export default ProductManagement