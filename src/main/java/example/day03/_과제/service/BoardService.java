package example.day03._과제.service;

import example.day03._과제.model.dto.BoardDto;
import example.day03._과제.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public int save( BoardDto boardDto){ // [3] 서비스 레이어/계층
        System.out.println("BoardService.save");
        System.out.println("boardDto = " + boardDto);
        return boardMapper.save( boardDto );
    }

    public List< BoardDto > findAll(){
        return boardMapper.findAll();
    }


    public BoardDto find( int bno ){
        return boardMapper.find( bno );
    }


    public int update(  BoardDto boardDto ){
        return boardMapper.update( boardDto );
    }


    public int delete(  int bno ){
        return boardMapper.delete( bno );
    }

}
