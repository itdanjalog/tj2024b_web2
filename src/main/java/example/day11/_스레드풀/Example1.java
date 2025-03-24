package example.day11._스레드풀;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            Thread thread = new Thread(() -> {
                System.out.println("작업 " + taskId + " 실행 중... " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 작업 시뮬레이션
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
         // new Thread()를 매번 새로 생성하여 실행
        //
        //단점: 스레드가 매번 새로 생성되므로 자원 낭비 발생
        //
        //단점: 스레드가 많아지면 성능 저하


        // 스레드풀 생성 (고정 크기 3)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 작업 제출
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("작업 " + taskId + " 실행 중... " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 작업 시뮬레이션
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 작업이 끝나면 스레드풀 종료
        executor.shutdown();
        // Executors.newFixedThreadPool(3): 스레드 3개짜리 풀 생성
        //
        //executor.submit(): 스레드풀에 작업 제출
        //
        //executor.shutdown(): 모든 작업 종료 후 스레드풀 종료


        // 비교 항목         스레드풀 없음	                스레드풀 있음
        //스레드 개수	        작업마다 새 스레드 생성	        제한된 개수의 스레드 재사용
        //자원 사용	        비효율적 (메모리 낭비)	        효율적 (자원 절약)
        //성능	            작업 개수가 많으면 성능 저하	일정한 성능 유지
        //관리	            직접 관리 필요	            ExecutorService가 관리
        // 결론: 대량의 작업이 있는 경우 스레드풀을 사용하면 더 효율적!
    }
}
