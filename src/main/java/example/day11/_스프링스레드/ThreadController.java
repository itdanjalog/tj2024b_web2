package example.day11._스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 스프링MVC 에서 rest ontroller
@RequestMapping("/day11/thread")// 공통 url
@RequiredArgsConstructor // final 필드 생성자 초기화
public class ThreadController {
    private final ThreadService threadService;
    // (1) 비동기 = 기본값
    @GetMapping("/start1") // http://localhost:8080/day11/thread/start1
    public void thread1(){
        System.out.println("ThreadController.thread1"); // soutm
        threadService.thread1();
    }
    // (2) 동기
    @GetMapping("/start2") // http://localhost:8080/day11/thread/start2
    public void thread2(){
        System.out.println("ThreadController.thread2");
        threadService.thread2();
    }
}











