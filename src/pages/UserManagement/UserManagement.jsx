import { Button, Popconfirm,message } from 'antd';
import React, { useState, useEffect } from 'react'
import EditableTable from '../../components/EditableTable'
import { getData } from '../../http/getData';

function UserManagement() {

    const [dataSource, setdataSource] = useState([])

    const success = () => {
        message.success('修改成功');
    };
    const error = () => {
        message.error('修改失败');
    };

    

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
        console.log(res)
        const newData = dataSource.filter((item) => item.key !== userInfo.key);
        setdataSource(newData);
    }

    const handleDelete = (record) => {
        deleteUser(record)
    };
 
    const columns = [
        // {
        //     title: 'uid',
        //     dataIndex: 'uid',
        //     width:100,
        //     editable: true,
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
            editable: true,
            fixed:'left',
            rules: [
                {
                    required: true,
                    message: `lalala is required.`,
                },
            ]
        },
        {
            title:'password',
            dataIndex:'password',
            width:150,
            editable: true,
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
                <Popconfirm title="Sure to delete?" onConfirm={() => handleDelete(record)}>
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
        if (res.status === 'APPROVED') {
            success()
        }
        else {
            error()
        }
        console.log(res)
    }

    useEffect(() => {
        getUser()
    }, [])


    return (
        <>
            {/* <Button onClick={() => {
                setdataSource([...structuredClone(dataSource), {
                    key: dataSource.length,
                    uid: 3024,
                    account: "default",
                    password: "default",
                    real_name: "default",
                    id_card: "",
                    address: "default",
                    bank_card: "",
                    phone: "default",
                    user_status: "None",
                    balance: 0,
                    label:"二级用户"
                }])
            }}>add data</Button> */}

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