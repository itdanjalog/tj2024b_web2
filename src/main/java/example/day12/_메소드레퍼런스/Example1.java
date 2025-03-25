package example.day12._메소드레퍼런스;


import java.util.Arrays;
import java.util.List;
class Person {
    String name;
    public  Person(){}
    // 생성자
    public Person(String name) {
        this.name = name;
        System.out.println("Person created: " + name);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public  void printMessage2(String message) {
        System.out.println(message);
    }

}

public class Example1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("유재석", "강호동", "신동엽");

        // 1. 정적 메소드 참조
        // 메소드 레퍼런스
        names.forEach(Person::printMessage);
        
        // 2. 인스턴스 메소드 참조
        Person p = new Person();
        // 메소드 레퍼런스
        names.forEach( p ::printMessage2);
        
        // 3. 생성자 참조
        // 생성자 메소드 레퍼런스
        names.forEach(Person::new);
    }
}
