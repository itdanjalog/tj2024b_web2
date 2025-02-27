package example.day06._aop과제.controller;

import example.day06._aop과제.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day06/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // [1] 학생 점수 등록
    @PostMapping("")
    public int save( @RequestBody Map<String,Object> map ){
        return taskService.save( map );
    }
    // [2] 학생 전체 조회
    @GetMapping("")
    public List<Map<String,Object>> findAll(){
        return taskService.findAll();
    }
}
