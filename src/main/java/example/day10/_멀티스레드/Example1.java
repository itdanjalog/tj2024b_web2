package example.day10._멀티스레드;

import java.awt.*;

public class Example1 {
    // 1. main함수는 main스레드 를 포함하며 코드를 첫 시작한다.
    public static void main(String[] args) {
        System.out.println("(1) main스레드가 읽어드리는 코드");

        // 2. main 함수 안에서 작성된 코드는 모두 main스레드 가 읽어드린다.
        for( int i = 1 ; i <= 5 ; i++ ){
            System.out.println("(2) main스레드가 읽어드리는 코드 " + i );
        } // f end

        // 3. ================================== 싱글 스레드 ================================= //
        System.out.println("========================= 싱글 스레드 시작 ======================== ");
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // java ui 제공하는 패키지 ( java.awt )
        // 3-1 소리 5번 발생
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep(); // 비프음( '띵' ) 발생
            // * 스레드 일시정지
            try {  Thread.sleep(1000); // Thread.sleep( 밀리초 ) ; 예외발생
            }catch (Exception e ){  System.out.println( e );  }
        }
        // 3-2 출력 5번 발생
        for( int i = 1 ; i <= 5 ; i++ ){
            System.out.println("띵");
            try{ Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println( e ); }
        }
        // 4. ================================== 멀티 스레드 (1) 익명 객체 ================================== //
        System.out.println("========================= 멀티 스레드 시작 ======================== ");
        // 4-1 : 소리 5번 발생 , 작업스레드 정의
        Thread thread = new Thread( new Runnable() {
            @Override
            public void run() { // 추상메소드 // 오버라이딩 // 재정의
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for( int i = 1 ; i <= 5 ; i++ ){
                    toolkit.beep(); // 비프음
                    try{ Thread.sleep( 1000 ); }
                    catch (Exception e ){  System.out.println(e);  }
                }
            }
        });
        // 작업스레드 실행
        thread.start();
        // 4-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ){
            System.out.println("띵");
            try{ Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println( e ); }
        }

        // 5. ================================== 멀티 스레드 (2) 구현 객체 ================================== //
        System.out.println("========================= 멀티 스레드 시작 ======================== ");
        // 5-1 : 소리 5번 발생 , 작업스레드 정의
        비프음1 비프음1 = new 비프음1();
        Thread 비프음스레드1 = new Thread( 비프음1 );
        비프음스레드1.start();
        // 5-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ){
            System.out.println("띵");
            try{ Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println( e ); }
        }

        // 6. ================================== 멀티 스레드 (3) 상속 객체 ================================== //
        System.out.println("========================= 멀티 스레드 시작 ======================== ");
        // 6-1 : 소리 5번 발생 , 작업스레드 정의
        비프음2 비프음2 = new 비프음2();
        비프음2.start();

        // 6-2 : 출력 5번 발생 , (위 예제 코드 복사해오기.)
        for( int i = 1 ; i <= 5 ; i++ ){
            System.out.println("띵");
            try{ Thread.sleep( 1000 );}
            catch ( Exception e ){  System.out.println( e ); }
        }
    } // m end
} // c end


















