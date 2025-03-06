/*
  리액트 과제1 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
    조건1 : 두개의 컴포넌트 모두 활용 하시오.
  카카오톡 제출 : ip로 제출 
*/

// 컴포넌트란? 1.클래스형컴포넌트 2.함수형컴포넌트(*)
// ProductCard 컴포넌트 : 하나의 제품정보를 표현하는 UI 구역      (하위)
// Task 컴포넌트 : 여러개의 ProductCard 컴포넌트 포함하는 UI 구역 (상위)
// 1. 샘플 데이터로 간단한 화면구현
// 2. 'ProductCard' 재사용(재호출) 함으로써 HTML 코드 양 줄일 수 있다.!!!
// 3. props : 하위 컴포넌트의 속성(매개변수) 전달
// 4. 반복문 이용한 하위 컴포넌트 호출 
// const ProductCard = ( props ) => { console.log( props );
const ProductCard = ( { title , price , inStock } ) => {  // props 객체를 구문(객체) 분해 해서 각 변수로 저장 
  return (<>
    <ul>
      <li> { title } </li>
      <li> 가격 : { price.toLocaleString() } </li>
      <li> { inStock == true ? '재고있음' : '재고없음' } </li>
    </ul>
  </>);
};

import './Task.css' // css 파일 호출 
export default function Task( props ) {
  const products = [
    { title: "무선 키보드", price: 45000, inStock: true },
    { title: "게이밍 마우스", price: 32000, inStock: false },
    { title: "27인치 모니터", price: 280000, inStock: true }
  ]; 
  return (<>
    <div className='taskbox'>
      {
        products.map( ( product , index ) => {
          return <ProductCard title = { product.title } price = { product.price }  inStock = { product.inStock }  />
        })
      }
    </div>
  </>);
}