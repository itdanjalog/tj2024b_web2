package example.day11._스프링스케줄링과제;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;

    @Scheduled( cron = "*/30 * * * * *" )
    public void task1(){
        boolean result = taskMapper.task1();
        if( result ){ System.out.println(">> 재고 3개씩 감소"); }
        else{ System.out.println(">> task1 실패"); }

    } // f end

    @Scheduled( cron = "0 */1 * * * *" )
    public void task2(){
        System.out.println(">> 1분마다 모든 제품 정보 조회");
        List< HashMap<String, String> > pList = new ArrayList<>();

        pList = taskMapper.task2( pList );
        for( HashMap<String, String> product : pList ){
            System.out.println(product.toString());
        } // f end

    } // f end

    @Scheduled( cron = "0 */5 * * * *" )
    public void task3(){
        boolean result = taskMapper.task3();
        if( result ) { System.out.println(">> 5분마다 재고가 10 이하인 상품의 재고 20개 추가");
        }else{ System.out.println(">> task3 실패"); }
    }

}