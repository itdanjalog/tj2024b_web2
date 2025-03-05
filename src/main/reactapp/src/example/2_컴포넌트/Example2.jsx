
export default function Example2( props ){
    return(<>
        { /* 하위컴포넌트 호출 + 매개변수 */}
        <SubComponent1 name="유재석" />
        <SubComponent1 name="강호동" age ="10" />
        <SubComponent2> 여기가 props.children 입니다. </SubComponent2>
        <SubComponent2> <button> 부모가 전달한 버튼 마크업 </button> </SubComponent2>
        <SubComponent3 name="유재석" age = "40" />
        <SubComponent3 name="강호동" age = "50" />
        <SubComponent4 nation="일본" />
        <SubComponent4 />
    </>)
} // f end 

// (1) 하위 컴포넌트 매개변수 
function SubComponent1( props ){
    console.log( props ); // {name: '유재석'} , {name: '강호동'}
    // props.name = '신동엽'; // props 읽기모드
    return (<> <h3> 안녕하세요. name : { props.name } age : { props.age } </h3> </>)
} // f end 

// (2) 하위 컴포넌트 자식요소 ,  props.children  : 자식요소 사이 innerHTML 반환
function SubComponent2( props ){
    console.log( props )
    return (<> <h3> { props.children } </h3> </>)
}
// (3) 하위 컴포넌트 매개변수 의 구문 분해 ,  { name } = { name : '유재석' , age : 40 } 
    // (1) 구문 분해를 사용하지 않을때.
/*
function SubComponent3( props ){
    return (<> { props.name } 님 { props.age }살 입니다. </>)
}
*/
    // (2) 구문 분해를 사용했을때
function SubComponent3( { name , age } ){   // props 대신에 { 속성명 } 표현하면 props 내 존재하는 속성명을 변수로 각 선언된다.
    return (<> <h3> { name } 님 { age }살 입니다.</h3> </>)
}

// (4) 하위 컴포넌트 매개변수 기본값 지정  = 구문 분해
function SubComponent4( { nation = "대한민국" } ){
    return (<> <h3> { nation } 국적 입니다. </h3></>)
}

