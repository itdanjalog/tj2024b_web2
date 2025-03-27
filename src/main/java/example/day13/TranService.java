package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TranService {
    private final TranMapper tranMapper;

    @Transactional // 해당 메소드는 트랜잭션을 적용한다는 뜻 // 발동 조건 : 'RuntimeException' 예외
    // 해당 메소드에서 처리하는 모든 SQL 은 'RuntimeException' 이 발생되면 rollback(롤백)되서 모든 SQL 이 취소된다.
    public boolean tran(){
        // (1) 첫번째 insert
        tranMapper.tran("유재석");
        // 학습용 : 여기에 고의적으로 문제(예외) 발생 해서 아래 insert를 못하게
        if( true ) {
            throw new RuntimeException("강제로 실행예외 발생"); // 예외 발생하면 아래 코드가 실행되지 않는다.
            // (3) 만약에 두개 insert 하는 도중에 첫번째 insert 이후 문제가 발생하면 두번째 insert는 실행 불가.
            // 유재석만 저장.
            // --> @Transactional 이후에는 유재석도 롤백(취소) 이 된다
        }
        // (2) 두번째 insert
        tranMapper.tran("강호동");
        return true;
    }
}
