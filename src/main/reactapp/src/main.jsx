import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
//import './index.css'
//import App from './App.jsx'

// react18
// (!) 기본 코드 주석처리
// createRoot(document.getElementById('root')).render(
//   <App />
// )

// (*) index.html에 root DOM 가져오기.
const root = createRoot( document.querySelector('#root') )

// day01 : '컴포넌트 만들기' 렌더링 
    // import 호출할컴포넌트명 from '경로/파일명(확장자)';
//import Component1 from './example/1_동작구조/Component1.jsx'
//root.render( <Component1 /> )

// day01 : 여러 컴포넌트 만들기 
//import Component2 from './example/1_동작구조/Component2.jsx'
//root.render( <Component2 /> )

// day02 : 컴포넌트의 JSX 활용 
//import Example1 from './example/2_컴포넌트/Example1.jsx'
// root.render( <Example1 /> )

// day02 : 컴포넌트의 Props 활용 
// import Example2 from './example/2_컴포넌트/Example2.jsx'
// root.render( <Example2 /> )

// day02 : 실습1
// import Task from './example/2_컴포넌트/Task.jsx'
// root.render( <Task /> )

// day03 : 생명주기1
// import Example1 from './example/3_훅/Example1.jsx'
// root.render( <Example1/> )

// day03 : 생명주기2
// import Example2 from './example/3_훅/Example2.jsx'
// root.render( <Example2/> )

// day03 : 생명주기3
// import Example3 from './example/3_훅/Example3.jsx'
// root.render( <Example3 /> )

// import Task1 from './example/3_훅/Task1.jsx'
// root.render( <Task1 /> )

// import Task2 from './example/3_훅/Task2.jsx'
// root.render( <Task2 /> )

// import Example1 from './example/4_훅2/Example1.jsx'
// root.render( <Example1 /> )

// main.jsx 가장 위에 존재하는 import App / import .css 샘플 코드 주석처리 , 
import App from './example/5_라우터/Example1.jsx'
root.render( <App /> )