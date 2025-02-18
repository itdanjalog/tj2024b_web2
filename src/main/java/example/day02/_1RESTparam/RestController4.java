package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController4 {
    // [1] HTTP request(요청) body(본문) 매핑하는 방법 , POST/PUT 사용
    // * @RequestBody : HTTP 요청 body의 'application/json' 타입 자료를 자바 타입으로 변환/매핑 해주는 어노테이션
    // -> @RequestBody 도 생략하면 @ModelAttribute 적용 되므로 body 매핑은 꼭 @RequestBody 작성 해야한다.
    // -> @RequestParam 도 생략하면 @ModelAttribute 적용 되지만 queryString 매핑은 @ModelAttribute 가능하므로 생략 가능하다.
    @PostMapping("/dopost1")
    // [POST] http://localhost:8080/day02/dopost1 , { "name" : "유재석" , "age" : "40" }
    public boolean method1( @RequestBody MemberDto memberDto ){
        System.out.println("RestController4.method1"); // soutm
        System.out.println("memberDto = " + memberDto); // soutp
        return true;
    } // f end

    @PostMapping("/dopost2")
    // [POST] http://localhost:8080/day02/dopost2 , { "name" : "유재석" , "age" : "40" }
    public boolean method2( @RequestBody Map<String , String> map ){
        System.out.println("RestController4.method2");
        System.out.println("map = " + map);
        return true;
    } // f end

} // class end
