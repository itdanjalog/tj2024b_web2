package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    // [3] 업로드된 파일삭제

}
