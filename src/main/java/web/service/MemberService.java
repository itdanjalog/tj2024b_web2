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
    private final FileService fileService;

    // [1] 회원가입
    public boolean sigunUp( MemberDto memberDto ){
        System.out.println("MemberService.sigunUp");
        System.out.println("memberDto = " + memberDto);
        try {
            if (memberDto.getUploadfile() == null   ) { // - 업로드 된 파일이 존재  하지 않으면

            } else { // 존재하면
                String uploadFileName = fileService.fileUpload(memberDto.getUploadfile());
                // 1. 만약에 업로드가 실패 했으면  글쓰기 실패
                if (uploadFileName == null) return false;
                // 2. BoardDto 에 업로드 된 파일명 담아주기
                memberDto.setMimg(uploadFileName);
            }

            //return false;
            boolean result = memberMapper.sigunUp(memberDto);
            System.out.println("result = " + result);
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
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












