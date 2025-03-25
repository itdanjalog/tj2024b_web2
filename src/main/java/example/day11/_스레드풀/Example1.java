package example.day11._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

    // * main함수 안에 main스레드(코드를 읽어드리는 역할) 내장
    public static void main(String[] args) {
        System.out.println(" ==> [1] 반복문 이용하여 반복문 횟수만큼 작업 스레드 생성하여 실행 ");
        // [1] 반복문 이용하여 반복문 횟수만큼 작업 스레드 생성하여 실행
        for( int i = 1 ; i <= 10 ; i++ ){
            // (1) 작업 스레드 생성 , Thread thread = new Thread( new 인터페이스명(){ 추상메소드구현 });
            String name = "thread "+i;
            Thread thread = new Thread( new Runnable(){
                @Override
                public void run() {
                    try {  Thread.sleep(1500); } // 1.5초 스레드 일시정지 , Thread.sleep(밀리초)
                    catch (Exception e ){  System.out.println(e);  }
                    System.out.println("작업 스레드 : 실행중 " + name );
                }
            } ); // 작업 스레드 정의 end
            // (2) 작업 스레드 실행
            thread.start(); // 여라 작업 스레드간의 실행순서 보장 안된다.
        }
        System.out.println(" ==> [2] 반복문 이용하여 반복문 횟수만큼 지정된 작업 스레드에 배정하여 실행 , 스레드풀 ");
        // [2] 반복문 이용하여 반복문 횟수만큼 지정된 작업 스레드에 배정하여 실행 , 스레드풀
            // (1) 스레드풀 생성 ( 고정된 스레드 개수 ) , Executors.newFixedThreadPool(고정개수);
        ExecutorService executorService = Executors.newFixedThreadPool( 3 );
            // (2) 반복문
        for( int i = 1 ; i<= 10 ; i++ ){
            String name = "thread "+i;
            // (3) 새로운 스레드가 아닌 스레드풀에 정의한 스레드를 등록한다., .submit( 등록할스레드인터페이스 );
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    // 위 예제 코드 복사
                    try {  Thread.sleep(2000); } // 2초 스레드 일시정지 , Thread.sleep(밀리초)
                    catch (Exception e ){  System.out.println(e);  }
                    System.out.println("작업 스레드 : 실행중 " + name );
                }
            });
        }
        // (4) 스레드풀 종료 , .shutdown();
        executorService.shutdown();



    } // m end
} // c end
