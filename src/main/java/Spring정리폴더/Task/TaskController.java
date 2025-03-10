package Spring정리폴더.Task;

/*
    조과제 :
    1. TaskController 에서 TaskService의 'method1' 메소드를 호출하는 방법
    2. 최소 6개 이상 방법 찾기

*/

public class TaskController {

    void method1(){
        // (1) (변수x) 일회성
        new TaskService().method1();

        // (2) (변수o) 다회성
        TaskService taskService = new TaskService();
        taskService.method1();

        // (3) static 메소드
        TaskService.method2();

        // (4) 싱글톤 , 메소드 

        // (5) 인터페이스 구현체 ( 오버라이딩 )

        // (6)~(8) DI , IOC  @Autowired
    }
}
