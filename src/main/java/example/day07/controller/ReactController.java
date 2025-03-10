package example.day07.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController // 빈 등록
@RequestMapping("/day07/react") // 공통 URL
@CrossOrigin("http://localhost:5173") // CORS 정책 허용 , 특정 url만 허용 가능하도록 한다. , 우리의 리액트 서버 허용
public class ReactController {
    // (샘플데이터 저장하는 리스트 == 데이터베이스 대신에 사용.)
    private List<Map<Object,String>> boards = new ArrayList<>();
    // [1] POST
    @PostMapping("")
    // [POST] http://localhost:8080/day07/react
    // { "writer" : "유재석" , "content" : "안녕하세요" , "pwd" : "1234" }
    public boolean onPost(@RequestBody Map<Object,String> map ){
        System.out.println("ReactController.onPost");// soutm
        System.out.println("map = " + map);// soump
        boards.add( map ); // 요청받은 데이터를 리스트에 저장
        return true;
    } // f end

    // [2] GET
    @GetMapping("")
    // [GET] http://localhost:8080/day07/react
    public List<Map<Object,String>> onFindAll(){
        System.out.println("ReactController.onFindAll"); // soutm
        return boards; // 리스트를 응답하기
    }
}
