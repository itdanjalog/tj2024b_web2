import { useEffect, useState } from "react";
import axios from 'axios'
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';

export default function Info( props ){

  const [ loginInfo , setLoginInfo ] = useState({});

  useEffect( ()=>{
      myInfo();
  },[])

  const myInfo = async () =>{
      const response =  await axios.get('http://localhost:8080/api/member/info' , { withCredentials: true } )
      console.log( response.data );
      setLoginInfo( response.data );
  }


  return (
    <div>
      <h2>마이 페이지</h2>
        <div> 아이디 : { loginInfo.mid } </div>
        <div> 닉네임 : { loginInfo.mname } </div>
        <div> 프로필 : <img src={ 'http://localhost:8080/upload/'+ ( loginInfo.mimg == null ? 'default.png' : loginInfo.mimg ) } /> </div>
    </div>
  )

}