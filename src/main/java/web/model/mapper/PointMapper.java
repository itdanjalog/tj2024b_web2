package web.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface PointMapper {
    /**
     * 모든 회원 목록 조회
     */
    @Select("SELECT mno, mid FROM member")
    List<Map<String, Object>> getAllMembers();

//    /**
//     * 30일 이상 사용되지 않은 포인트 조회
//     */
//    @Select("SELECT mno, amount FROM point WHERE pdate <= #{thirtyDaysAgo}")
//    List<Map<String, Object>> getExpiredPoints(LocalDate thirtyDaysAgo);
//
//    /**
//     * 포인트 지급 또는 차감 (양수: 지급, 음수: 차감)
//     */
//    @Insert("INSERT INTO point (mno, amount, pdate) VALUES (#{mno}, #{amount}, NOW())")
//    void insertPoint(Map<String, Object> pointData);
    /**
     * 3분 이상 사용되지 않은 포인트 조회
     */
    @Select("SELECT mno, amount FROM point WHERE pdate <= #{threeMinutesAgo}")
    List<Map<String, Object>> getExpiredPoints(LocalDateTime threeMinutesAgo);

    /**
     * 포인트 지급 또는 차감 (양수: 지급, 음수: 차감)
     */
    @Insert("INSERT INTO point (mno, amount, pdate) VALUES (#{mno}, #{amount}, NOW())")
    void insertPoint(Map<String, Object> pointData);
}

