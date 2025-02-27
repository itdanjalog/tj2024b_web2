package example.day06.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Aspect
@Component
class Security{
    @Before("execution( * TestService2.*(..) )")
    public void securityCheck(){
        System.out.println("(보안) [코로나] 열  체크  + 자기진단 ");
    }
} // class end

@Service
class TestService2{
    //메소드1
    public void enter1(){
        // 부가기능 제외한 상태  //new Security().securityCheck();// [1]. 일반적인 코드 재사용 방법
        System.out.println("식당 입장"); // 비지니스
    }
    //메소드2
    public void enter2(){
        // 부가기능 제외한 상태 //new Security().securityCheck();// [1]. 일반적인 코드 재사용 방법
        System.out.println("학원 입장"); // 비지니스
    }
} // class end

@RestController
class TestController2{
    @Autowired private TestService2 testService2;
    @GetMapping("/day06/aop")
    public void aop( ){
        testService2.enter1();
        testService2.enter2();
    }
}

@SpringBootApplication
public class Example2 {
    public static void main(String[] args) {
        SpringApplication.run( Example2.class );
    }
}
