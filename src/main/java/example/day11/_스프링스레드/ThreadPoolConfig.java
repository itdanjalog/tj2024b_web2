package example.day11._스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// ================ 스프링에 내장된 스레드풀을 커스텀/설정 클래스 ================ //
@Configuration // Spring 에서 설정 클래스 빈(bean) 등록
public class ThreadPoolConfig {
    // [1] 스레드풀 커스텀 메소드
    @Bean // 해당 메소드를 스프링 컨테이너에 빈 등록
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); // 스레드풀 객체
        executor.setCorePoolSize( 2 ); // 기본 실행 스레드 개수 설정
        executor.setMaxPoolSize( 2 ); // 최대 실행 스레드 개수 설정
        executor.setQueueCapacity( 10 ); // 대기 개수 설정 , 대기상태가 넘치면 503[오류]
        executor.initialize(); // 스레드풀 초기화
        return executor; // 설정한 스레드풀 객체 반환
    }
}
