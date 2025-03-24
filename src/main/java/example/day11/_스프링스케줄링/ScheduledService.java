package example.day11._스프링스케줄링;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ScheduledService {

    // 3초마다 실행 (fixedRate: 실행 시작 시점부터 다음 실행까지의 간격)
    @Scheduled(fixedRate = 3000)
    public void task1() {
        System.out.println("[fixedRate] 현재 시간: " + LocalTime.now());
    }

    // 5초마다 실행 (fixedDelay: 실행 종료 후 대기 시간 후에 실행)
    @Scheduled(fixedDelay = 5000)
    public void task2() {
        System.out.println("[fixedDelay] 현재 시간: " + LocalTime.now());
    }

    // 매 분 0초마다 실행 (cron 표현식 사용)
    @Scheduled(cron = "0 * * * * *")
    public void cronTask() {
        System.out.println("[cron] 매 분 0초마다 실행! 현재 시간: " + LocalTime.now());
    }

    // ========================== //
    @Scheduled(cron = "0 0 9 * * ?")
    public void runEveryMorning() {
        System.out.println("매일 아침 9시 실행!");
    }

    @Scheduled(cron = "0 0 10 1 * ?")
    public void runOnFirstDayOfMonth() {
        System.out.println("매월 1일 오전 10시 실행!");
    }

    @Scheduled(cron = "0 30 8 ? * MON")
    public void runEveryMonday() {
        System.out.println("매주 월요일 오전 8시 30분 실행!");
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void runEvery5Seconds() {
        System.out.println("5초마다 실행!");
    }

    @Scheduled(cron = "0 0 10 ? * SAT,SUN")
    public void runOnWeekend() {
        System.out.println("주말 오전 10시에 실행!");
    }


}