import { useEffect, useState } from "react";
import axios from 'axios'
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';
import { useSelector } from "react-redux";

export default function Info( props ){

    // (*****************************) 리덕스 ( 전역변수 ) 사용하기. (*****************************)
    // (1) (전역상태)에서 로그인된 회원정보 불러오기, user 라는 이름의 리듀서 정보를 가져오기
    const loginInfo = useSelector( ( state ) => state.user.userInfo  );

  return (
    <div>
      <h2>마이 페이지</h2>
        <div> 아이디 : { loginInfo.mid } </div>
        <div> 닉네임 : { loginInfo.mname } </div>
        <div> 프로필 : <img src={ 'http://localhost:8080/upload/'+ ( loginInfo.mimg == null ? 'default.png' : loginInfo.mimg ) } /> </div>
    </div>
  )

}