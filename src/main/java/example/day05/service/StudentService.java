package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // (스프링 컨테이너) 에서 빈(인스턴스) 등록
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // [1] 등록
    public int save( HashMap< String , Object> map ){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        // return studentMapper.save( map );
        System.out.println("============ SQL 처리전 ============== ");
        System.out.println("map = " + map);
        // map = { name=유재석, math=90, kor=100}  ,
        int result  = studentMapper.save( map );

        System.out.println("============ SQL 처리후 ============== ");
        System.out.println("result = " + result); // soutv : 가장 가까운 변수 출력
        // result = 1 ,  sql실행 결과 처리된 레코드수
        System.out.println("map = " + map);
        // map = {sno=4, name=유재석, math=90, kor=100}  ,
        // sql 처리하기전 sno는 없었지만 sql 처리된후 sno가 존재한다.


        return result;
    }

    // [2] 전체조회
    public List< Map<String , Object > > findAll(){
        System.out.println("StudentService.findAll");
        return studentMapper.findAll();
    }
    // [3] 수정
    public int update( Map<String, Object> map ){
        System.out.println("StudentService.update");
        System.out.println("map = " + map);
        return studentMapper.update( map );
    }
    // [4] 삭제
    public boolean delete( int sno ){
        System.out.println("StudentService.delete");
        System.out.println("sno = " + sno);
        return studentMapper.delete( sno );
    }

    // [5] 특정 점수 이상 학생 조회
    public List< Map<String,Object> > findStudentScores(
            int minKor , int minMath ){
        return studentMapper.findStudentScores( minKor , minMath);
    }
}
















