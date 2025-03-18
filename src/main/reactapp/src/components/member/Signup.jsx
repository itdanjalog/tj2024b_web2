import { use, useState } from "react"
import axios from 'axios';
import {  useNavigate } from 'react-router-dom';

export default function Signup( props ){
    // (1) 입력받은 값들을 저장하는 state변수 선언 , 
    // const [ 변수명 , set변수명 ] = useState(초기값)
    // setXXXX( 새로운(주소)값 ) : 새로운 주소 및 리터럴이 들어올 경우 자동 렌더링 한다.

    // (리액트)memberInfo의 속성명은 일반적으로 (자바)memberDto의 멤버변수 와 동일하게 
    const [ memberInfo , setMemberInfo ] = useState( { mid : "" , mpwd : "" , mname : ""  } )

    // (2) 입력받은 값들을 state 렌더링 하는 함수 , event : onChange 결과정보 , event.target : 해당 함수를 실행시킨 마크업
    const onInputChange = ( event ) => { // 
        setMemberInfo( { ...memberInfo , [ event.target.name] : event.target.value } )
    } // f end 
    
    // (3) 입력받은 첨부파일 * 첨부파일의 미리보기 
    const [ profile , setProfile ] = useState(null); // 업로드 파일을 파일객체로 저장하는 state 변수
    const [ preview , setPreview ] = useState(null); // 업로드 파일을 바이트로 저장하는 state 변수 
    const onFileChange = (event) => {  console.log( event.target.files[0] )// 사용자가 입력한 파일 객체 반환. // JS 에서 File 클래스 제공 
        // 1. 업로드된 파일 반환 
        const file = event.target.files[0];
        // 2. state 저장 
        setProfile( file )
        // 3. * 이미지 미리보기( 자바 업로드 와 관련 없음 )
        if( file ){
            // 4. 파일 읽기 객체 선언 
            const reader = new FileReader(); // js객체 : 파일 읽기 객체
            // 5. 파일 읽기 메소드 정의 .reader.onloadend( () => { 파일읽어드릴때 실행할코드 })
            reader.onloadend = ( ) => { 
                console.log( reader.result ); // 읽어드린 파일을 출력 , reader.result : 가져온 파일의 결과물(바이트)
                setPreview( reader.result ); // state에 저장 
            }
            // 6. 파일 읽기 , //  파일객체 읽기 ,   reader.readAsDataURL( file객체 )
            reader.readAsDataURL( file ) 
        }else{ // 파일이 없으면 
            setPreview(null);
        }
    } // f end 


    // (4) 입력받은 값들을 axios로 보내고 응답받기 
    const navigate = useNavigate();
    const onSignup = async ( ) =>{
        // 1. formdata 객체 만들기 , json 과 다르게 문자열 전송이 아닌 바이트(바이너리) 전송를 하기위한 폼전송  
        const formData = new FormData()
        // 2. formdata 에 속성 넣기 , .append( '속성명' , 값 ) 
        formData.append( 'mid' , memberInfo.mid );
        formData.append( 'mpwd' , memberInfo.mpwd );
        formData.append( 'mname' , memberInfo.mname );
        // * 만약에 첨부파일이 존재하면 첨부파일 추가
        if( profile ){
            formData.append( 'uploadfile' , profile );
        }
        

        // 3. axios 에서 사용할 http 헤더 정보 , axios 에서는 *application/json* 은 기본값 이므로 할 필요없다.
        const option = { headers : { "Content-Type" : "multipart/form-data"} }
        // 4. axios 동기 
        const response = await axios.post( "http://localhost:8080/api/member/signup" , formData , option );
        // 5. 응답 받기  , response.data 
        const result = response.data;
        // 6. 응답에 따른 처리 
        if( result == true ){ 
            alert('회원가입성공'); 
            // 7. 페이지 전환
            navigate('/login');// navigate("/login") : 새로고침없다  vs location.href="/login"; : 새로고침있다. 
        }
        else{ alert('회원가입 실패'); }
    }

    return (<> 
        <h3> 회원가입페이지 </h3>
        <form>
            아이디 : <input type="text" name="mid" value={ memberInfo.mid } onChange={ onInputChange } /> 
            <br/>
            비밀번호 : <input type="password" name="mpwd" value={ memberInfo.mpwd } onChange={ onInputChange  }  /> 
            <br/>
            닉네임 : <input type="text" name="mname" value={ memberInfo.mname } onChange={ onInputChange } /> 
            <br/>
            프로필 : <input type="file" accept="image/*" onChange={ onFileChange } /> 
            <br/>
            {
                preview && (<>
                    미리보기 : 
                    <img  src={ preview }
                          style={ { width : "100px"} }
                        />
                </> )
            }
            <br/>
            <button type="button" onClick={ onSignup }> 회원가입 </button>
        </form>
    </>)
}