package example.day02._2의존성;

class SampleService1{
    public void method(){
        System.out.println("SampleService1.method");
    }
}

class SampleController1{

    public void method(){
        SampleService1 sampleService1 = new SampleService1();
        sampleService1.method();
    }

}

public class Example1 { }

/*
👉 "스프링 없이 객체를 직접 생성하면 강한 결합(Tight Coupling)으로 인해 유지보수가 어려워진다!"
👉 "스프링의 @Component 와 @Autowired 를 활용해 의존성 주입(DI)하면 유지보수성과 확장성이 증가한다!" 🚀

 */