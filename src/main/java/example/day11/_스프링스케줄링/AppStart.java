package example.day11._스프링스케줄링;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // [1] AppStart 클래스 위에 '@EnableScheduling' 활성화
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run( AppStart.class );
    }
}
