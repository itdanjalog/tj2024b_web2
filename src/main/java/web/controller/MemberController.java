package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController // @ResponseBody 포함하며 restApi 지원하는 컨트롤러 빈 등록
@RequestMapping("/api/member") // 클래스내 http 매핑 주소의 공통 url 정의 할때 사용.
// -> 개발하는 사람들이 페이지 매핑과 REST 매핑 구분하기 위한 방법
// 1. 페이지 url : - /member/signup
// 2. REST url : 1. /member/signup.do : 뒤에 do를 붙이는경우( 관례 : 과거)
//               2. /api/member/signup : 앞에 api 붙이는경우( 관례 : 최근)
@RequiredArgsConstructor // final 멤버변수에 대해서 생성자를 자동으로 지원한다.
// final 필드에 대해서 자동으로 생성자를 지원하므로 @Autowired 주입 생략 해도 된다.
public class MemberController {

    private final MemberService memberService;

    // [1] 회원가입
    // [POST] http://localhost:8080/api/member/signup
    // Content-Type : application/json
    // body : { "mid" : "qwe" , "mpwd":"1234" , "mname":"유재석" }
    @PostMapping("/signup")
    public boolean sigunUp( @RequestBody MemberDto memberDto ){
        System.out.println("MemberController.sigunUp");
        System.out.println("memberDto = " + memberDto);
        //return false;
        boolean result = memberService.sigunUp( memberDto );
        System.out.println("result = " + result);
        return result;
    }

}











