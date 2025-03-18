// 최초로 열리는 컴포넌트 사용할 예정 

import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import Header from './layouts/Header'
import Footer from './layouts/Footer'
import Signup from './member/Signup'
import Login from './member/Login'
 
export default function App( props ){
    return (<>
        <BrowserRouter> {/* 모든 라우팅 감싼다. */}
            <div id="wrap">

                <Header /> { /* Routes 밖에 있는 컴포넌트들이 고정  */}

                <Routes> { /* Routes 안에 있는 컴포넌트들이 전환 */}
                    <Route path='/' element={ <Home/> }> </Route>
                    <Route path='/member/signup' element={ <Signup/> }> </Route>
                    <Route path='/member/login' element={ <Login/> }> </Route>
                </Routes>

                <Footer /> { /* Routes 밖에 있는 컴포넌트들이 고정  */}

            </div>
        </BrowserRouter>
    </>)
}