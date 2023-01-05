import React, { useEffect, useState } from 'react'
import { Card, Avatar, Statistic, Divider, List, Descriptions } from 'antd'
import { ArrowDownOutlined, ArrowUpOutlined } from '@ant-design/icons';
import moment from 'moment';
import { Pie } from '@ant-design/plots';
import { getData } from '../../http/getData';

const { Meta } = Card
function UserCenter() {
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    const [productList, setProductList] = useState([])
    let isAdmin = false;
    if (userInfo.role === 'admin') isAdmin = true;

    const data = [
        {
            type: '存款',
            value: userInfo.balance
        }
    ]

    const config = {
        appendPadding: 10,
        data,
        angleField: 'value',
        colorField: 'type',
        radius: 0.8,
        label: {
            type: 'outer',
        },
        interactions: [
            {
                type: 'element-active',
            },
        ],
    };

    async function getProfits() {
        let res = (await getData('/statistics/userQueryProfits', {
            uid: userInfo.uid,
            account: userInfo.account
        })).data
        console.log(res)
        setProductList([...res])
    }

    const array = [
        {
            node: <Statistic
                title="持有收益率"
                value={11.28}
                precision={2}
                valueStyle={{
                    color: '#3f8600',
                }}
                prefix={<ArrowUpOutlined />}
                suffix="%"
            />
        },
        {
            node:<Statistic
            title="持有收益率"
            value={9.3}
            precision={2}
            valueStyle={{ color: '#cf1322' }}
            prefix={<ArrowDownOutlined />}
            suffix="%"
          />
        }
    ]


    const renderL = (productList) => {
        return productList.map((item, index) => {
            return (
                <List.Item>

                    <Descriptions title={item.name}
                        extra={array[index%2].node}
                    >
                        <Descriptions.Item label="持有数量">{item.user_hold}</Descriptions.Item>
                        <Descriptions.Item label="到期时间">{moment(item.expire).format('YYYY-MM-DD')}</Descriptions.Item>
                    </Descriptions>



                </List.Item>
            )
        })
    }

    useEffect(() => {
        getProfits()
    }, [])



    return (
        <>
            <div className='personalBox'>
                <Card style={{ width: 300 }}>
                    <Meta
                        avatar={<Avatar src="https://gw.alipayobjects.com/zos/rmsportal/JiqGstEfoWAOHiTxclqi.png" />}
                        title={userInfo.real_name}
                        description={<>
                            {userInfo.phone}
                            <Statistic title="Account Balance (CNY)" value={userInfo.balance} precision={2}></Statistic>
                        </>}
                    >
                    </Meta>
                </Card>

                <Pie {...config} />
            </div>
            <Divider orientation="left">我的产品</Divider>
            <List
                size='large'
                bordered
            // dataSource={productList}

            >

                {
                    renderL(productList)
                }
            </List>
        </>
    )
}

export default UserCenter