package example.day02._2의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SampleService3{
    public void method(){
        System.out.println("SampleService3.method");
    }
}

class SampleController3{
    @Autowired
    private SampleService3 sampleService3;

    public void method(){
        sampleService3.method();
    }
}

public class Example3 { }
/*
📌 결론
👉 필드 주입보다는 생성자 주입을 사용하자!
👉 스프링에서 생성자 주입은 가장 권장되는 방식! 🚀
 */
