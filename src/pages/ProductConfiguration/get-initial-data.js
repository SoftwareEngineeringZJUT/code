let uniqueId = 0;
function getItems(count) {
    return Array.from({ length: count }, (v, k) => {
        const id = uniqueId++;
        return {
            id: `${id}`,
            text: `item ${id}`,
        };
    });
}

function getInitialConfig() {
    const configL = [
        {
            id: '0',
            text:'用户信息检验'
        },
        {
            id: '1',
            text:'黑名单控制'
        },
        {
            id: '2',
            text:'白名单控制',
        },
        {
            id: '3',
            text:'地域购买控制',
        },
        {
            id: '4',
            text:'标签控制',
        },
        {
            id: '5',
            text:'库存锁定',
        },
        {
            id:'6',
            text:'库存释放',
        },
        {
            id: '7',
            text:'库存更新',
        },
        {
            id: '8',
            text:'证件审查',
        },
        {
            id: '9',
            text:'重复购买',
        },
        {
            id: '10',
            text:'日志录入'
        },
        {
            id: '11',
            text:'利息计算',
        }
    ]
    return configL
}

const initial = {
    columns: {
        'column-0': {
            id: 'column-0',
            title: '待选择',
            // items: getItems(5),
            items: getInitialConfig(),
        },
        'column-1': {
            id: 'column-1',
            title: '已选择',
            items: [],
        },
    },
    columnOrder: ['column-0', 'column-1'],
};

export default function getInitialData() {
    return initial;
}
