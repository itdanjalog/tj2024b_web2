console.log("index.js open")

// [1] 등록 함수
const onSave = ( ) => {
    // (1)
    const name = document.querySelector('.name').value;
    const kor = document.querySelector('.kor').value;
    const math = document.querySelector('.math').value;
    // (*) 객체{} 선언할때 대입할 변수명이 객체의 필드명 동일하면 생략가능
    // const obj = { name : name , kor : kor , math : math };
    const obj = { name , kor , math };
    console.log( obj );

    // (*) fetch(JS내장함수) vs axios(기본값JSON) vs $.ajax(JQUERY)
        // 1. axios 설치 : HTML에 AXIOS CDN 코드 넣어준다. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
        // 2. axios 문법
            // 1. axios.[HTTP메소드명].() : axios.get() , axios.post() , axios.put() , axios.delete()
            // 2. .( '통신할HTTP주소' , {body} , {옵션} )
    axios.post( '/day04/student' , obj  )
        .then( response => { console.log( response ); } )
        .catch( e => { console.log( e ) } )

    // (2)
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