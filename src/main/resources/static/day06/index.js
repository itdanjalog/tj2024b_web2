console.log( 'index.js open')

// JS의 기본 문법 정리 , ( react 에서 필요한 기본 문법 )

// [1] 변수선언 , let 변수 , const 상수
    // 1. 변수 
let count = 0; // 변수 선언 
count = 1; // 변수값 수정 
    // 2. 상수 
const count2 = 0; // 상수 선언 
//count2 = 1; // 상수값 수정 // 오류 : Assignment to constant variable.

// * 주의할점 : 객체가 상수에 저장하고 객체내 속성값 수정 가능하다.
const obj = { name : '유재석' }
obj.name = '강호동';
console.log( obj );

// [2] 함수 
    // 정의1 : 선언적 함수
function fun1( param1 , param2 ){ }
    // 정의2 : 익명 함수 , 주로 변수/상수 저장해서 사용한다. , 이벤트 함수 사용
const fun2 = function ( param1 , param2 ){ }
    // 정의3 : 화살표/람다식 함수 , 주로 변수/상수 저장해서 사용한다. , 이벤트 함수 사용
const fun3 = ( param1 , param2 ) => { }
    // 호출/사용
fun1( 4 , 10 );
fun2( '유재석' , '강호동' )
fun3( 10 , '유재석')
// * 기본 매개변수값 정의 : 인자가 없을때 기본값을 대입할 수 있다.
const fun4 = ( param1 , param2 , param3 = '학생')=>{}
fun4( '유재석' , 10 )

// [3] 객체  : { } 객체 : key 와 value 으로 한쌍을 구성하여 여러쌍을 { } 묶음 , [ ] 리스트/배열
    // 1. 객체 : { key : value , key : value , key : value , key : value }
const obj2 = { 'name' : '유재석' , 'age' : '40' }
    // 2. 속성명(key) 단축
const name3 = '강호동';
const age3 = 50;
const obj3 = { name3 , age3 } // vs { name3 : name3 , age3 : age3 }
    // 3. 객체의 속성값 호출 , .(접근연산자) 
console.log( obj3.name3 )
console.log( obj3.age3 )
    // 4. 리스트/배열 : [ value , value , value , value , value ]
const array1 = [ 1 , 2 , 3 , 4 , 5 ]
console.log( array1 )
    // 5. 리스트내 값 호출 , [인덱스]
console.log( array1[3] ) // 4번쨰 값 호출 
    // 6. * 스프레드 연산자 (...) , 배열이나 객체를 복사하거나 합칠 때 사용
const array2 = [ ...array1 , 6 , 7 ] // [ ...기존배열 , value , value  ]
console.log( array2 )
const obj4 = { ...obj3 , phone : '010' } // { ...기존객체 , key : value , key : value }
console.log( obj4 )

// [4] 백틱 : 문자열 템플릿 , +연산자 가 아닌 `(백틱) 안에 ${}를 이용하여 문자열과 표현식을 연결할 때 사용.
    // 백틱 `${ 선언부 불가능 / 표현부 가능 }` , 
        //  선언부 : if/for/while/객체/변수/함수 선언 등등 불가능, 
        // 표현부 : 1 + 3 /  삼항연산자 / 변수호출/함수호출/객체호출 등등 가능 
const str4 = 'react';
console.log( `Hello ${ str4 }` )

// [5] 구조 분해 할당  , 객체나 배열에서 값을 분해 추출하는 방법
const user = { name5 : '신동엽' , age5 : 50 }
const { name5 , age5 } = user;  // 객체내 동일한 속성명으로 변수를 여러개 분해 해서 저장할 수 있다.
console.log( name5 )
console.log( age5 )
// [6] 비구조화 할당과 나머지 연산자 , 배열 또는 객체 뒤에 ...이용하여 나머지는 객체 또는 배열로 저장하는 방법 
const [ arr6, ...rest ] = [ 1 , 2, 3, 4 ]
console.log( arr6 ) // 1 
console.log( rest ) // 나머지.

const { name6 , ...rest2 } = { name6 : '서장훈' , age : 70 , phone : '010' }
console.log( name6 ) // 서장훈 
console.log( rest2 ) // {  age : 70 , phone : '010' }













 





 



