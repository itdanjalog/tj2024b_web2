package example.day01._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // 1. 스프링 컨테이너 빈 등록 // 2. HTTP 서블릿 지원 // 3. ResponseBody 포함
@RequestMapping( value = "/day01/task/board") // 1. 지정된 클래스내 메소드들의 http 공통 URL 정의
public class TaskController {

    // [1] POST : 글쓰기 // http://localhost:8080/day01/task/board
    @PostMapping("") // HTTP 는 method 와 url 이 모두 동일 할 수 없다.
    public boolean method1(){  return true; }

    // [2] GET : 전체 글 조회  // http://localhost:8080/day01/task/board
    @GetMapping("")
    public List<Map<String,String>> method2() {
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        list.add( map1 );
        Map<String,String> map2 = new HashMap<>();
        map2.put("bno" , "2" );
        map2.put("btitle" , "제목2");
        list.add( map2 );
        return list;
    }

    // [3] GET : 개별 글 조회 // http://localhost:8080/day01/task/board/view
    @GetMapping("/view")
    public Map<String,String> method3(){
        Map<String,String> map1 = new HashMap<>();
        map1.put("bno" , "1" );
        map1.put("btitle" , "제목1");
        return map1;
    }

    // [4] PUT : 개글 글 수정 // http://localhost:8080/day01/task/board
    @PutMapping("")
    public boolean method4(){ return true; }

    // [5] DELETE : 개별 글 삭제 // http://localhost:8080/day01/task/board
    @DeleteMapping("")
    public int method5(){ return 3; }


} // c end
