package example.day02._3과제;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardDao {

    // (2) 현재 과제에서는 DB가 없으므로 리스트가 DB 역할 한다.
    private final List<BoardDto> boardTable = new ArrayList<>();
    private int auto_increment = 1; // bno 자동번호 역할

    // (3) POST 매핑으로 '/day02/task1/board' 주소의 body값을 dto로 매핑하여 함수 매개변수로 받는다,

    public boolean method1(  BoardDto boardDto ){ // 2.body 값을 함수 매개변수로 매핑한다.
        boardDto.setBno( auto_increment ); // 3. boardDto의 bno를 넣어준다.
        boardTable.add( boardDto ); // 4. 리스트에 boardDto를 넣어준다.
        auto_increment++; // 5. auto_increment 증가한다.
        return true; // 6. 리턴한다.
    } // f end

    // (4) GET 매핑
    public List<BoardDto> method2(){
        return boardTable;
    } // F END

    // (5) GET 매핑
    public BoardDto method3( int bno ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++ ){
            BoardDto boardDto = boardTable.get(index);
            if( boardDto.getBno() == bno ){ return boardDto; } // 찾았으면 찾은 DTO 반환
        }
        return null; // 없으면
    } // F END

    public boolean method4(  BoardDto boardDto ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++ ){
            BoardDto boardDto2 = boardTable.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                boardTable.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end

    public boolean mehtod5( int bno ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++  ){
            BoardDto boardDto2 = boardTable.get(index);
            if( boardDto2.getBno() == bno ){
                boardTable.remove( index );
                return true;
            }
        }
        return false;
    } // f end

}
