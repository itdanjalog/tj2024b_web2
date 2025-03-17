package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

@Mapper // 해당 인터페이스가 mapp임을 주입
public interface MemberMapper {

    // [1] 회원가입 -> 입력받은 자료를 등록 -> INSERT
    @Insert("insert into member( mid , mpwd , mname , mimg ) " +
            " values( #{ mid } , #{ mpwd } , #{ mname }, #{ mimg } )" )
    public boolean sigunUp( MemberDto memberDto );

    // [2] 로그인 -> 입력받은 자료를 확인/검증 -> SELECT
    @Select("select mno , mid , mname , mimg from member where mid = #{ mid } and mpwd = #{ mpwd }")
    //  boolean login( MemberDto memberDto );       // boolean : select 결과가 있으면 true , 없으면 null 이라서 오류 발생할수 있다. // 예외처리
    public MemberDto login( MemberDto memberDto );  // MemberDto : select 결과가 있으면 memberDto , 없으면 null

}
