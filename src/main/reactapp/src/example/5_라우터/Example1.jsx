
import { BrowserRouter , Routes , Route , Link } from 'react-router-dom';
function Home(){ return(<> 메인페이지 </>) }
function About(){ return(<> 소개페이지 </>) }

// 전체를 연결하는 컴포넌트 = 라우터 컴포넌트 
export default function App( props ){
    return (<>
        <BrowserRouter>
            <ul>
                <a href="/"> 메인페이지(HOME / get 방식 ) </a> 
                <Link to="/"> 메인페이지(HOME / 라우터 방식 ) </Link>
                <Link to="/about"> 소개페이지(About) </Link>
            </ul>

            <Routes>
                <Route path="/"  element = { <Home /> } />       { /* localhost:5137 요청하면 home 컴포넌트가 열린다. */}
                <Route path="/about" element = { <About/> } />   { /* localhost:5137/abuot 요청하면 About 컴포넌트가 열린다. */ }
            </Routes>

        </BrowserRouter>
    </>)
}

