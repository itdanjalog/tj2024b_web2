
// npm install redux-persist


import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./userSlice";
import { persistStore, persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage"; // localStorage 사용

// Persist 설정
const persistConfig = {
    key: "root", // 저장될 키
    storage, // localStorage에 저장
};

// userReducer를 persistReducer로 감싸기
const persistedReducer = persistReducer(persistConfig, userReducer);

// Redux Store 생성
export const store = configureStore({
    reducer: {
        user: persistedReducer, // 변경된 reducer 적용
    },
});

// Persistor 생성
export const persistor = persistStore(store);
export default store;
