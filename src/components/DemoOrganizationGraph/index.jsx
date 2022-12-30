import React, { useEffect, useState } from 'react';
import { OrganizationGraph } from '@ant-design/graphs';

const DemoOrganizationGraph = (props) => {

   const {configL} = props


    const data = {
        id: 'root',
        value: {
            name: '股东会',
        },
        children: [
            {
                id: 'joel',
                value: {
                    name: 'Joel Alan',
                },
                children: [
                    {
                        id: 'c1',
                        value: {
                            name: 'c1',
                        },
                        children: [
                            {
                                id: 'c1-1',
                                value: {
                                    name: 'c1-1',
                                },
                            },
                            {
                                id: 'c1-2',
                                value: {
                                    name: 'c1-2',
                                },
                                children: [
                                    {
                                        id: 'c1-2-1',
                                        value: {
                                            name: 'c1-2-1',
                                        },
                                    },
                                    {
                                        id: 'c1-2-2',
                                        value: {
                                            name: 'c1-2-2',
                                        },
                                    },
                                ],
                            },
                        ],
                    },
                    {
                        id: 'c2',
                        value: {
                            name: 'c2',
                        },
                    },
                    {
                        id: 'c3',
                        value: {
                            name: 'c3',
                        },
                        children: [
                            {
                                id: 'c3-1',
                                value: {
                                    name: 'c3-1',
                                },
                            },
                            {
                                id: 'c3-2',
                                value: {
                                    name: 'c3-2',
                                },
                                children: [
                                    {
                                        id: 'c3-2-1',
                                        value: {
                                            name: 'c3-2-1',
                                        },
                                    },
                                    {
                                        id: 'c3-2-2',
                                        value: {
                                            name: 'c3-2-2',
                                        },
                                    },
                                    {
                                        id: 'c3-2-3',
                                        value: {
                                            name: 'c3-2-3',
                                        },
                                    },
                                ],
                            },
                            {
                                id: 'c3-3',
                                value: {
                                    name: 'c3-3',
                                },
                            },
                        ],
                    },
                ],
            },
        ],
    };

    const [dataSource, setDataSource] = useState(configL)
    const [isEmpty, setIsEmpty] = useState(true)

    useEffect(() => {
        if (configL == {}) {
            console.log(2222)
            setIsEmpty(true)
        }
        else
            setIsEmpty(false)

        console.log(configL)
        setDataSource({ ...configL })
    }, [configL])




    return isEmpty ? null : <OrganizationGraph data={data} behaviors={['drag-canvas', 'zoom-canvas', 'drag-node']} />;
};

export default DemoOrganizationGraph