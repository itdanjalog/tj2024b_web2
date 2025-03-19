import { useState } from "react"
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

export default function Login( props ){

    // (1) 입력받은 값들을 저장하는 state 변수
    const [ memberInfo , setMemberInfo ] = useState({ mid:'' , mpwd : ''} )
    // (2) 입력받은 값들을 수정하는 state 수정 처리 함수
    const onInputChange = ( event ) => { setMemberInfo( { ...memberInfo , [ event.target.name ] : event.target.value } ); } 
    // (3) 입력받은 값들을 axios 이용하여 자바(스프링) 에게 요청과 응답받기
    const navigate = useNavigate(); 
    const onLogin = async () => {
        const response = await axios.post('http://localhost:8080/api/member/login' , memberInfo )
        const result = response.data;
        if( result == true ){ 
            alert('로그인성공'); 
            navigate("/"); // navigate("/") : 새로고침없다 vs location.href="/": 새로고침있다.
         }
        else{ alert('로그인실패'); }
    } // f end 

    return (<> 
        <h3> 로그인페이지 </h3>
        <form>
            아이디 : <input type="text" name="mid" value={ memberInfo.mid } onChange={ onInputChange }/> <br/>
            비밀번호 : <input type="password" name="mpwd" value={ memberInfo.mpwd } onChange={ onInputChange } /> <br/>
            <button type="button" onClick={ onLogin } > 로그인 </button>
        </form>
    </>)
}