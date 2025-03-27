package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TranService {
    private final TranMapper tranMapper;

    @Transactional // 해당 메소드는 트랜잭션을 적용한다는 뜻 // 발동 조건 : 'RuntimeException' 예외
    // 해당 메소드에서 처리하는 모든 SQL 은 'RuntimeException' 이 발생되면 rollback(롤백)되서 모든 SQL 이 취소된다.
    public boolean tran(){
        // (1) 첫번째 insert
        tranMapper.tran("유재석");
        // 학습용 : 여기에 고의적으로 문제(예외) 발생 해서 아래 insert를 못하게 한다.
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

    // (2) '이체' 트랜잭션
    //@Transactional // 아래 메소드의 'withdraw'(출금) 과 'deposit'(입금) 처리를 하나의 논리 작업 단위 만들기
    // 기본 발동 조건 : RuntimeException
    @Transactional( rollbackFor = Exception.class ) // 모든 예외 클래스에 대한 롤백이 적용된다. //
    public boolean transfer( Map<String,String> params ) throws Exception {

        // 예외처리방법1 : try{}catch( 예외클래스명 e){}
        // 예외처리방법2 : throws 예외클래스명{}

        // - 유효성검사 :  보내는사람/받는사람 존재여부, 이체할 금액 확인
        // 유효성검사 실패시 false 아닌 강제 예외발생 만들기

        // 1. 보내는 사람(fromname)의 금액(money)을 차감(출금)
        String fromName = params.get("fromname");
        int money = Integer.parseInt( params.get("money") );
        tranMapper.withdraw(  fromName , money );

        // 2. 받는 사람(toname)의 금액을 추가(입금)
        String toName = params.get("toname");
        tranMapper.deposit( toName , money );

        return true;
    }


}















