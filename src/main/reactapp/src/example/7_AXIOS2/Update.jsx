import axios from "axios"
import { useState } from "react"
import { useNavigate } from "react-router-dom"

export default function Update( props ){

    const [ productFrom , setProductForm ] = useState({ id : '' , name : '' , price : '' , comment : ''})
    const onValueChange = ( e ) => {
        setProductForm( { ...productFrom , [ e.target.name ] : e.target.value } )
    }

    const navigate = useNavigate();
    const onUpdate = async ( ) => {
        const response = await axios.put('http://localhost:8080/day08/products' , productFrom )
        if( response.data == true){ alert('수정성공'); navigate('/read'); }
        else{ alert('수정실패:없는제품번호 이거나 시스템오류'); }
    }

    return(<><div> 
        <h3>Update 페이지</h3> 
        <form>
            수정할제품번호 : <input name="id" value={ productFrom.id } onChange={ onValueChange } /> <br/>
            새로운제품명 :  <input name="name" value={ productFrom.name } onChange={ onValueChange } /> <br/>
            새로운가격 :  <input name="price" value={ productFrom.price } onChange={ onValueChange } /> <br/>
            새로운설명 : <textarea name="comment" value={ productFrom.comment } onChange={ onValueChange }  ></textarea> <br/>
            <button type="button" onClick={ onUpdate }> 수정 </button>
        </form>
    </div></>)
}
