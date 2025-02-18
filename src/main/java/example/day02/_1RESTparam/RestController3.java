package example.day02._1RESTparam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    // -> queryString 매개변수명 과 함수 매개변수명과 동일하면 하면  @RequestParam 생략해도 된다.
    // 2. ( defaultValue = "홍길동" ) 타입 매개변수명
    // -> 만약에 queryString 매핑할 매개변수명이 존재하지 않으면 기본값 설정
    // 3. ( required = true )
    // -> 기본값이 true 하며 , 쿼리스트링 매개변수 필수 여부 설정 , 만약에 쿼리스트링 매개변수가 없으면 400(bad request잘못된요청) 응답 , defaultValue 없이 사용.

    @GetMapping("/doget2") // [GET] http://localhost:8080/day02/doget2?name=유재석
    // 3. ( required = "홍길동" )
    public boolean method2( @RequestParam(name = "name" , defaultValue = "홍길동" , required = true ) String name ){ // 매핑함수의 매개변수를 자동으로 쿼리스트링의 매개변수를 매핑/연결 한다.
        System.out.println("RestController3.method2");
        System.out.println("name = " + name); // soutp 자동완성 : 현재 함수의 매개변수 출력함수.
        return true; // @ResponseBody 사용했을때 자동으로 response 를 'application/json' 타입으로 응답한다.
    } // f end

} // c end






