import { configureStore  } from '@reduxjs/toolkit'
import  userReducer  from './userSlice'
// (1) 리덕스 store 만들기 
// (2) 변수에 configureStore 함수 대입한다.
// (3) configureStore 함수의 매개변수에 리듀서 정의/등록 
// (4) { reducer : { 리듀서명1 : 등록할리듀서1 , 리듀서명2 : 등록할리듀서2 } }

import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage"; // localStorage 사용

// Persist 설정
const persistConfig = {
    key: "root", // 저장될 키
    storage, // localStorage에 저장
};

// userReducer를 persistReducer로 감싸기
const persistedReducer = persistReducer(persistConfig, userReducer);

export const store = configureStore( { 
    reducer : { user : persistedReducer  } 
    ,    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware({
            serializableCheck: false, // ✅ 직렬화 검사 비활성화
        }),
} )


// (5) store 내보내기 
export const persistor = persistStore(store);
export default store;

