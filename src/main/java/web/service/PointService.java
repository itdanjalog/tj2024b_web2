package web.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import web.model.mapper.PointMapper;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointMapper pointMapper;

    /**
     * 매일 오전 9시에 모든 회원에게 100 포인트 지급
     */
    @Transactional(rollbackFor = Exception.class) // 모든 예외 발생 시 롤백
    //@Scheduled(cron = "0 0 9 * * ?") // 매일 오전 9시 실행
    @Scheduled(cron = "0 */1 * * * *") //
    public void distributePoints() {
        List<Map<String, Object>> members = pointMapper.getAllMembers();

        List<Map<String, Object>> pointList = members.stream()
                .map(member -> Map.of("mno", member.get("mno"), "amount", 100))
                .collect(Collectors.toList());

        pointList.forEach(pointMapper::insertPoint);

        // 일부러 예외 발생 → 트랜잭션 롤백 확인
//        if (true) {
//            throw new RuntimeException("강제 예외 발생! 포인트 지급이 롤백될까?");
//        }

        members.stream()
                .map(member -> "포인트 지급 완료: " + member.get("mid"))
                .forEach(System.out::println);
    }

    /**
     * 매일 자정(00:00)에 30일 이상 사용되지 않은 포인트 자동 차감
     */
    @Transactional(rollbackFor = Exception.class) // 모든 예외 발생 시 롤백
    //@Scheduled(cron = "0 0 0 * * ?") // 매일 자정 실행
    @Scheduled(cron = "0 */3 * * * *") // 매일 자정 실행
    public void deductExpiredPoints() {
        //LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        LocalDateTime threeMinutesAgo = LocalDateTime.now().minusMinutes(3);


        // 30일 이상 경과한 포인트 조회
        //List<Map<String, Object>> expiredPoints = pointMapper.getExpiredPoints(thirtyDaysAgo);
        List<Map<String, Object>> expiredPoints = pointMapper.getExpiredPoints(threeMinutesAgo);

        // 차감할 포인트 목록 생성
        List<Map<String, Object>> deductionList = expiredPoints.stream()
                .map(point -> Map.of("mno", point.get("mno"), "amount", -(int) point.get("amount")))
                .collect(Collectors.toList());

        // 포인트 차감
        deductionList.forEach(pointMapper::insertPoint);


        // 차감된 회원 출력 (메소드 레퍼런스 사용)
        deductionList.stream()
                .map(point -> "포인트 차감 완료: " + point.get("mno"))
                .forEach(System.out::println);
    }
}