package example.day11._스프링스레드;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // 스프링MVC 에서 Service
public class ThreadService {
    // (1) 비동기 , +스레드풀 자동 적용
    @Async // [2] 멀티스레드를 적용할 메소드 위에 @Async
    public void thread1(){
        String name = UUID.randomUUID().toString() ; // 구분용
        for( int i = 1; i<=10 ; i++ ){
            System.out.println( i+" 작업스레드 : "+name);
            try{ Thread.sleep(1000); }
            catch (Exception e){ System.out.println(e);}
        }
    }
    // (2) 동기 , synchronized  , +스레드풀 자동 적용
    @Async
    public synchronized void thread2(){
        //위 예시 코드 복사
        String name = UUID.randomUUID().toString() ;
        for( int i = 1; i<=10 ; i++ ){
            System.out.println( i+" 작업스레드 : "+name);
            try{ Thread.sleep(1000); }
            catch (Exception e){ System.out.println(e);}
        }
    }
}









