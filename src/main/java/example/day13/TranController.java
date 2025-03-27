package example.day13;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/day13/users")
@RequiredArgsConstructor
public class TranController {
    private final TranService tranService;

    @PostMapping
    public boolean tran(){
        tranService.tran();
        return true;
    }
}












