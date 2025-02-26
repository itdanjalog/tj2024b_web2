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
    @PostMapping("") // post , http://localhost:8080/day05/students  , { "name" : "유재석" , "kor" : "80" , "math" : "100" }
    public int save(@RequestBody HashMap< String , Object> map ){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return  studentService.save( map );
    }
    // [2] 전체조회
    @GetMapping("") // get , http://localhost:8080/day05/students
    public List< Map<String , Object > > findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }
    // [3] 수정
    @PutMapping("") // put , http://localhost:8080/day05/students ,  {  "sno" : "1" ,  "kor" : "10" , "math" : "20" }
    public int update( @RequestBody Map<String, Object> map ){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update( map );
    }
    // [4] 삭제
    @DeleteMapping("") // delete , http://localhost:8080/day05/students?sno=4 ,
    public boolean delete( @RequestParam int sno ){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    }

    // [5] 특정 점수 이상 학생 조회
    @GetMapping("/find/scores") // get , http://localhost:8080/day05/students/find/scores?minKor=70&minMath=70
    public List< Map<String,Object> > findStudentScores(
            @RequestParam int minKor ,
            @RequestParam int minMath ){
        System.out.println("StudentController.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentService.findStudentScores( minKor , minMath);
    }

    // [6] 여러명의 학생 등록하기
    @PostMapping("/save/all")
    // post , http://localhost:8080/day05/students/save/all
    // body : [ { "name" : "유재석" , "kor" : "100", "math" : "90" } ,{ "name" : "유재석2" , "kor" : "50", "math" : "40" } ]
    public boolean saveAll( @RequestBody List< Map< String,Object>> list ){
        System.out.println("StudentController.saveAll");
        System.out.println("list = " + list);
        return studentService.saveAll( list );
    }
    /*
        [ JS(fetch/axios) / TalendApi ] ----------- HTTP -------------------->  [JAVA]
                ( JSON 알고있음 )                   ( JSON 알고있음 )              ( JSON 몰라 / 타입변환  )
                body : { }                                                      DTO , MAP
                body : [ ]                                                      List
     */


} // class end












