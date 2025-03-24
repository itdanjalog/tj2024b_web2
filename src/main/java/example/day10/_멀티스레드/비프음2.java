package example.day10._멀티스레드;

import java.awt.*;

public class 비프음2 extends Thread {

    @Override // 상속된 메소드 재정의
    public void run() {
        // 앞 예제에서 코드 복사
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep(); // 비프음
            try{ Thread.sleep( 1000 ); }
            catch (Exception e ){
                System.out.println(e);
            }
        }
    } // f end
} // c end
