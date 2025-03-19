import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom'

import { useDispatch, useSelector } from 'react-redux'
import { logout } from '../reduxs/userSlice';

export default function Header( props ){

    // (*****************************) 리덕스 ( 전역변수 ) 사용하기. (*****************************) 
    // (1) (전역상태)에서 로그인된 회원정보 불러오기, user 라는 이름의 리듀서 정보를 가져오기
    const loginInfo = useSelector( ( state ) => state.user.userInfo  );
    // (2) 로그아웃 하기 위한 useDispatch
    const dispatch = useDispatch()
    
    // (4) axios 이용하여 로그아웃 요청과 응답받기.
    const navigate = useNavigate();
    const onLogout = async ( ) => {
        const response = axios.get('http://localhost:8080/api/member/logout' , { withCredentials : true }  )
        alert('로그아웃 했습니다.');
        navigate('/');
        dispatch( logout() )
    } // f end 

    // 로그인/로그아웃 했을때 재렌더링 필요하다. :
    return (<> 
        <div>
            <ul>
                <li>
                    { 
                        loginInfo ? 
                            (<>
                                <div>  { loginInfo.mid } 님 안녕하세요. 
                                    <button onClick={ onLogout }> 로그아웃 </button>  
                                </div>
                            </>) 
                            : 
                            (<><div> 비로그인중 </div></>)
                    }
                </li>
                <li> <Link to="/"> 홈으로 </Link> </li>
                <li> <Link to="/member/signup"> 회원가입 </Link> </li>
                <li> <Link to="/member/login"> 로그인 </Link> </li>
            </ul>
        </div>
    </>)
}

    /*
        
    // (1) 로그인 상태를 저장하는 state 변수  , 객체를 저장할 예정이라 빈객체{} 를 초기값으로 선언 
    const [ login , setLogin ] = useState( {} );
    // (2) axios 이용하여 서버에게 로그인 상태 요청하고 응답받기.
    const onLoginInfo = async()=>{
        // 1. axios 이용하여 서버 요청후 응답 받기 
        const response = await axios.get('http://localhost:8080/api/member/info' ,  { withCredentials : true }  )
        // 2. 응답의 본문(결과) 반환 
        const result = response.data; console.log( response.data );
        // 3. 응답결과를 state 변수에 저장 
        setLogin( result );
    } // f end 
    // (3) useEffect 이용하여 'onLoginInfo' 함수 실행 , useEffect( ()=>{} , [] ) : 컴포넌트가 최초 렌더링 될때 1번 실행될때
    useEffect( ()=>{ onLoginInfo() } , [] )
    */
