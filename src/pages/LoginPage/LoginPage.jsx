import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Button, Form, Input,message} from 'antd';
import { LoginAction } from '../../store/actions/LoginAction';
import { useDispatch } from 'react-redux';
import { getData } from '../../http/getData'
import './index.css';

function LoginPage() {

    const dispatch = useDispatch()
    const navigate = useNavigate()


    const error = () => {
       message.error('The account number or password is incorrect')
    };

    function login() {
        dispatch(LoginAction('login'))
    }

    const onFinish = async (values) => {
        // console.log('Success:', values);
        // login();
        // navigate('/home')
        let p = {
            account:values.account,
            password:values.password
        }
        let res = (await getData('/login/userLogin', p)).data
        if(res.status === 'APPROVED'){
            console.log('res',res)
            sessionStorage.setItem('userInfo',JSON.stringify(res))
            login()
            navigate('/home')
        }
        else if(res.status === 'NOT_FOUND'){
            error()
        }
    };

    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
        <>
            <div className='bgcbox'>
                <div className='loginbox'>
                    <img alt='1111' src="https://gw.alipayobjects.com/zos/bmw-prod/bd71b0c6-f93a-4e52-9c8a-f01a9b8fe22b.svg" className='formImg1' />
                    <div className='formbox'>
                        <Form name="basic"
                            labelCol={{
                                span: 8,
                            }}
                            wrapperCol={{
                                span: 16,
                            }}
                            initialValues={{
                                remember: true,
                            }}
                            onFinish={onFinish}
                            onFinishFailed={onFinishFailed}
                            autoComplete="off"
                            size='large'
                            style={{ width: '100%' }}
                        >
                            <Form.Item label="Account" name="account"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your account!',
                                    },
                                ]}
                            >
                                <Input />
                            </Form.Item>

                            <Form.Item label="Password" name="password"
                                rules={[
                                    {
                                        required: true,
                                        message: 'Please input your password!',
                                    },
                                ]}
                            >
                                <Input.Password />
                            </Form.Item>

                            <Form.Item
                                wrapperCol={{
                                    offset: 8,
                                    span: 16,
                                }}
                            >
                                <Button type="primary" htmlType="submit">
                                    Submit
                                </Button>
                            </Form.Item>
                        </Form>
                    </div>
                    <img alt='2222' src="https://gw.alipayobjects.com/zos/bmw-prod/84ad805a-74cb-4916-b7ba-9cdc2bdec23a.svg" className='formImg2' />
                </div>
            </div>
        </>
    )
}

export default LoginPage