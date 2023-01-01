import React, { useEffect, useState } from 'react'
import { Form, Input, DatePicker, Button, Space, Tooltip, Select, Typography, Switch } from 'antd'
import { postData } from '../../http/getData';

const { Option } = Select
function ProductForm(props) {
    const {serviceProccess} = props
    const [proccessL, setProccessL] = useState([])
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    const onFinish = (values) => {
        // console.log(values['expire'].format('YYYY-MM-DD HH:mm:ss'))
        console.log(values)
        generateProduct(values)
    }

    async function generateProduct(productInfo){
        let date = productInfo.expire.format('YYYY-MM-DD')
        // console.log('date',date)
        let res = (await postData('/product/addProduct',{
            account:userInfo.account,
            name:encodeURI(productInfo.name),
            publisher:userInfo.id,
            expire:date,
            annual_rate:productInfo.annual_rate,
            start_deposit:productInfo.start_deposit,
            increment:productInfo.increment,
            personal_limit:productInfo.personal_limit,
            daily_limit:productInfo.daily_limit,
            stock:productInfo.stock,
            saled:productInfo.saled,
            settlement_type:productInfo.settlement_type,
            onsale:productInfo.onsale? 1:0,
            location:productInfo.location,
            description:encodeURI(productInfo.description),
            service_process:proccessL,
        })).data

        console.log('res',res)
    }

    useEffect(()=>{
        let newProccessL = [];
        serviceProccess.forEach((item)=>{
            newProccessL.push(item.id)
        })

        setProccessL([...newProccessL])
    },[serviceProccess])


    return (
        <>
            <Form
                name="complex-form"
                onFinish={onFinish}
                labelCol={{
                    span: 8,
                }}
                wrapperCol={{
                    span: 16,
                }}
            >
                {/* <Form.Item label="Username">
                    <Space>
                        <Form.Item
                            name="username"
                            noStyle
                            rules={[
                                {
                                    required: true,
                                    message: 'Username is required',
                                },
                            ]}
                        >
                            <Input
                                style={{
                                    width: 160,
                                }}
                                placeholder="Please input"
                            />
                        </Form.Item>
                        <Tooltip title="Useful information">
                            <Typography.Link href="#API">Need Help?</Typography.Link>
                        </Tooltip>
                    </Space>
                </Form.Item> */}
                <Form.Item label="产品名称" name='name'
                    rules={[
                        {
                            required: true,
                            message: 'name is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                    {/* <Tooltip title="Useful information">
                        <Typography.Link href="#API">Need Help?</Typography.Link>
                    </Tooltip> */}
                </Form.Item>
                <Form.Item label='终止时间' name='expire'
                    rules={[
                        {
                            required: true,
                            message: 'expire is required',
                        },
                    ]}
                >
                    <DatePicker />
                </Form.Item>
                <Form.Item label='年转化利率' name='annual_rate'
                    rules={[
                        {
                            required: true,
                            message: 'annual_rate is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='起存金额' name='start_deposit'
                    rules={[
                        {
                            required: true,
                            message: 'start_deposit is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='递增金额' name='increment'
                    rules={[
                        {
                            required: true,
                            message: 'increment is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='每人限额' name='personal_limit'
                    rules={[
                        {
                            required: true,
                            message: 'personal_limit is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='每日限购' name='daily_limit'
                    rules={[
                        {
                            required: true,
                            message: 'daily_limit is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='产品库存' name='stock'
                    rules={[
                        {
                            required: true,
                            message: 'stock is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='售出数量' name='saled'
                    rules={[
                        {
                            required: true,
                            message: 'saled is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='结息方式' name='settlement_type'
                    rules={[
                        {
                            required: true,
                            message: 'settlement_type is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='风险等级' name='risk'
                    rules={[
                        {
                            required: true,
                            message: 'risk is required',
                        },
                    ]}
                >
                    <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='是否上线' name='onsale'>
                    <Switch />
                </Form.Item>
                <Form.Item label='地域限制' name='location'>
                <Input style={{ width: 200 }} />
                </Form.Item>
                <Form.Item label='商品说明' name='description'>
                    <Input.TextArea showCount maxLength={100} style={{ width: 300 }}/>
                </Form.Item>
                {/* <Form.Item
                    label="BirthDate"
                    style={{
                        marginBottom: 0,
                    }}
                >
                    <Form.Item
                        name="year"
                        rules={[
                            {
                                required: true,
                            },
                        ]}
                        style={{
                            display: 'inline-block',
                            width: 'calc(50% - 8px)',
                        }}
                    >
                        <Input placeholder="Input birth year" />
                    </Form.Item>
                    <Form.Item
                        name="month"
                        rules={[
                            {
                                required: true,
                            },
                        ]}
                        style={{
                            display: 'inline-block',
                            width: 'calc(50% - 8px)',
                            margin: '0 8px',
                        }}
                    >
                        <Input placeholder="Input birth month" />
                    </Form.Item>
                </Form.Item> */}
                <Form.Item label=" " colon={false}>
                    <Button type="primary" htmlType="submit">
                        Submit
                    </Button>
                </Form.Item>
            </Form>
        </>
    )
}

export default ProductForm