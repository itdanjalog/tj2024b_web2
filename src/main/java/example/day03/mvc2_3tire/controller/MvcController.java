package example.day03.mvc2_3tire.controller;

import example.day03.mvc2_3tire.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController // MVC 패턴의 controller 임을 알리는 어노테이션 ,
// * 스프링 컨테이너(메모리) 등록 함으로써 스프링이 (자동/알아서) 컨트롤러 제어한다. [ IOC ]
public class MvcController {

    // [1] 필드에 빈 주입
    // 필드에 스프링 컨테이너(메모리) 등록된 빈(객체/인스턴스 생성) 주입 어노테이션
    @Autowired MvcService mvcService ;

}
