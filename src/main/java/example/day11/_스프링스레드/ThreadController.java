package example.day11._스프링스레드;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/day11/thread")
@RequiredArgsConstructor
public class ThreadController {
    private final ThreadService threadService;
    @GetMapping("/start1")
    public void thread1(){
        System.out.println("ThreadController.thread1");
        threadService.playBeepSound( UUID.randomUUID().toString() );
    }
    @GetMapping("/start2")
    public void thread2(){
        System.out.println("ThreadController.thread2");
        threadService.playBeepSound2( UUID.randomUUID().toString() );
    }
    @GetMapping("/start3")
    public void thread3(){
        System.out.println("ThreadController.thread2");
        threadService.playBeepSound3( UUID.randomUUID().toString() );
    }
}
