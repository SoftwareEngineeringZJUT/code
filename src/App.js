import IndexRouter from './router/IndexRouter.jsx'
import 'antd/dist/reset.css';
import './http/axiosConfig'
import './App.css';

function App() {
    return (
        <div style={{width:'100vw'}}>
            <IndexRouter/>
        </div>
    );
}

export default App;
