package example.day05.model.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
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
    // @Select( "select * from student")                        : native 쿼리 제공 : 순수한 SQL 작성
    @Select( "<script> select * from student </script> ")      // 동적 쿼리 제공 : 순수한 SQL에 mybatis의 추가적인 쿼리 제공 // XML형식
    List< Map<String , Object > > findAll();

    // [*] 특정한 점수 이상의 학생 조회 ( 동적 쿼리 표현 = <script> , <if> , <foreach> )
    // @Select( "select * from student kor >= 80  and math >=80 ")
    @Select(""" 
           <script>
                select * from student 
                where 1=1 
                <if test = "minKor != null" >
                    and kor >= #{ minKor }
                </if>
                <if test = "minMath != null" >
                    and math >= #{ minMath }
                </if>
           </script> 
           """ ) // java15 이상부터 (강의는17) """ """ 템플릿 지원 : 문자열 입력할때 다음줄로 이어지는 방법을 + 더하기 연산자가 아닌 템플릿 연결 방식
    List< Map<String,Object> > findStudentScores( int minKor , int minMath );
        // minKor 가 null 일때 실제 sql 표현 : select * from student where 1=1
        // minKor 가 80 일때  실제 sql 표현 : select * from student where 1=1 and kor >= 80
        // minKor 가 80 이고 minMath가 90 일떄 : select * from student where 1=1 and kor >= 80 and minMath >= 90
        // minKor 가 nul 이고  minMath 70 일떄 : select * from student where 1=1 and minMath >= 90

    // sql 에서 1=1 ( true 뜻 , 강제로 true 필요할때 방법 ) : 주로 다음 조건을 동적으로 처리할때 사용된다.

    /*
        [기본] String text = "안녕하세요 "
                            +" 유재석입니다";
        [java15이상] String text = """
                                    안녕하세요
                                     유재석입니다
                                    """;
    */

    // [3] 수정
    @Update(" update student set kor = #{ kor } , math = #{ math } where sno = #{ sno } ")
    int update( Map<String, Object> map );

    // [4] 삭제
    @Delete( " delete from student where sno = #{ sno } ")
    boolean delete(int sno );

}
