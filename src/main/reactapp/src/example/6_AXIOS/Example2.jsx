import { useEffect, useState } from "react"
import axios from 'axios'; // 
export default function Example2( props ){
    // [1] 입력받은 데이터를 저장하는 폼 state 변수 , {writer:'' , content : '' , pwd : ''} 초기값 
    const [ formData , setFormData ] = useState( {writer:'' , content : '' , pwd : ''} )
    // [2] 입력받은 데이터를 렌더링 하는 이벤트함수.
    const formDataChange = (e)=>{
        console.log( e.target ); // 'onChange'이벤트를 발생한 html dom(마크업/태그)
        console.log( e.target.name ); // 'onChange'이벤트를 발생한 html dom의 name 속성 값 반환 
        console.log( e.target.value ); // 'onChange'이벤트를 발생한 html dom의 value 속성 값 반환
        // 스프레드 연산자 이용한 state 변수 변경 
        //  -> setXXXX( { ...기존객체 , 새로운속성명 : 새로운값 } )   *만약에 새로운속성명이 이미 존재하면 수정.
        setFormData( {...formData , [e.target.name] : e.target.value } );
    }
    // [3] 현재 state 변수를 스프링 서버에게 보내기 , AXIOS 
    const onPost = async ( e ) => {
        try{
            const response = await axios.post('http://localhost:8080/day07/react' , formData ); // state변수를 axios로 보내기
            if( response.data == true ){ // 만약에 등록 응답이 TRUE 이면 
                alert('등록성공');  // 알림 
                setFormData({ writer :'',content:'', pwd:'' }); // state 초기화
                onFindAll(); // 등록 성공하면 자료 렌더링 
            }else{ 
                alert('등록실패');
            }
        }catch( error ){ console.log( error ); }
    }

    // [4] 서버에 저장된 방문록정보( 작성자/내용/비밀번호 여러개 ) 요청한다.
    
    // (1) 컴포넌트 마운트(생성) 될때 최초 1번 실행 함수 // 컴포넌트가 생성될때 딱 1번 onFindAll 함수가 실행된다.
    useEffect( () =>{ onFindAll()  } , [] ); // onFindAll --> setBoards 끝 
    // useEffect( () =>{ onFindAll()  }  ); // onFindAll -->setBoards --> onFindAll --> setBoards 무한 렌더링 
    // useEffect( () => { onFindAll } , [ boards ] ); // onFindAll --> setBoards -->  onFindAll --> setBoards 무한 렌더링 
    
    const [ boards , setBoards ] = useState([]); //(2) 여러개의 방문록 가지는 state 변수 

    const onFindAll =  async ( e ) => {
        // (3) 주로 동기 통신 : async( e ) => { await axios.메소드명() }
            // -> 서버와 도메인 같을경우 : '/day07/react'
            // -> 서버와 도메인 다른경우 : http://localhost:8080/day07/react
        try{const response = await axios.get('http://localhost:8080/day07/react');
            setBoards( response.data ); // 서버로 부터 받은 정보를 state 변수에 저장 // 재렌더링 
        }catch(error){ console.log( error ); }
    }
    return (<>
        <div>
            <h4> 입력 폼 </h4>
            <form>
                작성자 : <input type="text" value={ formData.writer } name='writer' onChange={ formDataChange }  /> <br/>
                방문록 : <input type="text" value={ formData.content } name='content' onChange={ formDataChange }  /> <br/>
                비밀번호 : <input type="text" value={ formData.pwd } name='pwd' onChange={ formDataChange }/> <br/>
                <button type="button" onClick={ onPost }> 등록 </button>
            </form>
            <table>
                <thead><tr><th>번호</th><th>작성자</th><th>방문록내용</th><th>비고</th></tr></thead>
                <tbody>
                    {
                        boards.map( ( board , index ) => {
                            return ( 
                                <tr key={ board.num }> 
                                    <td> { board.num }</td> 
                                    <td> { board.writer}</td> 
                                    <td> { board.content}</td> 
                                    <td> 수정버튼 / 삭제버튼 </td>
                                </tr> 
                                )
                        })
                    }
                </tbody>
            </table>
        </div>
    </>)
}