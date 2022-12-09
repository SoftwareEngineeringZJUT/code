import axios from "axios"

const getData = async (url,params)=>{
    let res
    try {
        res = await axios.post(url,{},{
            params
        })
    } catch (error) {
        console.log(error)
        res = error
    }
    return res
}

export {getData}