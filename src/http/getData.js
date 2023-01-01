import axios from "axios"
import qs from 'qs'

const getData = async (url, params) => {
    let res
    try {
        res = await axios.post(url, {}, {
            params
        })
    } catch (error) {
        console.log(error)
        res = error
    }
    return res
}



const postData = async (url, params) => {
    let res
    try {
        res = await axios.post(url, {}, {
            params,
            // paramsSerializer: params => {
            //     return qs.stringify(params, { indices: false })
            // }
            paramsSerializer: { 
                serialize:function(params) {
                 return qs.stringify(params, { indices: false })
               }
            }
        })
    } catch (error) {
        console.log(error)
        res = error
    }
    return res
}

export { getData ,postData}