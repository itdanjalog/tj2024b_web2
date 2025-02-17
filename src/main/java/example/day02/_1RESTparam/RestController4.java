package example.day02._1RESTparam;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day02")
public class RestController4 {
    // ========== HTTP BODY 매개변수들을 매핑 하는 방법 ========= //

    //[0] HTTP POST : 쿼리스트링 가능.
    @PostMapping("/dopost1")
    public String test5( @RequestParam String key1 , int key2 ){
        System.out.println("RestController5.test5");
        System.out.println("key1 = " + key1 + ", key2 = " + key2);
        return "test5 HI";
    }
    // [1] HTTP POST
    @PostMapping("/dopost2")
    // public String test6( String key1 , int key2 ){               // [1] HTTP BODY 데이터 매핑 안됨
    // public String test6( RestDto restDto ){
    public String test6( @RequestBody RestDto restDto ){
        System.out.println("RestController6.test6");
        //System.out.println("key1 = " + key1 + ", key2 = " + key2);
        // System.out.println("restDto = " + restDto);
        System.out.println("restDto = " + restDto);
        return "test6 HI";
    }

}
