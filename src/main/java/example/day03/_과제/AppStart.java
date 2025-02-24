package example.day03._과제;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링*부트* 실행 위한 관련된 설정 주입
public class AppStart {
    public static void main(String[] args) { // main 스레드 포함
        // 스프링 실행
        SpringApplication.run( AppStart.class );
    }
} // class end
