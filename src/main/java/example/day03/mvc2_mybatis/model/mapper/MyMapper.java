package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyMapper {
    // [1] 등록 SQL 매퍼
    int save( MyDto myDto ); // 추상메소드 매핑 구현
}















