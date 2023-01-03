import React, { useEffect, useState } from 'react'
import { getData } from '../../http/getData'
import EditableTable from '../../components/EditableTable'


function UserOrder() {
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    const [dataSource, SetDataSource] = useState([])
    const columns = [
        {
            title: 'id',
            dataIndex: 'id',
            width: 200,
            fixed: 'left',
            editable: false,
            rules: [
                {
                    required: true,
                    message: `id is required.`,
                },
            ]
        },
        {
            title: 'product_id',
            dataIndex: 'product_id',
            width: 200,
            editable: false,
            rules: [
                {
                    required: true,
                    message: `product_id is required.`,
                },
            ]
        },
        {
            title: 'user_id',
            dataIndex: 'user_id',
            width: 200,
            editable: false,
            rules: [
                {
                    required: true,
                    message: `user_id is required.`,
                },
            ]
        },
        {
            title: 'amount',
            dataIndex: 'amount',
            width: 200,
            editable: false,
            rules: [
                {
                    required: true,
                    message: `amount is required.`,
                },
            ]
        },
        {
            title: 'state',
            dataIndex: 'state',
            width: 200,
            editable: false,
            rules: [
                {
                    required: true,
                    message: `state is required.`,
                },
            ]
        },
        {
            title: 'pay_time',
            dataIndex: 'pay_time',
            width: 200,
            editable: false,
            rules: [
                {
                    required: true,
                    message: `pay_time is required.`,
                },
            ]
        }
    ]

    async function QueryOrder() {
        let res = (await getData('/order/UserQueryOrder', {
            uid: userInfo.uid,
            account: userInfo.account,
        })).data
        console.log('order', res)
        SetDataSource(res)
    }

    useEffect(() => {
        QueryOrder()
    }, [])

    return (
        <>
            <EditableTable
                autoMove={true}
                dataSource={dataSource}
                title={'Order Info'}
                columns={columns}
                // saveDataHttp={(row) => { updateUserInfo(row) }}
                pagination={{
                    defaultCurrent: 1,
                    defaultPageSize: 20,
                    // total: 200,
                    // pageSizeOption: [10, 20, 50, 100]
                }}
            ></EditableTable>
        </>
    )
}

export default UserOrder