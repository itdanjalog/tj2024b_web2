import { BrowserRouter , Route , Routes } from 'react-router-dom'; // 'npm i react-router-dom' 설치 필요

import Home from './Home';
import Header from './layouts/Header';
import Footer from './layouts/Footer';
import Signup from './member/Signup';
import Login from './member/Login';
import Info from './member/Info';

// App.jsx : 라우터(가상URL)이용한 라이팅
export default function App( props ){ // 컴포넌트 
    return (<>
        <BrowserRouter> { /* 모든 라우터를 감싼다. */}
            <div id ="wrap">
                <Header />
                <Routes> { /* 가상 으로 정의한 URL를 감싼다. */}
                    <Route path="/" element={ <Home /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path="/member/signup" element={ <Signup /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path="/member/login" element={ <Login /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                    <Route path="/member/info" element={ <Info /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                </Routes>
                <Footer />
            </div>
        </BrowserRouter>
    </>)
}