package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day02")
public class RestController3 {
    // ========== 쿼리스트링의 매개변수들을 매핑 하는 방법 ========= //
    //[1] HTTP GET
    @GetMapping("/doget1")   // http://localhost:8080/example/test1?key1=qwe&key2=123
    public String test1( HttpServletRequest request ){
        System.out.println("RestController4.test1");
        String key1 = request.getParameter("key1"); System.out.println("key1 = " + key1);
        String key2 = request.getParameter("key2"); System.out.println("key2 = " + key2);
        return "test1 HI";
    }
    //[2] HTTP GET          // http://localhost:8080/example/test2?key1=qwe&key2=123
    @GetMapping("/doget2")   // 전제조건 : 쿼리스트링의 key 이름과 메소드의 매개변수명이 동일해야 한다.
    public String test2( String key1 , int key2 ){   // 메소드명 ( 타입 key  , 타입 key )
        System.out.println("RestController4.test2");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return "test2 HI";
    }
    //[3] HTTP GET
    @GetMapping("/doget3")   // http://localhost:8080/example/test2?key1=qwe&key2=123
    public String test3( @RequestParam("key1")String name , @RequestParam("key2") int age ){
        // 쿼리스트링의 KEY 이름과 메소드의 매개변수명이 동일하지 않기 때문에 오류 , 해결방안  @RequestParam("key") 타입 매개변수명
        System.out.println("RestController4.test3");
        System.out.println("name = " + name + ", age = " + age);
        return "test3 HI";
    }
    //[4] HTTP GET
    @GetMapping("/doget4") // http://localhost:8080/example/test4?key1=qwe&key2=123
    public String test4( RestDto restDto ){ // 전제조건 : 쿼리스트링의 KEY 이름과 멤버변수의 이름과 동일해야 한다.
        System.out.println("RestController4.test4");
        System.out.println("restDto = " + restDto);
        return "test4 HI";
    }

}
