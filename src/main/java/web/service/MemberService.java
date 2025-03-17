package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service // 해당 클래스가 서비스임을 주입
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 생략 가능하다.
public class MemberService {

    private final MemberMapper memberMapper;

    // [1] 회원가입
    public boolean sigunUp( MemberDto memberDto ){
        System.out.println("MemberService.sigunUp");
        System.out.println("memberDto = " + memberDto);
        //return false;
        boolean result = memberMapper.sigunUp(memberDto);
        System.out.println("result = " + result);
        return result;
    }
    // [2] 로그인
    public MemberDto login( MemberDto memberDto ){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);
        //return false;
        MemberDto result = memberMapper.login(memberDto);
        return result;
    }
}












