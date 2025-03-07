
import { BrowserRouter , Routes , Route , Link } from 'react-router-dom';
function Home( props ){ return(<> 메인페이지 </>) }
function About( props ){ return(<> 소개페이지 </>) }

import { useSearchParams , useParams } from 'react-router-dom';

function MyPage( props ){ 
    // 기존 queryString 방식
        //const name = new URL( location.href ).searchParams.get('name');
        //const age  = new URL( location.href ).searchParams.get('age');
    // 리액트 queryString 방식 
    // 1. import { useSearchParams } from 'react-router-dom';
    // 2. const [ searchParams ] = useSearchParams();
    // 3. const value = searchParams.get('key');      // locahost:1537?key=value&key=value
    const [ searchParams ] = useSearchParams(); // 쿼리스트링 가져오기.
    const name = searchParams.get('name');
    const age = searchParams.get('age');
    return(<>
        <h3> 마이 페이지 </h3>
        <p> 이름 : { name || '정보 없음' }</p>
        <p> age : { age || '정보 없음' } </p>
    </>)
}
function Product( props ){
    // 리액트 path 방식
    // 1.  import { useParams } from 'react-router-dom';
    // 2.  const { 변수명1 , 변수명2 } = useParams();
             // path 방식 : localhost:5173/product/코카콜라/1500            --> useParams()
             // queryString 방식 : locahost:1537?name=코카콜라&price=1500  --> useSearchParams()
    const { name , price } = useParams();
    return (<>
        <h3> 제품 상세 페이지 </h3>
        <p> 제품명 : { name || '정보 없음' } </p>
        <p> 가격 : { price || '정보 없음 '}</p>
    </>)
}

// 전체를 연결하는 컴포넌트 = 라우터 컴포넌트 
export default function App( props ){
    return (<>
        <BrowserRouter>
            <ul>
                <a href="/"> 메인페이지(HOME / get 방식 ) </a> 
                <Link to="/"> 메인페이지(HOME / 라우터 방식 ) </Link>
                <Link to="/about"> 소개페이지(About) </Link>
                <Link to="/mypage?name=유재석&age=40"> 마이페이지 </Link>
                <Link to="/product/코카콜라/1500" > 제품상세 </Link>
            </ul>
            <Routes>
                <Route path="/"  element = { <Home /> } />       { /* localhost:5137 요청하면 home 컴포넌트가 열린다. */}
                <Route path="/about" element = { <About /> } />   { /* localhost:5137/abuot 요청하면 About 컴포넌트가 열린다. */ }
                <Route path="/mypage" element = { <MyPage /> } ></Route>
                <Route path="/product/:name/:price" element = { <Product /> } ></Route>
            </Routes>
        </BrowserRouter>
    </>)
}

