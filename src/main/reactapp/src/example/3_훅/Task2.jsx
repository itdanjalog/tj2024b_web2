import { useState } from "react"

/*
  리액트 과제3 : 리액트 전화번호부 만들기
    조건1 : (저장) '이름' 이랑 '전화번호' 입력받아 배열에 저장 
    조건2 : (전체출력) 저장된 배열내 모든 정보(이름/전화번호)를 table 또는 ol 또는 ul 로 모두 출력하시오.
    조건3 : useState 사용. 
  카카오톡 제출 : ip로 제출 

  [1] .jsx 파일 생성 
  [2] 파일내 컴포넌트(함수) 생성 , 컴포넌트명 : 첫글자대문자 필수로 한다.
    export default function 컴포넌트명(){ 
      return (<></>)
    }
  [3] main.jsx 에서 생성한 컴포넌트 렌더링 
  [4] 입력 상자의 state 변수 , document.querySelector() 방식이 아닌.
    (1) 선언 방법 : const [ 변수명 , set변수명 ] = useState( 초기값 )
      -> 초기값 : 다양한 자료의 모든 타입 가능하다. 
          문자열 초기 : '' , 정수 초기 : 0 , 실수 초기 : 0.0 , 객체 초기 : { } , 배열 초기 : [ ]
        방법1
        const [ name , setName ] = useState(''); 
        const [ phone , setPhone ] = useState('');
        const [ members , setMembers ] = useState( [] );
        방법2
        const [ member , setMember ] = useState( { name : '' , phone : '' } ); 
        const [ members , setMembers ] = useState( [] );
        방법3
        const [ members , setMembers ] = useState( [ { name : '' , phone : '' } ] );

    (2) event(e) 이벤트 객체 
      onChange = ( event ) => { } , onChange 이벤트 실행 결과를 다음 함수의 매개변수로 전달 
      event.target : 이벤트 발생한 DOM(HTML마크업)
      event.target.value : 이벤트 발생한 DOM의 value 속성 반환 
    
    (3) setXXX( 새로운값 ) , ...스프레드연산자
      setXXX( event.target.value )
      setXXX( [...기존배열 , 새로운값 ] )
      
  [5] map 반복문 이용한 출력 
    {
      리스트/배열명.map( ( 반복변수명, 인덱스 ) => {
          return (<></>)
        })
    }
*/
export default function Task1(){ 
  // (1) 입력한 성명을 저장하는 state 변수 
  const [ name , setName ] = useState(''); // 성명 state 변수 선언 
  // (2) 입력한 연락처를 저장하는 state 변수 
  const [ phone , setPhone ] = useState('');
  // (3) 입력한 성명과연락처를 객체로 저장하는 배열 state 변수  
  const [ members , setMembers ] = useState( [] ); // 배열 초기값은 빈 배열 [ ]
  return (<>
    <h3> 리액트 과제 3 </h3>
    성명 : <input value={ name } onChange={ ( e )=>{ setName( e.target.value ); } } /> <br/>
    연락처 : <input value={ phone } onChange={ ( e )=> { setPhone( e.target.value );  } } /> <br/>
    <button 
      onClick={ ( e ) => { setMembers( [ ...members , { name , phone } ] ); setName('') , setPhone('') }  } > 
      등록 
    </button>
    <ul>
      {
        members.map( ( member, index ) => {
            return (<>
              <li> 성명 : { member.name } , 연락처 : { member.phone } </li>
            </>)
          })
      }
    </ul>
  </>)
}

