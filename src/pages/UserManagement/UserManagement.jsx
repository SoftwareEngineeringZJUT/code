import { Button, Popconfirm } from 'antd';
import React, { useState, useEffect } from 'react'
import EditableTable from '../../components/EditableTable'
import { getData } from '../../http/getData';

function UserManagement() {

    const [dataSource, setdataSource] = useState([])

    async function getUser() {
        let res = (await getData('/userInfo/getUser', {})).data
        console.log(res)
        let newDataSource = res.map((item,index)=>{
            return {
                key:index,
                ...item,
            }
        })
        setdataSource(newDataSource)
    }

    async function deleteUser(userInfo) {
        let res = (await getData('/userInfo/delUser',{
            uid:userInfo.uid,
            account:userInfo.account,
        })).data
    }

    const handleDelete = (key) => {
        const newData = dataSource.filter((item) => item.key !== key);
        setdataSource(newData);
    };
 
    const columns = [
        // {
        //     title: 'index',
        //     dataIndex: 'key',
        //     width: 100,
        //     editable: false,
        //     fixed: 'left',
        //     rules: [
        //         {
        //             required: true,
        //             message: `lalala is required.`,
        //         },
        //     ]
        // },
        // {
        //     title: 'uid',
        //     dataIndex: 'uid',
        //     width:100,
        //     editable: false,
        //     rules: [
        //         {
        //             required: true,
        //             message: `lalala is required.`,
        //         },
        //     ]

        // },
        // {
        //     title:'user_status',
        //     dataIndex:'user_status',
        //     width:150,
        //     editable: true,
        //     rules: [
        //         {
        //             required: true,
        //             message: `user_status is required.`,
        //         },
        //     ]

        // },
        {
            title:'account',
            dataIndex:'account',
            width:150,
            editable: false,
            fixed:'left',
            rules: [
                {
                    required: true,
                    message: `lalala is required.`,
                },
            ]
        },
        {
            title:'address',
            dataIndex:'address',
            width:200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `address is required.`,
                },
            ]
        },
        {
            title:'balance',
            dataIndex:'balance',
            width:200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `balance is required.`,
                },
            ]
        },
        {
            title:'bank_card',
            dataIndex:'bank_card',
            width:200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `bank_card is required.`,
                },
            ]
        },
        // {
        //     title:'gmt_create',
        //     dataIndex:'gmt_create',
        //     width:200,
        //     editable: true,
        //     rules: [
        //         {
        //             required: true,
        //             message: `gmt_create is required.`,
        //         },
        //     ]
        // },
        // {
        //     title:'gmt_update',
        //     dataIndex:'gmt_update',
        //     width:200,
        //     editable: true,
        //     rules: [
        //         {
        //             required: true,
        //             message: `gmt_create is required.`,
        //         },
        //     ]
        // },
        {
            title:'id_card',
            dataIndex:'id_card',
            width:150,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `id_card is required.`,
                },
            ]
        },
        {
            title:'phone',
            dataIndex:'phone',
            width:200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `phone is required.`,
                },
            ]
        },
        {
            title:'real_name',
            dataIndex:'real_name',
            width:150,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `real_name is required.`,
                },
            ]
        },
        {
            title: 'operation',
            dataIndex: 'operation',
            width:200,
            render: (_, record) =>
              dataSource.length >= 1 ? (
                <Popconfirm title="Sure to delete?" onConfirm={() => handleDelete(record.key)}>
                  <a>Delete</a>
                </Popconfirm>
              ) : null,
          },

    ]

    async function updateUserInfo(userInfo){
        let res = (await getData('/userInfo/updateUser',{
            uid:userInfo.uid,
            account:userInfo.account,
            real_name:userInfo.real_name,
            password:userInfo.password,
            id_card:userInfo.id_card,
            address:userInfo.address,
            bank_card:userInfo.bank_card,
            phone:userInfo.phone,
            user_status:userInfo.user_status,
            balance:userInfo.balance,
            label:userInfo.label,
        })).data
        console.log(res)
    }

    useEffect(() => {
        getUser()
    }, [])


    return (
        <>
            <Button onClick={() => {
                setdataSource([...structuredClone(dataSource), {
                    key: dataSource.length,
                    name: 'add',
                    age: 'add',
                    address: 'add',
                }])
            }}>add data</Button>

            <EditableTable
                autoMove={true}
                dataSource={dataSource}
                title={'ALL Users'}
                columns={columns}
                saveDataHttp={(row) => { updateUserInfo(row) }}
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

export default UserManagement