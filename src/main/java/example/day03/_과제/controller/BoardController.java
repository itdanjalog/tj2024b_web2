package example.day03._과제.controller;

import example.day03._과제.model.dto.BoardDto;
import example.day03._과제.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/day03/task/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("") // [1] HTTP 주소 매핑
    public int save(@RequestBody BoardDto boardDto){  // [2] HTTP BODY 본문 자료 매핑
        System.out.println("BoardController.save"); // soutm
        System.out.println("boardDto = " + boardDto); // soutp
        return boardService.save( boardDto );
    }

    @GetMapping("")
    public List< BoardDto > findAll(){
        return boardService.findAll();
    }

    @GetMapping("/view")
    public BoardDto find( @RequestParam int bno ){
        return boardService.find( bno );
    }

    @PutMapping("")
    public int update( @RequestBody BoardDto boardDto ){
        return boardService.update( boardDto );
    }

    @DeleteMapping("")
    public int delete( @RequestParam int bno ){
        return boardService.delete( bno );
    }
}












