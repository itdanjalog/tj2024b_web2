package example.day04.model.mapper;

import example.day04.model.dto.StudentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    // 방법1 : .XML
    // 방법2 : @SQL

    @Insert(" insert into student( name, kor, math )values( #{ name }, #{ kor }, #{ math } )")
    int save(StudentDto studentDto);

    @Select(" select * from student")
    public List<StudentDto> findAll();

    @Update(" update student set name = #{ name } , kor = #{ kor } , math = #{ math } where sno = #{ sno }")
    public int update( StudentDto studentDto );

    @Delete(" delete from student where sno = #{ sno }")
    public int delete( int id );

}






