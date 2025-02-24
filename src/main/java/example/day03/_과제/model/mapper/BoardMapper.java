package example.day03._과제.model.mapper;

import example.day03._과제.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {

    int save(BoardDto boardDto ); // [4] .xml 파일의 SQL 매핑

}
