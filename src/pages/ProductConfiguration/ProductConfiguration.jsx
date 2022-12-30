import React, { useState } from 'react';
import { DragDropContext, Droppable } from 'react-beautiful-dnd';
import './index.css';
import getInitialData from './get-initial-data';
import Column from './Column';
import { Tabs } from 'antd';
import DemoOrganizationGraph from '../../components/DemoOrganizationGraph';
import DemoFlowAnalysisGraph from '../../components/DemoFlowAnalysisGraph/DemoFlowAnalysisGraph';

function reorderList(list, startIndex, endIndex) {
    const result = Array.from(list);
    const [removed] = result.splice(startIndex, 1);
    result.splice(endIndex, 0, removed);

    return result;
}


function ProductConfiguration() {
    const [state, setState] = useState(() => getInitialData());
    const [serviceProcess, setServiceProcess] = useState([])

    function onDragEnd(result) {

        if (!result.destination) {

            return;
        }

        if (result.type === 'column') {
            // if the list is scrolled it looks like there is some strangeness going on
            // with react-window. It looks to be scrolling back to scroll: 0
            // I should log an issue with the project
            const columnOrder = reorderList(
                state.columnOrder,
                result.source.index,
                result.destination.index,
            );

            setState({
                ...state,
                columnOrder,
            });
            return;
        }

        // reordering in same list
        if (result.source.droppableId === result.destination.droppableId) {
            const column = state.columns[result.source.droppableId];
            const items = reorderList(
                column.items,
                result.source.index,
                result.destination.index,
            );
            // updating column entry
            const newState = {
                ...state,
                columns: {
                    ...state.columns,
                    [column.id]: {
                        ...column,
                        items,
                    },
                },
            };
            // console.log('111', newState)
            let itemL = newState.columns['column-1'].items;
            // let newProcess = []
            // itemL.forEach((item) => {
            //     newProcess.push(item.id)
            // })
            // console.log(newProcess)
            setServiceProcess(itemL)
            setState(newState);
            return;
        }

        // moving between lists
        const sourceColumn = state.columns[result.source.droppableId];
        const destinationColumn = state.columns[result.destination.droppableId];
        const item = sourceColumn.items[result.source.index];

        // 1. remove item from source column
        const newSourceColumn = {
            ...sourceColumn,
            items: [...sourceColumn.items],
        };
        newSourceColumn.items.splice(result.source.index, 1);

        // 2. insert into destination column
        const newDestinationColumn = {
            ...destinationColumn,
            items: [...destinationColumn.items],
        };
        newDestinationColumn.items.splice(result.destination.index, 0, item);

        const newState = {
            ...state,
            columns: {
                ...state.columns,
                [newSourceColumn.id]: newSourceColumn,
                [newDestinationColumn.id]: newDestinationColumn,
            },
        };
        // console.log('2222', newState)
        let itemL = newState.columns['column-1'].items;
        console.log(itemL)
        // let newProcess = []
        // itemL.forEach((item) => {
        //     newProcess.push(item.id)
        // })
        setServiceProcess(itemL)

        setState(newState);
    }


    return (
        <>
            <div style={{ width: '100%', minHeight: '600px' }}>
                <Tabs
                    items={[
                        {
                            label: '产品配置',
                            key: '1',
                            children:
                                <DragDropContext onDragEnd={onDragEnd}>
                                    <div className="dnd-pro">
                                        <Droppable
                                            droppableId="all-droppables"
                                            direction="horizontal"
                                            type="column"
                                        >
                                            {(provided) => (
                                                <div className="columns" {...provided.droppableProps} ref={provided.innerRef}>
                                                    {state.columnOrder.map((columnId, index) => (
                                                        <Column
                                                            key={columnId}
                                                            column={state.columns[columnId]}
                                                            index={index}
                                                        />
                                                    ))}
                                                    {provided.placeholder}
                                                </div>
                                            )}
                                        </Droppable>
                                    </div>
                                </DragDropContext>
                        },
                        {
                            label: '生成流程图',
                            key: '2',
                            children: <DemoFlowAnalysisGraph serviceProccess={serviceProcess}/>
                        },
                        {
                            label: '产品基本信息填写',
                            key: '3',
                            children: <></>
                        }
                    ]}

                />
            </div>
        </>
    )
}

export default ProductConfiguration