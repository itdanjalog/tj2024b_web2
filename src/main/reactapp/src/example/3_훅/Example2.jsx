import { use, useState } from "react";
let a = 0 ;// 전역변수 
export default function Example2( props ){
    // (1) 일반 함수 
    a++; // 전역변수 1증가 
    let b = 0; // 지역변수 
    b++; // 지역변수 1증가 
    console.log( `전역변수 a : ${ a }`);
    console.log( `지역변수 b : ${ b }`);
    // (2) 전역변수/지역변수 증가 하는 함수 
    const 증가함수1 = ( ) => {
        a++; b++;
        console.log( a , b );
    }

    // (3) state 변수 사용 , 훅 종류 중에 핵심함수 , useState , 코드파일 상단에 import { useState } from "react";
    let c = useState( 0 ); // state 상태변수 선언 
    console.log( c ); // [0] : 변수값 , [1] : 변수값수정할수있는함수제공 => 2개를 갖는 배열로 반환 
    console.log( c[0] ) // 0
    console.log( c[1] ) // dispatchSetState ~~ 

    const 증가함수2 = ( ) =>{
        c[1]( c[0]++ ); // 컴포넌트/함수 가 재실행 ==> return 실행된다.
        // 전역변수는 컴포넌트/함수 재실행(렌더링)에 밖에 있으므로 누적  
        // 지역변수는 컴포넌트/함수 재실행(렌더링)에 안에 있으므로 초기화 
        // state변수는 지역/전역변수 아닌 개념이 아닌 리액트가 별도로 상태(값) 저장/관리 해준다.
    }
    // (4) state 일반적인 사용법 , 구조 분해 , const [ 변수명 , set변수명  ] = useState( 초기값 );
    const [ count , setCount  ] = useState( 0 );

    const 증가함수3 = ( ) => {
        console.log( count ); // 0
            // count = count + 1; // 증가 // const 불가능 // const 상수
        console.log( count );
        // 렌더링 제공 함수 ,  setXXX( 새로운값 )
            // setCount( count );
        setCount( count + 1 ); // count가 const 일때 count + 1 가능 , count++(count = count + 1) 불가능
    }
    
    // 컴포넌트(함수) : 한번 return 된 JSX문법의 결과(HTML) 불변성이다.
    return(<>
            <div>
                <p> 일반 변수 : { a } , { b } </p>
                <button onClick={ 증가함수1 } > 증가함수 </button>
            </div>
            <div>
                <p> state 변수 : { c }</p>
                <button onClick={ 증가함수2 } > 증가함수2 </button>
            </div>
            <div>
                <p> state 변수2 : { count } </p>
                <button onClick={ 증가함수3 } > 증가함수3 </button>
            </div>
        </>)
}
/*
    - 변수란 : 하나의 자료를 저장할수 있는 메모리 공간 
    - 리터럴이란 : 자료 그자체 
        let a = 10;
        let b = 10;
        let c = 20;
            변수 3개 , 자료 2개
        let d = a + 1 
            변수 4개 , 자료 3개
        ---------------------
        let f = 10 + 1 , 2개의 자료를 연산하여 새로운 1개의 자료 만들었다.
            변수 1개 , 자료 1개 

    - 연산 이란 ? 하나 이상의 값(피연산자)를 정해진기호(연산자)에 계산 했을때 *** 하나의 결과 도출 **
*/