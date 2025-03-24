package example.day11._스프링스레드;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class ThreadPoolConfig {

    @Bean(name = "beepExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // 기본 실행 스레드 개수
        executor.setMaxPoolSize(3);  // 최대 실행 스레드 개수
        executor.setQueueCapacity(10); // 대기 큐 크기
        executor.setThreadNamePrefix("CustomThread-"); // 스레드 이름 설정
        executor.initialize();
        return executor;
    }
}
