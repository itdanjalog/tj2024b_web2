import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'

export default function Header( props ){

    // (1) 로그인 상태를 저장하는 state 변수  , 객체를 저장할 예정이라 빈객체{} 를 초기값으로 선언 
    const [ login , setLogin ] = useState( {} );
    // (2) axios 이용하여 서버에게 로그인 상태 요청하고 응답받기.
    const onLoginInfo = async()=>{
        // 1. axios 이용하여 서버 요청후 응답 받기 
        const response = await axios.get('http://localhost:8080/api/member/info')
        // 2. 응답의 본문(결과) 반환 
        const result = response.data;
        // 3. 응답결과를 state 변수에 저장 
        setLogin( result );
    } // f end 
    // (3) useEffect 이용하여 'onLoginInfo' 함수 실행 , useEffect( ()=>{} , [] ) : 컴포넌트가 최초 렌더링 될때 1번 실행될때
    useEffect( ()=>{ onLoginInfo() } , [] )

    return (<> 
        <div>
            <ul>
                <li>
                    { login ? <div> 로그인중 </div> : <div> 비로그인중 </div>}
                </li>
                <li> <Link to="/"> 홈으로 </Link> </li>
                <li> <Link to="/member/signup"> 회원가입 </Link> </li>
                <li> <Link to="/member/login"> 로그인 </Link> </li>
            </ul>
        </div>
    </>)
}