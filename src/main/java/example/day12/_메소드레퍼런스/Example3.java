package example.day12._메소드레퍼런스;

import java.util.List;
import java.util.function.Supplier;

class Person{
    String name; // 멤버변수
    public Person(){} // 기본생성자
    public Person( String name ){ this.name = name; } // 매개변수1개 생성자
    // 일반 메소드
    public void onMessage1( String message ) {
        System.out.println( message );
    }
    // static 메소드
    public static void onMessage2( String message ){
        System.out.println( message );
    }
} // c end


public class Example3 {
    public static void main(String[] args) {
        // * 임의의 컬렉션
        List< String > names = List.of( "유재석" , "강호동" , "신동엽 ");

        // 1. static 메소드 참조
            // (1) 일반적인 방법
        names.forEach( ( name ) -> { Person.onMessage2( name ); } );
            // (2) 메소드 레퍼런스 방법 , ::(콜론2개)
                // forEach 매개변수 와 static메소드의 매개변수 일치
                // 클래스명::static메소드명
        names.forEach( Person::onMessage2 );

        // 2. 생성자 참조
            // (1) 일반적인 방법
        names.forEach( (name) -> { new Person(name); } );
            // (2) 생성자 레퍼런스 방법 ,
                // forEach 매개변수 와 생성자 매개변수 일치
                // 클래스명::new
        names.forEach( Person::new );

        // 3. 일반 메소드 참조
            // 객체명::메소드명
        Person person1 = new Person();
        names.forEach( person1::onMessage1 );

        // 4. 주의할점 , :: 메소드레퍼런스 , 람다 표현식 간결
        // Person person2 = Person::new;
        Supplier<Person> ref = Person::new;
        Person person = ref.get();
            // vs
        Supplier<Person> ref2 = ( ) -> new Person();
        Person person2 = ref2.get();

    }
}














