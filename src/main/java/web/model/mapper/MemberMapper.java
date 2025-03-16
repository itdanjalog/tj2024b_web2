package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import web.model.dto.MemberDto;

@Mapper
public interface MemberMapper {
    // 🔹 회원가입 (DB에 회원 정보 저장)
    @Insert("INSERT INTO member (mid, mpwd, mname, mimg) VALUES (#{mid}, #{mpwd}, #{mname}, #{mimg})")
    boolean signup(MemberDto memberDto);

    // 🔹 로그인 (아이디와 비밀번호가 일치하는지 확인)
    @Select("SELECT mno, mid, mname, mimg FROM member WHERE mid = #{mid} AND mpwd = #{mpwd}")
    MemberDto login(MemberDto memberDto );
}
