package example.day03._과제.service;

import example.day03._과제.model.dto.BoardDto;
import example.day03._과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int save( BoardDto boardDto){ // [3] 서비스 레이어/계층
        System.out.println("BoardService.save");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.save( boardDto );
    }

}
