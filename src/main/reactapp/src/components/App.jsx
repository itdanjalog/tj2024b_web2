// 최초로 열리는 컴포넌트 사용할 예정 

import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import Header from './layouts/Header'
import Footer from './layouts/Footer'
import Signup from './member/Signup'
import Login from './member/Login'

import Info from './member/Info'

import { store, persistor } from "./reduxs/store"; // store와 persistor 가져오기
import { Provider } from 'react-redux'
import { PersistGate } from "redux-persist/integration/react"; // PersistGate 추가

import ProtectedRoute from './member/ProtectedRoute'

export default function App( props ){
    return (<>
        <Provider store = { store }> { /* 리덕스 스토어 적용 : 현재 Provider 로 감싼 컴포넌트 모두 리덕스 전역상태를 사용할 수 있다.  */ }
            <PersistGate loading={null} persistor={persistor}> {/* Persist 적용 */}
                <BrowserRouter> {/* 모든 라우팅 감싼다. */}
                    <div id="wrap">
                        <Header /> { /* Routes 밖에 있는 컴포넌트들이 고정  */}
                        <Routes> { /* Routes 안에 있는 컴포넌트들이 전환 */}
                            <Route path='/' element={ <Home/> }> </Route>
                            <Route path='/member/signup' element={ <Signup/> }> </Route>
                            <Route path='/member/login' element={ <Login/> }> </Route>
                            <Route path="/member/info" element={<ProtectedRoute><Info /></ProtectedRoute>} />
                        </Routes>
                        <Footer /> { /* Routes 밖에 있는 컴포넌트들이 고정  */}
                    </div>
                </BrowserRouter>
            </PersistGate>
        </Provider>
    </>)
}