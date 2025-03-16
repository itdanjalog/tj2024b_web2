package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final FileService fileService;

    // 🔹 회원가입 (비밀번호 암호화 후 저장)
    public boolean signup(MemberDto memberDto) {


        if (memberDto.getUploadfile().isEmpty()) { // - 업로드 된 파일이 존재  하지 않으면
        } else { // 존재하면
            String uploadFileName = fileService.fileUpload(memberDto.getUploadfile());
            // 1. 만약에 업로드가 실패 했으면  글쓰기 실패
            if (uploadFileName == null) return false;
            // 2. BoardDto 에 업로드 된 파일명 담아주기
            memberDto.setMimg(uploadFileName);
        }

        try {
            boolean result = memberMapper.signup(memberDto);
            return result;
        }catch (Exception e ){
            fileService.deleteFile( memberDto.getMimg() );
            return false;
        }
    }

    // 🔹 로그인 (비밀번호 검증 후 로그인 성공 여부 반환)
    public MemberDto login( MemberDto memberDto  ) {
        return memberMapper.login( memberDto );
    }
}
