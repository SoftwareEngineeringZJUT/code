import React, { useContext, useEffect, useRef, useState } from 'react';
import { Form, Input, Table } from 'antd';
import './index.css'

//react上下文，用于传递数据
const EditableContext = React.createContext(null);
const EditState = React.createContext(null);

//可编辑表格的某一行
const EditableRow = ({ index, ...props }) => {
    //form实例，用于使用表单的方法
    const [form] = Form.useForm();
    return (
        <Form form={form} component={false}>
            <EditableContext.Provider value={form}>
                <tr {...props} />
            </EditableContext.Provider>
        </Form>
    );
};

//可编辑单元格
const EditableCell = ({
    title,
    editable,
    children,
    dataIndex,
    record,
    handleSave,
    rules,
    ...restProps
}) => {
    //单元格编辑状态
    const [editing, setEditing] = useState(false);
    //输入框ref
    const inputRef = useRef(null);
    //form实例
    const form = useContext(EditableContext);
    //改变编辑状态的函数
    const setisEditing = useContext(EditState);

    //挂载时若处于编辑状态则聚焦
    useEffect(() => {
        if (editing) {
            inputRef.current.focus();
        }
    }, [editing]);

    //切换编辑状态
    const toggleEdit = () => {
        setEditing(!editing);
        setisEditing(!editing)
        form.setFieldsValue({
            [dataIndex]: record[dataIndex],
        });
    };

    //保存修改
    const save = async () => {
        try {
            //表单验证
            const values = await form.validateFields();
            toggleEdit();
            handleSave({
                ...record,
                ...values,
            });
        } catch (errInfo) {
            console.log('Save failed:', errInfo);
        }
    };
    let childNode = children;
    if (editable) {
        //如果单元格可编辑且正在编辑，则通过input框渲染，否则就渲染children，即未编辑状态的Node
        childNode = editing ? (
            <Form.Item
                style={{
                    margin: 0,
                }}
                name={dataIndex}
                rules={rules}
            >
                <Input ref={inputRef} onPressEnter={save} onBlur={save} />
            </Form.Item>
        ) : (
            <div
                className="editable-cell-value-wrap"
                style={{
                    paddingRight: 24,
                }}
                onClick={toggleEdit}
            >
                {children}
            </div>
        );
    }
    return <td {...restProps}>{childNode}</td>;
};

//鼠标hover可移动的表格
function MoveTable(props) {
    const tableContainer = useRef(null)
    const {
        pagination,
        isEditing,
        autoMove,
        columns,
        dataSource,
        components,
    } = props

    //表格移动距离
    const [toLeft, settoLeft] = useState(0)
    const [maxToLeft, setmaxToLeft] = useState(0)

    // 左移， 添加定时器
    let l1;
    const leftShift = () => {
        l1 = setInterval(() => {
            let parentDom = document.getElementById('table')
            let childDom = parentDom.getElementsByClassName('ant-table-content')
            let temptoLeft = childDom[0].scrollLeft
            if (childDom[0].scrollLeft > 0) {
                childDom[0].scrollLeft = temptoLeft - 1;
            }
        }, 10)
    }

    // 右移，添加定时器
    let l2;
    const rightShift = () => {
        l2 = setInterval(() => {
            // console.log(maxToLeft);
            let parentDom = document.getElementById('table')
            let childDom = parentDom.getElementsByClassName('ant-table-content')
            let temptoLeft = childDom[0].scrollLeft
            if (childDom[0].scrollLeft < maxToLeft) {
                childDom[0].scrollLeft = temptoLeft + 1;
            }
        }, 10)
    }

    // 清除定时器
    const clear1 = () => {
        let parentDom = document.getElementById('table')
        let childDom = parentDom.getElementsByClassName('ant-table-content')
        settoLeft(childDom[0].scrollLeft)
        l1 && clearInterval(l1)
    }

    // 清除定时器
    const clear2 = () => {
        let parentDom = document.getElementById('table')
        let childDom = parentDom.getElementsByClassName('ant-table-content')
        settoLeft(childDom[0].scrollLeft)
        l2 && clearInterval(l2)
    }

    //表头高度
    const [theadHeight, settheadHeight] = useState(55)

    //默认列宽
    const defaultColumnWidth = 100

    //左侧固定列宽度
    let leftFixLen = 0
    columns.forEach(element => {
        if (element.fixed === 'left' || element.fixed === true) {
            if (element.width) {
                leftFixLen += element.width
            }
            else {
                leftFixLen += defaultColumnWidth
            }
        }
    });

    //右侧固定列宽度
    let rightFixLen = 0
    columns.forEach(element => {
        if (element.fixed === 'right') {
            if (element.width) {
                rightFixLen += element.width
            }
            else {
                rightFixLen += defaultColumnWidth
            }
        }
    });

    //表格总长度
    let tableWidth = 0
    const calcWidth = (element) => {
        if (element.children) {
            element.children.forEach(item => {
                calcWidth(item)
            })
        }
        else {
            if (element.width) {
                tableWidth += element.width
            }
            else {
                tableWidth += defaultColumnWidth
            }
        }
    }
    
    columns.forEach((item) => {
        calcWidth(item)
    });

    let containerWidth = 0
    //是否需要滚动（表格总长度小于外面盒子长度时为false）
    const [isNeedMove, setisNeedMove] = useState(true)

    useEffect(() => {
        let parentDom = document.getElementById('table')
        let childDom = parentDom.getElementsByClassName('ant-table-content')
        let tempMaxToLeft = childDom[0].scrollWidth - childDom[0].clientWidth
        setmaxToLeft(tempMaxToLeft)

        childDom[0].onscroll=function (){
            if(childDom[0].scrollLeft===0){
                clear1()
            }
            else if (childDom[0].scrollLeft===tempMaxToLeft){
                clear2()
            }
        }
        

        let leftbox = document.querySelector('.left-shift-box')
        let rightbox = document.querySelector('.right-shift-box')
        if (leftbox) {
            leftbox.onmouseover = leftShift;
            leftbox.onmouseout = clear1;
        }
        if (rightbox) {
            rightbox.onmouseover = rightShift;
            rightbox.onmouseout = clear2;
        }
        // console.log(rightbox);

        //获取表头高度
        let thead = document.querySelector('#table thead')
        settheadHeight(thead.offsetHeight)

        //如果用户需要自动滚动功能
        if (!(autoMove === false)) {
            //获取是否需要能够滚动
            containerWidth = tableContainer.current?.clientWidth
            setisNeedMove(tableWidth < containerWidth ? false : true)
        }
        else {
            setisNeedMove(false)
        }

    }, [isEditing, toLeft, maxToLeft])

    return (
        <div className='tablebox' ref={tableContainer}>
            <Table id='table'
                components={components}
                columns={columns}
                dataSource={dataSource}
                pagination={pagination}
                scroll={{ x: tableWidth }}

                bordered></Table>
            {
                isNeedMove && toLeft > 0 && <div className='left-shift-box' style={{ 
                    height: `calc(100% - ${theadHeight + 20 + (pagination ? 62 : 0)}px)`, 
                    left: `${leftFixLen}px`, 
                    top:`${theadHeight}px`,
                    display: isEditing ? 'none' : 'block' 
                }}></div>
            }

            {
                isNeedMove && toLeft < maxToLeft && <div className='right-shift-box' style={{ 
                    height: `calc(100% - ${theadHeight + 20 + (pagination ? 62 : 0)}px)`, 
                    right: `${rightFixLen}px`,
                    top:`${theadHeight}px`, 
                    display: isEditing ? 'none' : 'block' }}></div>
            }
        </div>
    )
}

//可编辑表格
const EditableTable = (props) => {
    const {
        pagination,
        autoMove,
        title,
        columns,
        dataSource: columnsData,
        saveDataHttp,
    } = props

    const [dataSource, setDataSource] = useState(columnsData);
    const defaultColumns = [...columns]

    useEffect(() => {
        setDataSource([...columnsData])
    }, [columnsData])

    //保存
    const handleSave = (row) => {
        //修改页面
        const newData = [...dataSource];
        const index = newData.findIndex((item) => row.key === item.key);
        const item = newData[index];
        newData.splice(index, 1, {
            ...item,
            ...row,
        });
        setDataSource(newData);

        //http请求，该函数需要使用组件时传入
        saveDataHttp && saveDataHttp(row)
    };

    //覆盖默认的table元素
    const components = {
        body: {
            row: EditableRow,
            cell: EditableCell,
        },
    };

    //融合可编辑单元格，使表格列中editable=true的列可编辑
    const mergeColumns = defaultColumns.map((col) => {
        if (!col.editable) {
            return col;
        }
        return {
            ...col,
            onCell: (record) => ({
                record,
                editable: col.editable,
                dataIndex: col.dataIndex,
                title: col.title,
                rules: col.rules,
                handleSave,
            }),
        };
    });

    //是否处于编辑状态
    const [isEditing, setisEditing] = useState(false)

    return (
        <EditState.Provider value={setisEditing}>
            <h2 style={{ textAlign: 'center' }}>{title}</h2>
            <MoveTable
                isEditing={isEditing}
                autoMove={autoMove}
                components={components}
                dataSource={dataSource}
                columns={mergeColumns}
                pagination={pagination}
            />
        </EditState.Provider>
    );
};
export default EditableTable;