
import axios from 'axios'
import { useEffect, useState } from 'react';
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';


export default function Header( props ){

    const [ loginInfo , setLoginInfo ] = useState({});

    useEffect( ()=>{
        myInfo();
    },[])

    const myInfo = async () =>{
        const response =  await axios.get('http://localhost:8080/api/member/info' , { withCredentials: true } )
        console.log( response.data );
        setLoginInfo( response.data );
    }
    const navigate = useNavigate();

    const onLogOut =  async()=>{
        const response =  await axios.get('http://localhost:8080/api/member/logout' , { withCredentials: true })
        if( response ){
              console.log("dddd")
              localStorage.removeItem('user');
              location.href="/";

        }else{
             console.log("dddd2")
        }

    }

    return (<><div>

        {loginInfo ? (
            <div>
                <img src={'http://localhost:8080/upload/'+loginInfo.mimg} style={ { 'width' : '50px'  } }/>
                <span>안녕하세요, {loginInfo.mid}님! </span>
                <Link to="/member/info">마이페이지</Link>
                <button type="button" onClick={ onLogOut }>로그아웃</button>
            </div>

        ) : (
            <h2>로그인이 필요합니다. <Link to="/member/signup" >회원가입</Link> <Link to="/member/login">로그인</Link> </h2>
        )}


        </div></>)
}