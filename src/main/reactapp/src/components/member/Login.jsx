import { useState } from "react";
import axios from 'axios'
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';
axios.defaults.withCredentials = true;

export default function Login(props) {

     const navigate = useNavigate();

  const [memberInfo, setMemberInfo] = useState({
    mid: "",
    mpwd: ""
  });

  // 로그인 제출 처리 함수
  const handleSubmit = async (e) => {
    e.preventDefault();
    // 여기에 로그인 처리 로직을 추가하면 됩니다.
    console.log("로그인 시도:", memberInfo);
    // 예를 들어, API 호출을 통해 서버에 로그인 정보를 전달할 수 있습니다.

      // 예시: axios를 사용하여 회원가입 API 호출
    const response = await axios.post("http://localhost:8080/api/member/login", memberInfo  , { withCredentials: true })
    if( response.data  ){
        console.log("로그인 성공");
        location.href="/"
    }else{
        console.log("로그인 에러");
    }

  };

  return (
    <div>
      <h1>로그인 페이지</h1>
      <form >
        <div>
          <label htmlFor="email">이메일</label>
          <input 
            type="text"
            id="email" 
            value={memberInfo.mid}
            name="mid"
            onChange={(e) => setMemberInfo( { ...memberInfo , [e.target.name] : e.target.value } )}
            placeholder="이메일을 입력하세요" 
            required
          />
        </div>
        <div>
          <label htmlFor="password">비밀번호</label>
          <input 
            type="password" 
            id="password" 
            value={memberInfo.mpwd}
            name="mpwd"
            onChange={(e) => setMemberInfo( { ...memberInfo , [e.target.name] : e.target.value } )}
            placeholder="비밀번호를 입력하세요" 
            required
          />
        </div>
        <button type="button" onClick={handleSubmit}>로그인</button>
      </form>
    </div>
  );
}
