package web.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service // 해당 클래스가 서비스임을 빈 등록
public class FileService {
    // [*] 업로드 된 파일을 저장할 폴더 경로 , resources(폴더)
    // src -> main -> resources -> static -> upload
    // 1. 현재 프로젝트 최상위 디렉토리(폴더) 경로찾기
    String baseDir = System.getProperty("user.dir"); // 현재 작업중인 최상위(프로젝트 절대경로) 폴더를 반환한다.
    // -> C:\Users\tj-bu-702-teacher\IdeaProjects\tj2024b_web2 , [PC마다 다르다]
    // 2. src 와 build 폴더 차이점 : src(실행전코드:개발자) vs build(실행후코드:사용자)
    // * 개발자는 src에서 작업하고 항상 서버를 실행 하므로써 작업한 코드를 build로 반영한다.( 컴파일/빌드 )
    // * 업로드는 개발자의 src에 업로드 하지 않고 배포/빌드 된 build 폴더에 업로드한다.
    // String uploadPath = "/src/resources/static/upload/";
    String uploadPath = baseDir+"/build/resources/main/static/upload/";
    // -> C:/Users/tj-bu-702-teacher/IdeaProjects/tj2024b_web2/build/resources/main/static/upload/

    // [1] 업로드 : 스프링에서는 MultipartFile 인터페이스 지원하므로써 파일 업로드 지원
    public String fileUpload( MultipartFile multipartFile ){ // (1) 매개변수로 'MultipartFile' 인터페이스 타입을 받는다.
        // (2) multipartFile 인터페이스내 다양한 메소드 제공한다.
        System.out.println( multipartFile.getContentType() ); // 첨부파일의 확장자 반환
        System.out.println( multipartFile.getSize() ); // 첨부파일의 용량(바이트) 반환
        System.out.println( multipartFile.getOriginalFilename() ); // 첨부파일의 파일명 반환
        System.out.println( multipartFile.isEmpty() ); // 첨부파일이 있다true,없다false 반환
        // (3) 업로드 할 경로 만들기. // '업로드할 기본경로' 와(+) '파일명'
        String filePath = uploadPath + multipartFile.getOriginalFilename();
        // (4) File 클래스 : File 관련된 다양한 메소드 제공하는 클래스
        File file = new File( filePath ); // new File( 파일경로 );
        // (5) 경로에 업로드 하기 , transferTo( File객체 / Path객체 )
        try {  multipartFile.transferTo(file);
        }catch (IOException e){ System.out.println(e);}
        return null;
    }

    // [2] 업로드된 파일 다운로드

    // [3] 업로드된 파일삭제

}
