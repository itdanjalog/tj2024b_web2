package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service // 해당 클래스가 서비스임을 주입
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 생략 가능하다.
public class MemberService {

    private final MemberMapper memberMapper;
    private final FileService fileService;// 파일 서비스 ( 업로드 , 다운로드 , 파일삭제 ) 기능 포함

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    // 비밀번호 해싱
//    public String encodePassword(String rawPassword) {
//        return passwordEncoder.encode(rawPassword);
//    }
//
//    // 비밀번호 검증
//    public boolean matchesPassword(String rawPassword, String hashedPassword) {
//        return passwordEncoder.matches(rawPassword, hashedPassword);
//    }

    // [1] 회원가입
    public boolean sigunUp( MemberDto memberDto ){
        System.out.println("MemberService.sigunUp");
        System.out.println("memberDto = " + memberDto);
        try {
            // (1) 만약에 첨부파일(프로필업로드)이 존재하는지 검사.
            if (memberDto.getUploadfile() == null) {
            } // 업로드가 존재하지 않으면
            else { // 업로드가 존재하면 파일서비스의 업로드 메소드 사용하기.
                // (2) 파일서비스내 업로드 함수 이용하여 첨부파일 업로드하고 파일명 받기.
                String filename = fileService.fileUpload(memberDto.getUploadfile());
                // (3) 업로드된 파일명을 dto 저장
                memberDto.setMimg(filename);
            }
            memberDto.setMpwd( passwordEncoder.encode( memberDto.getMpwd() ));
            boolean result = memberMapper.sigunUp(memberDto);
            System.out.println("result = " + result);
            return result;
        }catch ( Exception e ){ return false; } // 업로드 와 회원가입DB 처리 중 예외 발생시 false 반환
    }

    // [2] 로그인
    public MemberDto login( MemberDto memberDto ){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);

        // (1)
        String result1 = memberMapper.findMpwd( memberDto.getMid() );
        if( result1 == null ) return null;
        // (2)
        boolean result2 = passwordEncoder.matches( memberDto.getMpwd() , result1 );
        if( result2 == false ) return null;
        // (3)
        MemberDto result3 = memberMapper.login( memberDto.getMid() );
        return result3;
    }
}












