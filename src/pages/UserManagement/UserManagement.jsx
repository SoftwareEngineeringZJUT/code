import { Button } from 'antd';
import React, { useState,useEffect } from 'react'
import EditableTable from '../../components/EditableTable'

function UserManagement() {

    const [dataSource, setdataSource] = useState([])

    const columns = [
        {
            title: 'index',
            dataIndex: 'key',
            width: 100,
            editable: true,
            fixed: 'left',
            rules: [
                {
                    required: true,
                    message: `lalala is required.`,
                },
            ]
        },
        {
            title: 'Team4G',
            dataIndex: 'Team4G',
            editable: true,
            width: 100,
            rules: [
                {
                    required: true,
                    message: `2 is required.`,
                },
            ]
        },
        {
            title: 'Team5G',
            dataIndex: 'Team5G',
            width: 100,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `3 is required.`,
                },
            ]
        },
        {
            title: 'Account',
            dataIndex: 'Account',
            width: 200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `lalala is required.`,
                },
            ]
        },
        {
            title: 'Tribe',
            dataIndex: 'Tribe',
            width: 200,
            editable: true,
            rules: [
                {
                    required: true,
                    message: `2 is required.`,
                },
            ]
        },
        {
            title: 'SG',
            dataIndex: 'SG',
            editable: true,
            width:80,
            rules: [
                {
                    required: true,
                    message: `3 is required.`,
                },
            ]
        },
        {
            title: 'Name',
            dataIndex: 'Name',
            editable: true,
            width:300,
            rules: [
                {
                    required: true,
                    message: `Name is required.`,
                },
            ]
        },
        {
            title: 'Email',
            dataIndex: 'Email',
            editable: true,
            width:300,
            rules: [
                {
                    required: true,
                    message: `Name is required.`,
                },
            ]
        },
        {
            title: 'Role',
            dataIndex: 'Role',
            editable: true,
            width:100,
            rules: [
                {
                    required: true,
                    message: `Role is required.`,
                },
            ]
        },
        {
            title: 'Ratio_W',
            dataIndex: 'Ratio_W',
            editable: true,
            width:100,
            rules: [
                {
                    required: true,
                    message: `Ratio_W is required.`,
                },
            ]
        },
        {
            title: 'Ratio_LTE',
            dataIndex: 'Ratio_LTE',
            editable: true,
            width:100,
            rules: [
                {
                    required: true,
                    message: `Ratio_LTE is required.`,
                },
            ]
        },
        {
            title: 'Ratio_5G',
            dataIndex: 'Ratio_5G',
            editable: true,
            width:100,
            rules: [
                {
                    required: true,
                    message: `Ratio_5G is required.`,
                },
            ]
        },
    ];

    useEffect(() => {
        let data =[]
        for(let i=0;i<10;++i){
            data.push({
                key: i,
                Team4G: 'test',
                Team5G: 'test',
                Account: 'test',
                Tribe: 'test',
                SG: 'test',
                Name: 'test',
                Email: 'test',
                Role: 'test',
                Ratio_W: 'test',
                Ratio_LTE: 'test',
                Ratio_5G: 'test',
            },)
        }
        setdataSource(data)
    }, [])
    

    return (
        <>
        <Button onClick={()=>{
            setdataSource([...structuredClone(dataSource),{
            key: '3',
            name: 'add',
            age: 'add',
            address: 'add',
        }])}}>add data</Button>

            <EditableTable
                autoMove={true}
                dataSource={dataSource}
                title={'test editable table'}
                columns={columns}
                saveDataHttp={(row) => { console.log(row); }}
                pagination={{
                    defaultCurrent:1,
                    defaultPageSize:20,
                    total:200,
                    pageSizeOption:[10,20,50,100]
                }}
            ></EditableTable>
        </>
    )
}

export default UserManagement