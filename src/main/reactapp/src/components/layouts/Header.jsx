
import axios from 'axios'
import { BrowserRouter , Routes , Route , Link, useNavigate } from 'react-router-dom';


export default function Header( props ){

    const navigate = useNavigate();

    const onLogOut =  async()=>{
        const response =  await axios.get('http://localhost:8080/api/member/logout')
        if( response ){
                console.log("dddd")
              localStorage.removeItem('user');
              navigate("/");

        }else{
             console.log("dddd2")
        }

    }

    return (<><div>
        
        헤더페이지
        <img src="http://localhost:8080/img/default.png" />
        <ul>
            <li> <Link to="/member/signup" >회원가입</Link> </li>
            <li> <Link to="/member/login">로그인</Link> </li>
            <li> <button type="button" onClick={ onLogOut }>로그아웃</button> </li>
            <li> </li>
        </ul>
        
        </div></>)
}