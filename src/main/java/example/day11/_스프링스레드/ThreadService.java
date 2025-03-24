package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class ThreadService {
    @Async // 별도 스레드에서 실행됨
    public void playBeepSound( String uuid ) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(uuid  + " : 비프음!  - " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Async // 별도 스레드에서 실행됨
    public synchronized void playBeepSound2( String uuid ) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(uuid  + " : 비프음!  - " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async("beepExecutor") // 위에서 설정한 스레드풀 사용
    public void playBeepSound3(String uuid  ){
        for (int i = 1; i <= 10; i++) {
            System.out.println(uuid  + " : 비프음!  - " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
