package example.day03.mvc2_3tire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// * 현재 클래스와 동일패키지 와 하위패키지 들의 컴포넌트 들을 스캔한다.
// 컴포넌트(모듈/레고조각)란? MVC패턴의 계층 클래스들
// @Component 또는 포함된 : @RestController @Controller @Service @Repository @Configuration @Mapper 등등
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class);
    }
}













