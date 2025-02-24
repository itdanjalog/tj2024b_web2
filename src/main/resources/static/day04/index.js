console.log("index.js open")
// [2] 전체 조회 함수
const onFindAll = async ( ) => {
    // (동기화) await , async
    try{
        const response = await axios.get( '/day04/student' )
        console.log( response.data ); // response 응답(정보)객체 , response.data : 응답객체내 본문내용
        const tbody = document.querySelector('tbody')
        let html = ``
            response.data.forEach( student => {
                html += `<tr>
                            <td>${ student.name } </td>
                            <td>${ student.kor }  </td>
                            <td>${ student.math }  </td>
                          </tr>`
            })
        tbody.innerHTML = html;
    }catch( e ){ console.log( e ); }
} // f end
onFindAll(); // 전제조회 함수 실행

// [1] 등록 함수
const onSave =  ( ) => {
    // (1)
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;
    // (*) 객체{} 선언할때 대입할 변수명이 객체의 필드명 동일하면 생략가능
    // const obj = { name : name , kor : kor , math : math };
    const obj = { name , kor , math };
    console.log( obj );

    // (*) fetch 대신에 axios 활용한 비동기화통신 vs 동기화통신 , 상황에 따라 다르다.
    // ( 비동기 )
    axios.post( '/day04/student' , obj )
        .then( response => { console.log( response.data ); onFindAll(); })
        .catch( e => { console.log( e ); } )

    // (*) fetch(JS내장함수) vs axios(기본값JSON) vs $.ajax(JQUERY)
    // (1) fetch 와 비슷한 구조의 axios 사용하는 방법
    // axios.post( '/day04/student' , obj )
    //    .then( response => { console.log( response.data ) } )
    //    .catch( e => { console.log(e); })

    // (2)
    //console.log('axios 실행 전'); // 1.첫번째 콘솔
    //axios.post( '/day04/student' , obj )
    //    .then( response => { console.log( response.data ) } ) // 2.두번째 콘솔
    //    .catch( e => { console.log(e); })
    //console.log('axios 실행 후 ') // 3.세번째 콘솔
    // 첫번째 콘솔 -->> 세번째 본솔 -->> 두번째 콘솔  : 왜?
    // 비동기 통신( JS는 axios요청 보낸후에 응답을 기다리지 않고 다음 코드 실행 )
    // 예시] 카페 에서 '커피' 하나 주문 사람과 '커피1/빵10개/파스타1' 주문 사람 중 누가 먼저 응답 올까?
    // (비동기) : 먼저 처리/응답 된 순서대로 처리한다. '커피' 먼저 나온다.
    // (동기) : 앞에 있는 처리가 응답/처리 이 올때까지 다음 요청을 대기 상태

    // (3)
    //console.log('axios 실행 전'); // 1.첫번째 콘솔
    //const response = axios.post( '/day04/student' , obj )
    //console.log( response.data ); // 2. 두번째 콘솔
    //console.log('axios 실행 후 ') // 3.세번째 콘솔
    // 실행순서 : 첫번째 콘솔 ->  두번째 콘솔 ->  세번째 콘솔 : 왜? axios의 응답값이 반환 되기전에 두번째 콘솔 출력된다.

    // (4) 동기(순차처리) 화 방법 = 필요에 따라 / 형식  vs 비동기(병렬처리) 방법 = 기본값
        // 동기화 : 1. await 함수명( ) 2. 현재 함수명 앞에 async
//    console.log('axios 실행 전'); // 1.첫번째 콘솔
//    const response = await axios.post( '/day04/student' , obj )
//    console.log( response.data ); // 2. 두번째 콘솔
//    console.log('axios 실행 후 ') // 3.세번째 콘솔

    // fetch
    /*
    option = {
        method : 'POST' ,
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( obj )
    }
    fetch( '/day04/student' , option )
        .then( r => r.json() )
        .then( data => { console.log(data);})
        .catch( e => { console.log(e); } )
    */
}// f end