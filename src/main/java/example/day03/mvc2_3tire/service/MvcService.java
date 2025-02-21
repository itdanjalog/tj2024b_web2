package example.day03.mvc2_3tire.service;

import example.day03.mvc2_3tire.controller.MvcController;
import example.day03.mvc2_3tire.model.repository.MvcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // MVC 패턴의 service 임을 알리는 어노테이션
// * 스프링 컨테이너(메모리) 등록 함으로써 스프링이 (자동/알아서) 서비스 제어한다. [IOC]
public class MvcService {

    // 순환참조 조심하자.
    // @Autowired MvcController mvcController;

    // controller --> service --> repository 구조

    // [2] (디폴트)생성자에 빈 주입
    final MvcRepository mvcRepository;

    @Autowired
    public MvcService( MvcRepository mvcRepository ){
        this.mvcRepository = mvcRepository;
    }

}





