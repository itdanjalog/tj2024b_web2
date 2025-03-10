package example.day07.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // 빈 등록
@RequestMapping("/day07/react") // 공통 URL
@CrossOrigin("http://localhost:5173") // CORS 정책 허용 , 특정 url만 허용 가능하도록 한다. , 우리의 리액트 서버 허용
public class ReactController {
    // [1] POST
    @PostMapping("")
    // [POST] http://localhost:8080/day07/react
    // { "writer" : "유재석" , "content" : "안녕하세요" , "pwd" : "1234" }
    public boolean onPost(@RequestBody Map<Object,String> map ){
        System.out.println("ReactController.onPost");// soutm
        System.out.println("map = " + map);// soump
        return true;
    }
}
