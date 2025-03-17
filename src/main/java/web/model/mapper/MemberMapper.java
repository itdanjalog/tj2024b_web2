package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import web.model.dto.MemberDto;

@Mapper // 해당 인터페이스가 mapp임을 주입
public interface MemberMapper {

    // [1] 회원가입 -> INSERT
    @Insert("insert into member( mid , mpwd , mname , mimg ) " +
            " values( #{ mid } , #{ mpwd } , #{ mname }, #{ mimg } )" )
    public boolean sigunUp( MemberDto memberDto );

}
