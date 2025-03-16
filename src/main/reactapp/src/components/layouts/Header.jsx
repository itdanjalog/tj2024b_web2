
import { Link } from "react-router-dom"

export default function Header( props ){
    return (<><div>
        
        헤더페이지
        <img src="http://localhost:8080/img/default.png" />
        <ul>
            <li> <Link to="/member/signup" >회원가입</Link> </li>
            <li> <Link to="/member/login">로그인</Link> </li>
        </ul>
        
        </div></>)
}