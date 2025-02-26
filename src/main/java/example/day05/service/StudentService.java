package example.day05.service;

import example.day05.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Service // (스프링 컨테이너) 에서 빈(인스턴스) 등록
public class StudentService {

    @Autowired private StudentMapper studentMapper;

    // [1] 등록
    public int save( HashMap< String , Object> map ){
        System.out.println("StudentService.save");
        System.out.println("map = " + map);
        return studentMapper.save( map );
    }
    // [2] 전체조회
    public Map<String , Object > findAll(){
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
}
