package example.day02._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // (1) 해당 컨트롤러가 HTTP url 매핑 할 수 있도록 어노테이션 주입
public class BoardController {

    // (2) 현재 과제에서는 DB가 없으므로 리스트가 DB 역할 한다.
    private final List<BoardDto> boardTable = new ArrayList<>();
    private int auto_increment = 1; // bno 자동번호 역할

    // (3) POST 매핑으로 '/day02/task1/board' 주소의 body값을 dto로 매핑하여 함수 매개변수로 받는다,
    @PostMapping("/day02/task1/board") // 1. POST 매핑주소를 만든다.
    public boolean method1( @RequestBody BoardDto boardDto ){ // 2.body 값을 함수 매개변수로 매핑한다.
        boardDto.setBno( auto_increment ); // 3. boardDto의 bno를 넣어준다.
        boardTable.add( boardDto ); // 4. 리스트에 boardDto를 넣어준다.
        auto_increment++; // 5. auto_increment 증가한다.
        return true; // 6. 리턴한다.
    } // f end

    // (4) GET 매핑
    @GetMapping("/day02/task1/board")
    public List<BoardDto> method2(){
        return boardTable;
    } // F END

    // (5) GET 매핑
    @GetMapping("/day02/task1/board/view")
    public BoardDto method3( @RequestParam( name = "bno") int bno ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++ ){
            BoardDto boardDto = boardTable.get(index);
            if( boardDto.getBno() == bno ){ return boardDto; } // 찾았으면 찾은 DTO 반환
        }
        return null; // 없으면
    } // F END

    // (6) PUT 매핑
    @PutMapping("/day02/task1/board")
    public boolean method4( @RequestBody BoardDto boardDto ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++ ){
            BoardDto boardDto2 = boardTable.get( index );
            if( boardDto2.getBno() == boardDto.getBno() ){
                boardTable.set( index , boardDto );
                return true;
            }
        }
        return false;
    } // f end

    // (7) DELETE 매핑
    @DeleteMapping("/day02/task1/board")
    public boolean mehtod5( @RequestParam( name = "bno") int bno ){
        for( int index = 0 ; index <= boardTable.size()-1 ; index++  ){
            BoardDto boardDto2 = boardTable.get(index);
            if( boardDto2.getBno() == bno ){
                boardTable.remove( index );
                return true;
            }
        }
        return false;
    } // f end

} // c end