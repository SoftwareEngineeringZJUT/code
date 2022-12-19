import React from 'react'
import { Card, Avatar, Statistic } from 'antd'
import { Pie } from '@ant-design/plots';
import './index.css'

const { Meta } = Card
function PersonalCenter() {

    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

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

    return (
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
    )
}

export default PersonalCenter