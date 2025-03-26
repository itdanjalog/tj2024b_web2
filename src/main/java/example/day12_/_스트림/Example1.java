package example.day12_._스트림;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {

        // 컬렉션 데이터 생성
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. 스트림 기본 구조
        // 스트림 생성 및 출력
        numbers.stream()  // 스트림 생성
                .forEach(System.out::println);  // 각 요소 출력

        // 2. 스트림의 기본 연산 - filter() (조건에 맞는 데이터 필터링)
        // 스트림 생성 및 짝수만 필터링
        numbers.stream()  // 스트림 생성
                .filter(x -> x % 2 == 0)  // 짝수만 필터링
                .forEach(System.out::println);  // 출력

        // 3. map() (각 요소 변환)
        // 스트림 생성 및 숫자 두 배로 변환
        numbers.stream()  // 스트림 생성
                .map(x -> x * 2)  // 두 배로 변환
                .forEach(System.out::println);  // 출력

        // 4.reduce() (모든 요소 결합 - 집계 연산)
        // 스트림 생성 및 합 계산
        int sum = numbers.stream()  // 스트림 생성
                .reduce(0, (a, b) -> a + b);  // 모든 요소를 더함
        System.out.println("합: " + sum);  // 출력

        // 5. collect() (스트림 결과를 컬렉션으로 변환)
        // 스트림 생성 및 짝수만 필터링하여 새로운 리스트로 수집
        List<Integer> evenNumbers = numbers.stream()  // 스트림 생성
                .filter(x -> x % 2 == 0)  // 짝수만 필터링
                .collect(Collectors.toList());  // 리스트로 수집
        System.out.println(evenNumbers);  // 출력

        // 6. sorted() (정렬)
        // 스트림 생성 및 정렬
        numbers.stream()  // 스트림 생성
                .sorted()  // 오름차순 정렬
                .forEach(System.out::println);  // 출력

        // 7.anyMatch(), allMatch(), noneMatch() (조건에 맞는 요소 존재 여부 확인)
        // anyMatch: 하나라도 조건을 만족하면 true
        boolean anyMatch = numbers.stream()
                .anyMatch(x -> x > 3);  // 3보다 큰 숫자가 있으면 true
        System.out.println("anyMatch(3보다 큰 값이 있나?): " + anyMatch);  // true

        // allMatch: 모든 요소가 조건을 만족해야 true
        boolean allMatch = numbers.stream()
                .allMatch(x -> x > 0);  // 모든 숫자가 0보다 크면 true
        System.out.println("allMatch(모든 값이 0보다 큰가?): " + allMatch);  // true

        // noneMatch: 모든 요소가 조건을 만족하지 않으면 true
        boolean noneMatch = numbers.stream()
                .noneMatch(x -> x < 0);  // 모든 숫자가 음수가 아니면 true
        System.out.println("noneMatch(모든 값이 음수가 아닌가?): " + noneMatch);  // true

        // 8. 병렬 스트림 사용하기
        // 병렬 스트림을 사용하여 처리
        numbers.parallelStream()  // 병렬 스트림 생성
                .forEach(System.out::println);  // 각 요소 출력




    }
}
