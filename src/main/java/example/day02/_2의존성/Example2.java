package example.day02._2의존성;

import org.springframework.stereotype.Component;

@Component
class SampleService2{
    private static final SampleService2 instance = new SampleService2();
    private SampleService2(){  }
    public static SampleService2 getInstance(){ return instance; }

    public void method(){
        System.out.println("SampleService2.method");
    }
}

class SampleController2{
    public void method(){
        SampleService2.getInstance().method();
    }
}

public class Example2 { }
/*
👉 직접 싱글톤을 구현하는 방식보다는, 스프링 컨테이너의 싱글톤 관리 기능을 활용하는 것이 더 좋다.
✅ 싱글톤이 필요하다면 스프링의 @Component와 @Service를 활용해 컨테이너에서 관리하는 것이 바람직함!
✅ 테스트 가능하고, 유지보수가 쉬운 생성자 주입 방식이 권장됨!
 */
