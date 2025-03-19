
import { createSlice } from "@reduxjs/toolkit";
// (1) 전역 상태(변수) 로 사용할 데이터 초기값 정의
const initialState = {
    userInfo : null , // 로그인한 정보를 저장 할 속성
    isAuthenticated : false // 로그인 여부 상태를 저장하는 속성 , false : 비로그인 , true:로그인
}
// (2) 'createSlice' 함수 이용한 상태 와 리듀서 만들기
// (3) 전역 상태 정의 , name : "상태(변수)의 이름", 상태(변수)의 초기값 
// (4) 전역 상태 수정 하는 리듀서 만들기 , reducers : { 함수명 : 처리함수  ,  함수명 : 처리함수 }
const userSlice = createSlice( {
    name : "user", // 상태(변수)의 이름
    initialState , // 상태(변수)의 초기값 
    reducers : { 
                    login : (state,action) => { 
                        state.isAuthenticated = true; // 로그인 함수 호출시 로그인 여부를 true 변경 
                        state.userInfo = action.payload; // 로그인 함수 호출시 로그인 정보를 매개변수로 받은 값(payload)들로 변경 
                    } 
                    , // 리듀서 함수들 구분 
                    logout : (state) => {
                        state.isAuthenticated = false; // 로그아웃 함수 호출시 로그인 여부를 false 변경 
                        state.userInfo = null; // 로그아웃 함수 호출시 로그인 정보를 null로 변경 
                    }
                }
})
// (5) export 
export const { login , logout } = userSlice.actions; // 액션 생성한다.
export default userSlice.reducer // 리듀서 내보내기 // userReducer

