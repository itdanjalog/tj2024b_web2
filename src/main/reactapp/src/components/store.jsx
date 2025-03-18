import { configureStore } from "@reduxjs/toolkit";
import userReducer from "./userSlice"; // 사용자 상태 관리

export const store = configureStore({
    reducer: {
        user: userReducer, // 리듀서 등록
    },
});

export default store;