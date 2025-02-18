package example.day02._3과제;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // +@Component포함
public class BoardController2 {

    @Autowired  // 자동으로 객체가 생성된다.
    BoardDao boardDao;

    // (3) POST 매핑으로 '/day02/task1/board' 주소의 body값을 dto로 매핑하여 함수 매개변수로 받는다,
    @PostMapping("") // 1. POST 매핑주소를 만든다.
    public boolean method1( @RequestBody BoardDto boardDto ){ // 2.body 값을 함수 매개변수로 매핑한다.
        return boardDao.method1( boardDto );
    } // f end

    @GetMapping("")
    public List<BoardDto> method2(){
        return boardDao.method2();
    } // F END

    // (5) GET 매핑
    @GetMapping("/view")
    public BoardDto method3( @RequestParam( name = "bno") int bno ){
        return boardDao.method3( bno );
    } // F END

    @PutMapping("")
    public boolean method4( @RequestBody BoardDto boardDto ){
        return boardDao.method4( boardDto );
    } // f end


    // (7) DELETE 매핑
    @DeleteMapping("/day02/task1/board")
    public boolean mehtod5( @RequestParam( name = "bno") int bno ){
        return boardDao.mehtod5( bno );
    } // f end


}
