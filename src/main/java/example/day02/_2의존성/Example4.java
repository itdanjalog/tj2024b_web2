package example.day02._2의존성;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SampleService4{
    public void method(){
        System.out.println("SampleService4.method");
    }
}

class SampleController4{

    private final SampleService4 sampleService4;

    @Autowired // 최신 spring 4.x 이상부터.생략 가능.
    public SampleController4(SampleService4 sampleService4){
        this.sampleService4 = sampleService4;
    }

    public void method(){
        sampleService4.method();
    }

}

public class Example4 { }
/*
📌 결론
👉 생성자 주입을 권장! (특히, 필드가 final이면 더 안정적인 코드 작성 가능)
👉 테스트 및 유지보수하기 좋은 코드가 됨! 🚀

✅ 의존성 명확함 → 생성자를 통해 의존성을 주입받으므로, 어떤 객체가 필요한지 한눈에 보임
✅ 테스트 가능 → Mock 객체를 생성자 주입으로 쉽게 교체 가능
✅ 불변성 유지 가능 → final 키워드 추가 가능 → 의존성이 바뀌지 않도록 보호
✅ 순환 의존성 감지 가능 → 빌드 시점에서 에러를 감지할 수 있음


 */
