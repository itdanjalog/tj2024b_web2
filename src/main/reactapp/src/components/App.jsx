// 최초로 열리는 컴포넌트 사용할 예정 

import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import Header from './layouts/Header'
import Footer from './layouts/Footer'
import Signup from './member/Signup'
import Login from './member/Login'

// import 할때 export default 적용된 자료는 { } 생략해도 된다. 여러개 또는 default 아닌 자료에 대해서는 { } 사용한다. 
import { store , persistor } from './reduxs/store'      
import { Provider } from 'react-redux'
import { PersistGate } from 'redux-persist/integration/react' // PersistGate 라이브러리 가져오기 
 
export default function App( props ){
    return (<>
        <Provider store = { store }> { /* 리덕스 스토어 적용 : 현재 Provider 로 감싼 컴포넌트 모두 리덕스 전역상태를 사용할 수 있다.  */ }
            <PersistGate persistor={ persistor } loading={ null } > {/* 퍼시턴스 적용할 컴포넌트 모두 감싼다. */}
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
            </PersistGate>
        </Provider>
    </>)
}