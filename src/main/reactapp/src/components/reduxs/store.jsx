import { configureStore  } from '@reduxjs/toolkit'
import  userReducer  from './userSlice'
// (1) 리덕스 store 만들기 
// (2) 변수에 configureStore 함수 대입한다.
// (3) configureStore 함수의 매개변수에 리듀서 정의/등록 
// (4) { reducer : { 리듀서명1 : 등록할리듀서1 , 리듀서명2 : 등록할리듀서2 } }

// (6)  리덕스 퍼시스턴스 함수 가져오기 
import { persistStore , persistReducer } from 'redux-persist'
import storage from 'redux-persist/lib/storage'; // 브라우저의 localStorage 사용

// (7) 퍼시스턴스 설정  , { storage , key : "key정의" }
const persistConfig = { 
    storage , // localStorage 에 사용 설정 
    key : "root" , // localStorage 저장할 키 설정 
}
// (8) 퍼시스턴스 적용할 리듀서 설정 , persistReducer( 퍼시스턴스설정 , 적용할리듀서 )
const persistedReducer = persistReducer( persistConfig , userReducer )

export const store = configureStore( { 
    // reducer : { user : userReducer  } // 퍼시스턴스 적용하기전 리듀서 
    reducer : { user : persistedReducer  } // (9)퍼시스턴스가 적용된 리듀서 
} )
// (10) 퍼시스턴스가 적용된 스토어 내보내기 
export const persistor = persistStore( store );
// (5) store 내보내기 
export default store;