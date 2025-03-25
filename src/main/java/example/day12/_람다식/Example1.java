package example.day12._람다식;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface 계산기 {
    int 실행(int x);
}
interface 더하기 {
    int 실행(int a, int b);
}


public class Example1 {
    public static int 두배(int x) {
        return x * 2;
    }

    public static void main(String[] args) {
        // 1.일반함수
        System.out.println(두배(5)); // 10 출력

        //2. 익명객체
        계산기 두배 = new 계산기() {
            @Override
            public int 실행(int x) {
                return x * 2;
            }
        };
        System.out.println(두배.실행(5)); // 10 출력
        //1. 람다함수 예제
        계산기 두배2 = x -> x * 2;
        System.out.println(두배2.실행(5)); // 10 출력
        //2. 람다함수 예제
        더하기 sum = (a, b) -> a + b;
        System.out.println(sum.실행(3, 7)); // 10 출력
        //3. 람다함수 예제
        Function<Integer, Integer> 두배3 = x -> x * 2; // unction<T, R>은 입력(T)을 받아서 결과(R)를 반환하는 함수형 인터페이스예요.
        System.out.println(두배3.apply(5)); // 10 출력
        //4. 람다함수 예제
        Predicate<Integer> 짝수확인 = x -> x % 2 == 0; // Predicate<T>는 참(True) 또는 거짓(False)을 반환하는 함수형 인터페이스예요.
        System.out.println(짝수확인.test(4)); // true 출력
        System.out.println(짝수확인.test(7)); // false 출력

        Consumer<String> 출력 = str -> System.out.println("출력: " + str);
        출력.accept("Hello Lambda!");

        Supplier<Double> 랜덤값 = () -> Math.random();
        System.out.println(랜덤값.get()); // 0.xxxx 형태의 랜덤 값 출력


        //5. 람다함수 예제
        List<String> 과일 = Arrays.asList("사과", "바나나", "수박");
        과일.forEach(fruit -> System.out.println("과일: " + fruit));
        //6. 람다함수 예제
        Runnable task = () -> System.out.println("스레드 실행 중..."); // Runnable 인터페이스를 람다식으로 구현하여 스레드 실행
        new Thread(task).start();


    }
}
