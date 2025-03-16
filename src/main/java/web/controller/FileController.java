package web.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.service.FileService;

@RestController
@RequestMapping("/api/download")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @GetMapping("")
    public void download(@RequestParam String filename , HttpServletResponse response ){
        fileService.fileDownLoad( filename , response );
    }

}
