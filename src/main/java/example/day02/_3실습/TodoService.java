package example.day02._3실습;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private int primaryKey = 1;
    private final List<StudentDto> dataset = new ArrayList<>();

    public boolean regist( @RequestBody StudentDto studentDto ){
        // StudentDto student = new StudentDto(id, name, score);
        studentDto.setId(primaryKey++); // id auto-increment
        // dataset.add(student); // [1] student 등록
        // return true; //
        dataset.add(studentDto);
        return true;
    }
    // [3] student 전체 학생 점수 조회 페이지
    public List<StudentDto> list( ){
        return dataset;
    }

    public StudentDto view( @RequestParam int id ){

        for ( int index = 0; index < dataset.size(); index++ ) {
            StudentDto student = dataset.get(index);
            if ( student.getId() == id ) {
                return student;
            }
        }
        return null; //

    }

    // [4] student 점수 수정 페이지
    public boolean update( @RequestBody StudentDto studentDto ){
        for ( int index = 0; index < dataset.size(); index++ ) {
            StudentDto student = dataset.get(index);
            if ( student.getId() == studentDto.getId() ) {
                dataset.set(index, studentDto);
                return true;
            }
        }
        return false; //
    }

    // [5] student 점수 삭제 페이지
    public boolean delete( @RequestParam int id ){
        for ( int index = 0; index < dataset.size(); index++ ) {
            StudentDto student = dataset.get(index);
            if ( student.getId() == id ) {
                dataset.remove(index);
                return true;
            }
        }
        return false; //
    }
}
