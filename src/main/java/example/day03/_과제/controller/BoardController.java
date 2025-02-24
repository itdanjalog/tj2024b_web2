package example.day03._과제.controller;

import example.day03._과제.model.dto.BoardDto;
import example.day03._과제.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/day03/task/board") // [1] HTTP 주소 매핑
    public int save(@RequestBody BoardDto boardDto){  // [2] HTTP BODY 본문 자료 매핑
        System.out.println("BoardController.save"); // soutm
        System.out.println("boardDto = " + boardDto); // soutp
        return boardService.save( boardDto );
    }

}












