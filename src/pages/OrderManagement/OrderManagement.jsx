import React, { useEffect } from 'react'
import { getData } from '../../http/getData'

function OrderManagement() {

    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))

    async function QueryOrder(){
        let res = (await getData('/order/AdminQueryOrder',{
            admin_id:userInfo.admin_id,
            account:userInfo.account,
        })).data
        console.log(res)
    }

    useEffect(()=>{
        QueryOrder()
    },[])

    return (
        <>

        </>
    )
}

export default OrderManagement