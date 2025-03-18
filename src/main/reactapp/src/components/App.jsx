import { BrowserRouter , Route , Routes } from 'react-router-dom'; // 'npm i react-router-dom' 설치 필요

import Home from './Home';
import Header from './layouts/Header';
import Footer from './layouts/Footer';
import Signup from './member/Signup';
import Login from './member/Login';
import Info from './member/Info';

import { Provider } from "react-redux";
import { PersistGate } from "redux-persist/integration/react"; // PersistGate 추가
import { store, persistor } from "./store"; // store와 persistor 가져오기


import ProtectedRoute from "./ProtectedRoute"; // 추가

// App.jsx : 라우터(가상URL)이용한 라이팅
export default function App( props ){ // 컴포넌트
    return (<>
     <Provider store={store}> {/* Redux Store 적용 */}
        <PersistGate loading={null} persistor={persistor}> {/* Persist 적용 */}
            <BrowserRouter> { /* 모든 라우터를 감싼다. */}
                <div id ="wrap">
                    <Header />
                    <Routes> { /* 가상 으로 정의한 URL를 감싼다. */}
                        <Route path="/" element={ <Home /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                        <Route path="/member/signup" element={ <Signup /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                        <Route path="/member/login" element={ <Login /> } /> {/* 각 가상의 URL 정의한다. 컴포넌트 연결 */}
                        {/* 로그인한 사용자만 접근 가능 */}
                        <Route path="/member/info" element={<ProtectedRoute><Info /></ProtectedRoute>} />
                    </Routes>
                    <Footer /> { /* Routes 밖에 있는 컴포넌트들이 고정  */}
                </div>
            </BrowserRouter>
        </PersistGate>
        </Provider>
    </>)
}