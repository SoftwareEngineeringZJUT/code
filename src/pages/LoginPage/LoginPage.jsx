import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Button, Form, Input } from 'antd';
import { LoginAction} from '../../store/actions/LoginAction';
import { useDispatch } from 'react-redux';
import './index.css';

function LoginPage() {

    const dispatch = useDispatch()
    const navigate = useNavigate()

    function login(){
        dispatch(LoginAction('login'))
    }

    const onFinish = (values) => {
        console.log('Success:', values);
        login();
        navigate('/home')
    };
    const onFinishFailed = (errorInfo) => {
        console.log('Failed:', errorInfo);
    };

    return (
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
                        style={{width:'100%'}}
                    >
                        <Form.Item label="Username" name="username"
                            rules={[
                                {
                                    required: true,
                                    message: 'Please input your username!',
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
                                offset:8,
                                span: 16,
                            }}
                        >
                            <Button type="primary" htmlType="submit">
                                Submit
                            </Button>
                        </Form.Item>
                    </Form>
                </div>
                <img alt='2222' src="https://gw.alipayobjects.com/zos/bmw-prod/84ad805a-74cb-4916-b7ba-9cdc2bdec23a.svg" className='formImg2'/>
            </div>
        </div>
    )
}

export default LoginPage