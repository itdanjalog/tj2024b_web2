package example.day04.controller;

import example.day04.model.dto.StudentDto;
import example.day04.service.StudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")
public class StudentController {

    @Autowired // 스프링 컨테이너에 빈(인스턴스) 주입
    private StudentService studentService;

    // [1]
    @PostMapping("") // http://localhost:8080/day04/student
    public int save( @RequestBody StudentDto studentDto ){ // { "name" : "유재석" , "kor" : "90" , "math" : "100" }
        System.out.println("StudentController.save");
        System.out.println("studentDto = " + studentDto);
        return studentService.save( studentDto );
    }
    // [2]
    @GetMapping("") // http://localhost:8080/day04/student
    public List<StudentDto> findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }

    // [3]
    @PutMapping("")  // http://localhost:8080/day04/student
    public int update( @RequestBody StudentDto studentDto ){ // { "sno" : "1" , "name" : "유재석" , "kor" : "90" , "math" : "100" }
        System.out.println("StudentController.update");
        System.out.println("studentDto = " + studentDto);
        return studentService.update( studentDto );
    }

    // [4]
    @DeleteMapping("") // http://localhost:8080/day04/student?sno=1
    public int delete( @RequestParam int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    }

}
