import React, { useEffect, useState } from 'react'
import { Card, Modal, Button, InputNumber, Form, message } from 'antd';
import { getData } from '../../http/getData';

function ProductStore() {
    const [pdList, setPdList] = useState([])
    const [isModalOpen, setIsModalOpen] = useState(false);
    const [isBuyOpen, setIsBuyOpen] = useState(false)
    const [isSaleOpen, setIsSaleOpen] = useState(false)
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
        let res = (await getData('/product/userGetProducts', { account: userInfo.account })).data
        console.log(res)
        setPdList(res)
    }

    const OpenBuy = (productInfo) => {
        setModalInfo(productInfo)
        setIsBuyOpen(true)
    }

    const OpenSale = (productInfo) => {
        setModalInfo(productInfo)
        setIsSaleOpen(true)
    }


    const handleOk1 = () => {
        setIsBuyOpen(false);
    };
    const handleCancel1 = () => {
        setIsBuyOpen(false);
    };

    const handleOk2 = () => {
        setIsSaleOpen(false);
    };
    const handleCancel2 = () => {
        setIsSaleOpen(false);
    };



    const renderItem = (productlist) => {
        return productlist.map((item, index) => {
            return <Card className='productCard' hoverable={true} title={item.name} key={index}
                extra={<><Button size='small' onClick={() => { OpenBuy(item) }}>买入</Button>
                    <Button size='small' onClick={() => { OpenSale(item) }} style={{ marginLeft: '10px' }}>卖出</Button>
                </>}
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

    const buysuccess = () => {
        message.success('购买成功');
    };
    const buyerror = () => {
        message.error('购买失败');
    };
    const salesuccess = () => {
        message.success('卖出成功');
    };
    const saleerror = () => {
        message.error('卖出失败');
    };

    async function buyProducts(values) {
        let res = (await getData('/product/purchaseProduct', {
            account: userInfo.account,
            product_id: modalInfo.product_id,
            purchaseVolume: values.purchaseVolume,
        })).data
        if (res.status === 'APPROVED') {
            buysuccess()
        }
        else {
            buyerror()
        }
        console.log(res)
    }

    async function saleProducts(values) {
        let res = (await getData('/product/saleProduct', {
            account: userInfo.account,
            product_id: modalInfo.product_id,
            saleVolume: values.saleVolume,
        })).data
        if (res.status === 'APPROVED') {
            salesuccess()
        }
        else {
            saleerror()
        }
        console.log(res)
    }

    

    const onFinish = (values) => {
        // console.log(values['expire'].format('YYYY-MM-DD HH:mm:ss'))
        console.log(values)
        buyProducts(values)

    }
    const onFinish1 = (values)=>{
        console.log(values)
        saleProducts(values)
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
            <Modal title="买入" open={isBuyOpen} onOk={handleOk1} onCancel={handleCancel1}>
                <Form layout='inline' onFinish={onFinish}>
                    <Form.Item name='purchaseVolume' label='买入数量'>
                        <InputNumber min={1} max={100000} defaultValue={5} />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            确认
                        </Button>
                    </Form.Item>
                </Form>
            </Modal>
            <Modal title="卖出" open={isSaleOpen} onOk={handleOk2} onCancel={handleCancel2}>
                <Form layout='inline' onFinish={onFinish1}>
                    <Form.Item name='saleVolume' label='卖出数量'>
                        <InputNumber min={1} max={100000} defaultValue={5} />
                    </Form.Item>
                    <Form.Item>
                        <Button type="primary" htmlType="submit">
                            确认
                        </Button>
                    </Form.Item>
                </Form>
            </Modal>
            {
                renderItem(pdList)
            }
        </div>
    )
}

export default ProductStore