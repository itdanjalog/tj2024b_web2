import { useEffect, useState } from "react"

// [] 컴포넌트 
export default function Example1( props ){

    // useEffect 함수 사용시 : import { useEffect } from "react"
    // useEffect( 이펙트함수정의 , 의존성배열 )

    // (1) 의존성배열이 없을때의 useEffect , 실행시점 : 1.탄생(최초실행) 2.인생(재렌더링)
        // -> 차이점 : 모든 state 변결될때 재실행 된다.
    useEffect( ( )=> { 
        console.log( '이펙트 함수 실행1 ')
    } ); // [] 의존성배열이 없을때!!

    // (2) 의존성배열이 빈배열 일때 useEffect , 실행시점 : 1.탄생(최초실행) 2. X
        // -> 차이점 : 재렌더링이 아닌 컴포넌트가 최초 1번만 실행해야 하는 경우에 사용된다.
    useEffect( () => {
        console.log( '이펙트 함수 실행2 ')
    }, [] ) // []의존성배열이 빈배열 일때.

    // (3) 의존성배열에 state변수가 존재할때 useEffect , 실행시점 : 1.탄생(최초실행) 2.인생(재렌더링)
        // -> 차이점 : 의존성배열에 존재하는 state변수가 변경될때만 재실행이 된다. , 
        //            의존성배열에 존재하지 않는 state변수가 변경될때는 재실행이 안된다.
    const [ count , setCount ] = useState( 0 ); 
    useEffect( () => {
        console.log( '이펙트 함수 실행3 ')
    },[ count ] ) // []의존성배열에 state변수가 존재할때.

    const [ count2 , setCount2 ] = useState( 0 );

    return (<>
        <button onClick={ (e) => { setCount( count+1 ) }  } > 업데이트1   1/3번 useEffect실행  </button>
        <button onClick={ (e) => { setCount2( count2+1 ) }  } > 업데이트2 1번 useEffect실행 </button>
    </>)
}