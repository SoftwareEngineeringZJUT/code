import React from 'react';
import ReactDOM from 'react-dom/client';
import { HashRouter } from 'react-router-dom';
import { Provider } from 'react-redux';
import store from './store'
import './index.css';
import './http/axiosConfig'
import App from './App';


const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
    <HashRouter>
        <Provider store={store}>
            <App />
        </Provider>

    </HashRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))

