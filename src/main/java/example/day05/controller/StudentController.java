package example.day05.controller;

import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // HTTP 요청/응답 처리 ( +@ResponseBody포함 , 주로 JSON 반환 )
@RequestMapping("/day05/students") // HTTP 요청 URL 매핑 ( 주로 공통 URL 정의
public class StudentController {

    @Autowired // (스프링 컨테이너) 에서 빈(인스턴스) 주입 받기
    private StudentService studentService;

    // [1] 등록
    @PostMapping("")
    public int save(@RequestBody HashMap< String , Object> map ){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return  studentService.save( map );
    }
    // [2] 전체조회
    @GetMapping("")
    public List< Map<String , Object > > findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }
    // [3] 수정
    @PutMapping("")
    public int update( @RequestBody Map<String, Object> map ){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update( map );
    }
    // [4] 삭제
    @DeleteMapping("")
    public boolean delete( @RequestParam int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    }

    // [5] 특정 점수 이상 학생 조회
    @GetMapping("/find/scores")
    public List< Map<String,Object> > findStudentScores(
            @RequestParam int minKor ,
            @RequestParam int minMath ){
        return studentService.findStudentScores( minKor , minMath);
    }

} // class end
