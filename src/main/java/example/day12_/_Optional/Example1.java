package example.day12_._Optional;

import java.util.Optional;

public class Example1 {
    public static void main(String[] args) {
        // 1. Optional 객체 생성
        Optional<String> optionalStr1 = Optional.of("Hello, World!");  // 값이 있을 때
        Optional<String> optionalStr2 = Optional.ofNullable(null);  // null일 수 있을 때
        Optional<String> optionalStr3 = Optional.empty();  // 값이 없을 때

        // 2. 값 존재 여부 확인 (isPresent, isEmpty)
        System.out.println("optionalStr1.isPresent(): " + optionalStr1.isPresent()); // true
        System.out.println("optionalStr2.isPresent(): " + optionalStr2.isPresent()); // false
        System.out.println("optionalStr3.isEmpty(): " + optionalStr3.isEmpty()); // true

        // 3. 값이 존재하면 값을 반환하고, 없으면 기본값을 반환 (orElse)
        String result1 = optionalStr1.orElse("Default Value");
        String result2 = optionalStr2.orElse("Default Value");
        System.out.println("result1: " + result1); // "Hello, World!"
        System.out.println("result2: " + result2); // "Default Value"

        // 4. 값이 존재하면 반환하고, 없으면 예외를 던짐 (orElseThrow)
        try {
            String result3 = optionalStr2.orElseThrow(() -> new IllegalArgumentException("값이 없습니다!")); //이리걸 아규먼트 익셉션 // 개발자가 메소드나 생성자에 잘못된 인자를 전달했을 때 발생
            System.out.println("result3: " + result3);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage()); // "값이 없습니다!"
        }

        // 5. 값이 존재하면 값에 대해 작업 (ifPresent)
        optionalStr1.ifPresent(value -> System.out.println("값이 존재합니다: " + value)); // 값이 존재하면 실행
        optionalStr2.ifPresent(value -> System.out.println("값이 존재합니다: " + value)); // 값이 없으므로 실행되지 않음

        // 6. Optional의 값을 반환 (get)
        try {
            String value = optionalStr1.get();  // 값이 존재하므로 정상 반환
            System.out.println("optionalStr1.get(): " + value); // "Hello, World!"
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 7. 값이 null인 경우, 다른 값을 반환 (람다식 사용)
        Optional<String> upperCaseStr = optionalStr1.map(str -> str.toUpperCase());  // 람다식을 사용하여 대문자로 변환
        System.out.println("upperCaseStr: " + upperCaseStr.orElse("값 없음")); // "HELLO, WORLD!" 출력

        // 8. 값이 null인 경우 처리 (flatMap)
        Optional<String> flatMappedStr = optionalStr2.flatMap(s -> Optional.of(s.toUpperCase()));
        System.out.println("flatMappedStr: " + flatMappedStr.orElse("값 없음")); // "값 없음"
    }
}
