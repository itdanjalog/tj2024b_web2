package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    // [1] 업로드
    // [POST] http://localhost:8080/api/file/upload
    // Content-Type : multipart/form-data
    // Body : (FORM) name : multipartFile , 임의로 FILE 업로드
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload( multipartFile );
        return result;
    }

    // [2] 업로드된 파일 다운로드
    // [GET] http://localhost:8080/api/file/download?filename=다운로드받을파일명
    @GetMapping("/download")
    public void fileDownload( @RequestParam String filename ,
                              HttpServletResponse response ){ // + HTTP 출력스트림 사용하기위한 매개변수
        fileService.fileDownload( filename, response);
    }

    // [3] 업로드된 파일삭제
    // [GET] http://localhost:8080/api/file/delete?filename=삭제할파일명
    @GetMapping("/delete")
    public boolean fileDelete(@RequestParam String filename ){
        System.out.println("FileController.fileDelete");
        System.out.println("filename = " + filename);
        boolean result = fileService.fileDelete( filename );
        return result;
    }

}
