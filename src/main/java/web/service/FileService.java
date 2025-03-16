package web.service;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileService {

    /*
        프로젝트명
            - build 폴더 : 배포 된 클래스/파일 들
            - src 폴더 : 배포 전 개발자가 코드(파일) 을 작성하는 곳
        배포 : 내 코드를 웹서버에 올림/빌드 으로써 외부(클라이언트) 로 부터 리소스 제공할수 있다.
    */

    // [0] 파일이 저장된 위치 경로 정의 필드
    // [ 배포 전 ]프로젝트내 src->upload 폴더 경로
    // String uploadPath = "C:\\Users\\TJ-BU-703-강사PC\\Desktop\\tj_2024A_spring\\src\\main\\resources\\static\\upload\\";
    // [ 배포 후 ]프로젝트내 build -> upload 폴더 경로
    //String uploadPath = "C:\\Users\\MSI\\tj2024b_web2\\build\\resources\\main\\static\\upload\\profile\\";
    //String uploadPath = "./upload/profile/";

    String baseDir = System.getProperty("user.dir"); // 현재 작업 디렉토리
    String uploadPath = baseDir + "/build/resources/main/static/upload/profile/";


    // [1] 파일 업로드
    // 매개변수로 파일의바이트가 저장된 MultipartFile 인터페이스
    // 업로드 된 파일명 반환
    public String fileUpload(MultipartFile multipartFile ){
        //System.out.println( multipartFile.getContentType() );   // 첨부파일의 확장자
        //System.out.println( multipartFile.getSize() );          // 첨부파일의 바이트 사이즈/용량
        //System.out.println( multipartFile.isEmpty() );          // 첨부파일이 없으면 true , 있으면 false
        // 1. 첨부 파일의 실제 파일 이름 추출
        // + 클라이언트(유저)들이 서로 다른 파일내용의 같은 파일명으로 업로드 했을때 식별이 불가능.
        // 해결방안 : 1. UUID( 고유성 보장하는 ID 규약 ) 2.조합식별 설계( 주로 업로드날짜/시간 와 파일명 조합 , 게시물번호 )
        String uuid = UUID.randomUUID().toString(); // 난수의 UUID 생성 , 임의의 UUID 규약에 따른 문자열 생성
        System.out.println("uuid = " + uuid);
        String fileName = multipartFile.getOriginalFilename();
        // UUID + 파일명 합치기 ,  uuid 와 파일명 구분하는 문자 조합 , 파일명의 _(언더바)가 존재하면 안된다.
        // 추후에 _(언더바) 기준으로 분해 하면 [0]UUID , [1]순수파일명
        // "문자열".replaceAll( "기존문자" , "새로운문자" ) : 만약에 문자열내 기존문자가 존재하면 새로운문자로 치환해서 반환
        fileName = uuid +"_"+ fileName.replaceAll( "_" , "-" ); // 파일명에 '_' 문자가 존재하면 '-' 문자로 변경

        // System.out.println("fileName = " + fileName);
        // 2. 첨부파일을 저장/복사/이동 할 경로 만들기

        // 3. 첨부파일을 저장/복사/이동 경로 와 파일명 합치기
        String filePath = uploadPath + fileName;
        // 4. 해당 경로로 설정한 file 객체 , transferTo( file객체 )
        File file = new File( filePath );
        // 5. transferTo( file객체 ) : file객체내 설정한 해당 경로 로 파일 복사/저장/이동
        // 일반예외 무조걵 발생
        try {
            multipartFile.transferTo(file);
        }catch (Exception e ){ System.out.println(e);  return  null; }

        return fileName;
    }

    // [2] 파일 다운로드
    public void fileDownLoad(String filename , HttpServletResponse response){
        System.out.println("FileService.fileDownLoad");System.out.println("filename = " + filename);
        // 1. 다운로드 할 경로 설정 uploadPath
        // - 업로된 경로 와 다운로드할 파일명 조합
        String downLoadPath = uploadPath + filename;
        System.out.println( downLoadPath );
        // -  File 클래스는 file 관련된 다양한 메소드 제공 ,
        // - exists() : 해당 경로의 파일이 존재하면 true 해당 경로의 파일이 없으면 false
        // - length() : 해당 경로의 파일이 존재하면 파일의 용량을 바이트의 개수 로 반환 [ 파일 용량 알기 ]
        File file = new File( downLoadPath );
        if( !file.exists() ){ return; } // 파일이 존재하지 않으면
        // 2. 해당 다운로드 할 파일을 서버(자바) 로 바이트를 읽기 , 왜? 서버가 파일을 읽어와야 하는지???
        // - 스트림이란 : 자바 외부 와 통신시 바이트 가 다니는 통로
        // - InputStream : 읽어드리는 통로 , OutPutStream : 내보내는 통로
        // - Buffered, 버퍼란 : 특정 위치로 이동하는 동안 일시적으로 데이터를 보관하는 메모리( 스트림 에서도 사용 )
        try {
            // ========================== 파일을 바이트 배열로 읽어오기 =========================
            // 2-1 파일 입력스트림 객체 생성  , new BufferedInputStream( 입력할 대상의 스트림객체 )
            //BufferedInputStream fin = new BufferedInputStream( new FileInputStream(downLoadPath));
            FileInputStream fin = new FileInputStream( downLoadPath );
            // 2-2 파일의 용량만큼 배열 선언
            // 파일의 용량
            long fileSize = file.length();
            // 파일의 용량만큼 배열의 길이 선언
            byte[] bytes = new byte[ (int)fileSize ];
            // .read( 배열명 ) : 해당 파일을 읽어서 바이트들을 해당 배열에 하나씩 대입한다.
            fin.read( bytes );      System.out.println( Arrays.toString( bytes ) );
            fin.close();   // - 스트림 닫기
            // ========================== 읽어온 바이트배열을 HTTP 바이트 형식으로 응답하기 =========================
            // [3] HTTP 스트림으로 응답하기
            // 3-1 출력스트림 객체 생성 , new BufferedOutputStream( 출력할 대상의 스트림객체 )
            // response.getOutputStream() : HTTP 응답 할때 바이트형식의 스트림 사용
            //BufferedOutputStream fout = new BufferedOutputStream( response.getOutputStream()  );
            ServletOutputStream fout = response.getOutputStream();
            // --- HTTP응답의 헤더 속성 추가  .setHeader( key , value )
            // Content-Disposition : 브라우저가 제공하는 다운로드 형식
            // attachment;filename="다운로드 형식에 표시될 파일명"
            // - URLEncoder.encode() : URL 경로상의 한글을 인코딩
            // filename.split("_")[1] : '_' 기준으로 분해해서 UUID 를 제외한 실제 파일명만 추출
            String oldFilename =   filename.contains("_") ? filename.split("_")[1] : filename;
            response.setHeader(
                    "Content-Disposition" ,
                    "attachment;filename="+ URLEncoder.encode( oldFilename  , "UTF-8") );
            // 3-2 바이트배열 내보내기/출력/쓰기
            fout.write( bytes );
            fout.close();  // - 스트림 닫기
        }catch (Exception e ){
            System.out.println("e = " + e);
        }
    }
    public void deleteFile(String fileName) {
        String filePath = uploadPath + fileName;
        // 4. 해당 경로로 설정한 file 객체 , transferTo( file객체 )
        File file = new File( filePath );
        if (file.exists()) {
            file.delete();
        }
    }
}
