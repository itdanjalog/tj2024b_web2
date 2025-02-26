package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Mapper
public interface StudentMapper {

    // 인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    // -> 리모콘/키보드 같은 존재이다.
    // 추상메소드란? 추상메소드 : 메소드의 { 구현부 } 를 빼고 선언부 만 존재하는 메소드
    // -> 여러개 곳에서 사용할 메소드를 반환타입,매개변수,함수명 만 정의하고 각 사용처에서 구현한다.

    // [1] 등록
    // 선택 .xml vs @어노테이션
    // @Insert( " insert into student( name , kor , mata ) values( #{ 매개변수 } , #{ 매개변수 } , #{ 매개변수 } ) ")
    @Insert( " insert into student( name , kor , math ) values( #{ name } , #{ kor } , #{ math } ) ")
    @Options( useGeneratedKeys = true , keyProperty = "sno" )
    int save( HashMap< String , Object> map );

    // [2] 전체조회
    @Select( "select * from student")
    Map<String , Object > findAll();

    // [3] 수정
    @Update(" update student set kor = #{ kor } , math = #{ math } where sno = #{ sno } ")
    int update( Map<String, Object> map );

    // [4] 삭제
    @Delete( " delete from student where sno = #{ sno } ")
    boolean delete(int sno );

}
