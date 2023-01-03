import React, { useEffect, useState } from 'react';
import { Card, Modal, Switch, message } from 'antd';
import moment from 'moment';
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

    const success = () => {
        message.success('修改成功');
    };
    const error = () => {
        message.error('修改失败');
    };
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

    async function getProducts() {
        let res = (await getData('/product/adminGetProducts', { account: userInfo.account })).data
        console.log(res)
        setPdList(res)
    }

    async function updateProducts(productInfo) {
        let temp = { ...productInfo }
        delete temp.gmt_create
        delete temp.gmt_update
        // delete temp.location
        let date = moment(temp.expire).format('YYYY-MM-DD')
        // console.log(date)
        let res = (await getData('/product/updateProduct', {
            account: userInfo.account,
            ...temp,
            expire: date,
        })).data

        if (res.status === 'APPROVED') {
            success()
        }
        else {
            error()
        }
        console.log(res)
    }

    const onchange = (checked, productInfo) => {
        productInfo.onsale = checked ? 1 : 0;
        updateProducts(productInfo)
    }

    const renderItem = (productlist) => {
        return productlist.map((item, index) => {
            let b = item.onsale == 1 ? true : false
            return <Card className='productCard' hoverable={true} title={item.name} key={index}
                extra={<>上线: <Switch defaultChecked={b} onChange={(checked) => { onchange(checked, item) }} /></>}
            >
                <p>description:{item.description}</p>
                <p>annual_rate:{item.annual_rate}</p>
                <p>risk:{item.risk}</p>
                <p>saled:{item.saled}</p>
                <a onClick={() => { showModal(item) }}>More</a>
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
                <p>start_deposit: {modalInfo.start_deposit}</p>
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