package example.day06.aop;

// ======================= AOP 없이 구현된 코드 ================== //
class TestService{
    //메소드1
    public void enter1(){
        System.out.println("(보안) [코로나] 열 체크 ");         // (1) 부가기능
        System.out.println("식당 입장");                      // (2) 비지니스 로직
    }
    //메소드2
    public void enter2(){
        System.out.println("(보안) [코로나] 열 체크 ");         // (1) 부가기능
        System.out.println("학원 입장");                       // (2) 비지니스 로직
    }
} // class end
public class Example1 {
    public static void main(String[] args) {
        TestService testService = new TestService();
        testService.enter1();
        testService.enter2();
        // 단점 : 유지보수 복잡하다. 하나의 메소드 에서 부가기능이 바뀌면 다른 메소드에서도 수정해야한다.
    }
}
