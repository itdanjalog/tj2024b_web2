package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/day13/users")
@RequiredArgsConstructor
public class TranController {
    private final TranService tranService;

    // (1)
    @PostMapping
    public boolean tran(){
        tranService.tran();
        return true;
    }
    // (2) // '서장훈이 신동엽에게 10만원 보내는 예제'
    @PostMapping("/transfer")// http://localhost:8080/day13/users/transfer
    // { "fromname" : "서장훈" , "toname":"신동엽" , "money" : "100000"  }
    public boolean transfer(@RequestBody Map<String,String> params ){
        try{
            tranService.transfer( params );
            return true; // 예외 발생이 없다면 이체 완료
        }catch ( Exception e ){
            return false; // 예외 발생이 있다면 이체 실패
        }
    }
}












