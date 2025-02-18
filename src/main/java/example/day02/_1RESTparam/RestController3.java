package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/day02")
public class RestController3 {
    // [1] HTTP servlet 내장 객체 : HttpServletRequest , HttpServletResponse
    @GetMapping("/doget1") // [GET] http://localhost:8080/day02/doget1?name=유재석
    public void method1( HttpServletRequest req , HttpServletResponse resp ) throws Exception {
        System.out.println("RestController3.method1");  // soutm 자동완성 : 현재 함수명 출력함수
        // (1) 서블릿 방식의 쿼리스트링 받기.
        String name = req.getParameter("name");
        System.out.println("name = " + name);           // soutv 자동완성 : 가장 가까운 변수 출력함수
        // (2) 서블릿 방식의 응답 하기.
        resp.setContentType("application/json");
        resp.getWriter().println("true");
    } // f end

    // [2] 스프링 제공하는 방법
    // @RequestParam : HTTP Request(요청) 의 URL 쿼리스트링 매개변수를 매핑하는 어노테이션 , GET/POST/PUT/DELETE 모두 사용가능.
    // 1. (name = "queryString매개변수명") 타입 매개변수명
    // -> queryString 매개변수명 과 함수 매개변수명과 동일하면 하면  @RequestParam 생략 하면 @ModelAttribute 자동으로 적용.
    // 2. ( defaultValue = "홍길동" ) 타입 매개변수명
    // -> 만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
    // 3. ( required = true )
    // -> 기본값이 true 하며 , 쿼리스트링 매개변수 필수 여부 설정 , 만약에 쿼리스트링 매개변수가 없으면 400(bad request잘못된요청) 응답 , defaultValue 없이 사용.

    @GetMapping("/doget2") // [GET] http://localhost:8080/day02/doget2?name=유재석
    public boolean method2(
                @RequestParam(name = "name" , defaultValue = "홍길동" , required = true ) String name ){ // 매핑함수의 매개변수를 자동으로 쿼리스트링의 매개변수를 매핑/연결 한다.
        System.out.println("RestController3.method2");
        System.out.println("name = " + name); // soutp 자동완성 : 현재 함수의 매개변수 출력함수.
        return true; // @ResponseBody 사용했을때 자동으로 response 를 'application/json' 타입으로 응답한다.
    } // f end

    // [3]
    @GetMapping("/doget3") // [GET] http://localhost:8080/day02/doget3?name=유재석&age=40
    public int method3( @RequestParam( name = "name")   String name ,
                        @RequestParam( name = "age")    int age  ){ // + 자동타입 변환이 된다..
        System.out.println("RestController3.method3"); // soutm
        System.out.println("name = " + name + ", age = " + age); // soutp
        return 3; // 아무거나
    }

    // [3] 컬렉션 프레임워크를 이용한 쿼리스트링 매개변수 매핑
    @GetMapping("/doget4") // [GET] http://localhost:8080/day02/doget4?name=유재석&age=40
    public String method4( @RequestParam Map<String,String> map ){ // 여러개의 매개변수를 하나의 map 으로 받을수 있다.
        System.out.println("RestController3.method4"); // soutm
        System.out.println("map = " + map); // soutp
        return "hello"; // 아무거나
    } // f end

    // [4] DTO 이용한 쿼리스트링 매개변수 매핑
    // + @ModelAttribute                    vs @RequestParam
    //  생략가능(기본값)                         명시해야한다.
    //  공식타입+개발자가 만든타입(DTO)            공식적타입 만 지원 : 기본타입 + List,Map,String
    //  쿼리스트링 , form첨부파일                 쿼리스트링 지원

    // + DTO 사용시 쿼리스트링 매개변수 와 멤버변수 명이 동일한다.
    @GetMapping("/doget5") //
    public boolean method5( @ModelAttribute MemberDto memberDto ){ // 여러개의 매개변수를 하나의 DTO으로 받을수 있다. // + @RequestParam 없이.
        System.out.println("RestController3.method5");
        System.out.println("memberDto = " + memberDto);
        return true; // 아무거나
    } // f end

} // c end






