import { useEffect } from "react"
import axios from 'axios';

export default function Read( props ){

    // [1] 컴포넌트 최초 실행될때 (딱 1번) 실행하는 생명주기 함수 , useEffect( () => {} , [] )
    useEffect( () => { 
        console.log('여기는 컴포넌트 실행될때 딱 1번만 호출됩니다.')
        onRead(); // 컴포넌트가 열릴때 AXIOS 통신하여 데이터를 가져온다.
    }, [] )

    // [2] axios 이용하여 서버와 통신한다.
    const onRead = async ( ) =>{
        const response = await axios.get('http://localhost:8080/day08/products')
        console.log( response.data );
    }

    return(<> 
        <div> 
            <h3> Read 페이지 </h3> 
        </div>
    </>)
}
