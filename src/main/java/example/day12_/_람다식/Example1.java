package example.day12._람다식;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Calculator{ // 인터페이스 // 주로 추상메소드( 선언부가 없는 함수 )
    // 더하기 추상메소드 정의
    int plus( int x , int y); // 추상메소드
}
public class Example1 { // 클래스
    // 더하기 메소드 정의
    public static int plus( int x , int y ){
        return x + y;
    }
    public static void main(String[] args) {
        // 1. 일반메소드 호출
        int result = plus( 3 , 5 );
        System.out.println( result );

        // 2. (인터페이스) 추상메소드 호출 , 구현이 필요하다 (1) implements (2) 익명객체
            // - Calculator calc = new Calculator(); : 인터페이스는 객체 생성를 못한다.
            // -> 이름없는 객체로 추상화를 구현한다. -> 익명(객)체 ,  Calculator calc = new Calculator(){ 구현 };
        //Calculator calc = new Calculator(){ 오버라이딩 }; // <--- {} (1회성 구현) 객체
        Calculator calc = new Calculator(){
            @Override
            public int plus(int x, int y) {
                return x + y ;
            }
        };
        int result2 = calc.plus( 3 , 5 );
        System.out.println( result2 );

        // 3. (인터페이스) 추상메소드를 람다 표현식으로 호출 -> , JS( 화살표함수비슷 => )
        Calculator calc3 = ( x , y) -> x + y ;
        int result3 = calc3.plus( 3 , 5 );
        System.out.println( result3 );

        // 4. 람다표현식을 제공하는 타입 ,
        // Function< 매개변수타입 , 리턴값타입 > , .apply( 인자값 )
        Function< Integer , Integer > function = x -> x * 2;
        System.out.println( function.apply( 3 ) ); // 3 ---> x : 3*2
        System.out.println( function.apply( 7 ) ); // 7 ---> x : 7*2

        // Predicate< 매개변수타입 > , 실행결과 true 또는 false 반환 , .test( 인자값 )
        Predicate< Integer > predicate = x -> x % 2 == 0;
        System.out.println( predicate.test( 3 ) ) ; // 3 ---> x : 3 % 2 == 0  false
        System.out.println( predicate.test( 4 ) ) ; // 4 ---> x : 4 % 2 == 0  true

        // Supplier< 리턴값타입 > , .get()
        Supplier< Double > supplier = ( ) -> Math.random();
        System.out.println( supplier.get() ); // 인자값x , 난수값 반환

        // Consumer< 매개변수타입 > , .accept( 인자값 )
        Consumer< String > consumer = str -> System.out.println( str );
        consumer.accept( "안녕하세요.");

        // 5. 주로 컬렉션 프레임워크와 같이 사용된다. , 리스트명.forEach( Consumer< 매개변수타입 > )
        List< String > 과일목록 = new ArrayList<>();
        과일목록.add( "사과 "); 과일목록.add( "바나나" ); 과일목록.add("수박");

        // 리스트명.forEach( ( 매개변수 ) -> { 실행코드; } );
        과일목록.forEach( ( 과일 ) -> { System.out.println( "과일명 : " +  과일 ); } );

    } // f end
} // c end







