// vite.config.js
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0', // 모든 IP에서 접근 가능
    port: 5173,       // 포트 확인
  }
})
