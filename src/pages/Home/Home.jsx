import React, { useState } from 'react'
import { Carousel, message } from 'antd';
import './index.css';
import lunbo1 from '../../assets/lunbo1.jpg'
import lunbo2 from '../../assets/lunbo2.jpg'
import lunbo3 from '../../assets/lunbo3.jpg'
import lunbo4 from '../../assets/lunbo4.jpg'
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import store from '../../store';
import { LoginAction } from '../../store/actions/LoginAction';
import { Pie } from '@ant-design/plots';
import DemoLine from '../../components/DemoLine';
import { getData } from '../../http/getData';

function Home() {

    const dispatch = useDispatch()
    const { count } = store.getState().LoginReducer
    const userInfo = JSON.parse(sessionStorage.getItem('userInfo'))
    const [chartData, setChartData] = useState([])

    function login() {
        dispatch(LoginAction('login'))
    }
    const success = (name) => {
        message.success(`welcome ${name}`)
    };

    async function getUserAssetDistribution() {
        let res = (await getData('/statistics/getUserAssetDistribution', {})).data;
        let newChartData = []
        for (let key in res) {
            newChartData.push({
                type: key,
                value: res[key],
            })
        }
        setChartData([...newChartData])
    }

    const config = {
        appendPadding: 10,
        data: chartData,
        angleField: 'value',
        colorField: 'type',
        radius: 0.75,
        label: {
            type: 'spider',
            labelHeight: 28,
            content: '{name}\n{percentage}',
        },
        interactions: [
            {
                type: 'element-selected',
            },
            {
                type: 'element-active',
            },
        ],
    };



    useEffect(() => {
        if (count === 1) {
            console.log(userInfo)
            success(userInfo.real_name)
            login()
        }
        getUserAssetDistribution()
    }, [])



    return (

        <>
            <div style={{ width: '100%' }}>
                <Carousel style={{ marginBottom: '100px' }} autoplay>
                    <div className='lunboBox'>
                        <div className='text'>
                            <div className='textTitle'>
                                <h3>
                                    <span>
                                        精彩生活
                                    </span>
                                    <b></b>
                                </h3>
                            </div>

                            <div className='textContent'>
                                <h3>
                                    眼界决定境界 <br />
                                    换个角度看世界生活更精彩
                                </h3>
                                <p>
                                    专家市场解读、大V理财指南<br />
                                    开启社区频道，精彩内容给你好看
                                </p>
                            </div>


                        </div>
                        <img alt='lunbo1' src={lunbo1} className='lunboBox' />
                    </div>
                    <div className='lunboBox'>
                        <div className='text' style={{ left: '10%', color: '#a29494' }}>
                            <div className='textTitle'>
                                <h3 >
                                    <span style={{ color: '#a29494' }}>
                                        转账升级
                                    </span>
                                    <b></b>
                                </h3>
                            </div>

                            <div className='textContent'>
                                <h3 style={{ color: '#a29494' }}>
                                    尽管生活不简单<br />
                                    但至少学会 把生活简单过
                                </h3>
                                <p>
                                    语音刷脸转账，手续费全免<br />
                                    转账花式玩法，开启智慧生活
                                </p>
                            </div>


                        </div>
                        <img alt='lunbo2' src={lunbo2} className='lunboBox' />
                    </div>
                    <div className='lunboBox'>
                        <div className='text' style={{ left: '50%', }}>
                            <div className='textTitle'>
                                <h3 >
                                    <span>
                                        安全升级
                                    </span>
                                    <b></b>
                                </h3>
                            </div>

                            <div className='textContent'>
                                <h3>
                                    安全感是自己给的<br />
                                    幸福感也是
                                </h3>
                                <p>
                                    人脸识别、指纹识别<br />
                                    更智能、更便捷、更安全
                                </p>
                            </div>


                        </div>
                        <img alt='lunbo3' src={lunbo3} className='lunboBox' />
                    </div>
                    <div className='lunboBox'>
                        <div className='text' style={{ left: '5%', }}>
                            <div className='textTitle'>
                                <h3 >
                                    <span style={{ color: '#fff' }}>
                                        手指银行4.0
                                    </span>
                                    <b style={{ backgroundColor: "rgba(255, 255, 255, 0.3)" }}></b>
                                </h3>
                            </div>

                            <div className='textContent'>
                                <h3 style={{ color: '#fff' }}>
                                    精彩、智能4.0、给您好看<br />
                                    让银行成为一种随时可得的服务
                                </h3>
                                <p style={{ color: '#fff' }}>
                                    三湘银行手指银行APP全新上线
                                </p>
                            </div>


                        </div>
                        <img alt='lunbo4' src={lunbo4} className='lunboBox' />
                    </div>
                </Carousel>
                {/* <DemoChart /> */}
            </div>
            {/* <DemoLine /> */}
            <Pie {...config}/>
        </>
    )
}

export default Home