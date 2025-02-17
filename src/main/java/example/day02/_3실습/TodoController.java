package example.day02._3실습;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // [2] student 학생점수등록 페이지를 매핑/연결 하는 URL 주소 정의/만들기
    @PostMapping("/regist") // http://localhost:8080/student/regist // {"name" : "강호동" , "point" : "100" }
    public boolean regist( @RequestBody StudentDto studentDto ){
        return todoService.regist(studentDto);
    }
    // [3] student 전체 학생 점수 조회 페이지
    @GetMapping("/list")  // http://localhost:8080/student/list
    public List<StudentDto> list( ){
         return todoService.list();
    }
    @GetMapping("/view") // http://localhost:8080/student/view?id=1
    public StudentDto view( @RequestParam int id ){
        return todoService.view(id);
    }

    // [4] student 점수 수정 페이지
    @PutMapping("/update") // http://localhost:8080/student/update // { "id" : "1" , "name" : "유재석2" , "point" : "50" }
    public boolean update( @RequestBody StudentDto studentDto ){
        return todoService.update(studentDto);
    }

    // [5] student 점수 삭제 페이지
    @DeleteMapping("/delete") // http://localhost:8080/student/delete?id=1
    public boolean delete( @RequestParam int id ){
        return todoService.delete(id);
    }

}
