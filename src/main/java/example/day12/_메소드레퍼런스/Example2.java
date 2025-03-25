package example.day12._메소드레퍼런스;

import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@ToString
class Student {
    String name;
    int age;

    // 기본 생성자
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // 18세 이상인 사람을 반환하는 정적 메소드
    public static boolean isAdult(Student s) {
        return s.age >= 18;
    }

}

public class Example2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("유재석", 45),
                new Student("강호동", 50),
                new Student("신동엽", 17),
                new Student("박명수", 30)
        );


        // 18세 이상인 사람들만 students
        List<Student> adults = students.stream()
                .filter( Student::isAdult) // isAdult 정적 메소드 참조
                .collect(Collectors.toList());

        adults.forEach(System.out::println); // 성인들만 출력

        // 나이 오름차순 정렬
        List<Student> sortedByAge = students.stream()
                .sorted((s1, s2) -> Integer.compare(s1.age, s2.age)) // 나이 오름차순 정렬
                .collect(Collectors.toList());

        sortedByAge.forEach(System.out::println);

        // 총 나이 합산
        int totalAge = students.stream()
                .map(s -> s.age) // 나이만 추출
                .reduce(0, Integer::sum); // 나이 합산

        System.out.println("Total Age: " + totalAge);

        // 가장 나이가 많은 학생
        Student oldest = students.stream()
                .max(Comparator.comparingInt(s -> s.age))  // 나이가 많은 학생 찾기
                .orElse(null);

        System.out.println("Oldest Student: " + oldest);

    // 가장 나이가 적은 학생
        Student youngest = students.stream()
                .min(Comparator.comparingInt(s -> s.age))  // 나이가 적은 학생 찾기
                .orElse(null);

        System.out.println("Youngest Student: " + youngest);
    }
}