package example.day03._과제.model.mapper;

import example.day03._과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int save(BoardDto boardDto );// [4] .xml 파일의 SQL 매핑

    public abstract List< BoardDto > findAll();

    BoardDto find( int bno );


    int update(  BoardDto boardDto );


    int delete(  int bno );
}
