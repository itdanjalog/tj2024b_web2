package example.day01._2REST;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;


@Controller // 해당 클래스는 Controller 임을 알림 ( 어노테이션 기능 주입 )
// - 1. 해당 클래스는 spring 컨테이너(메모리) 에 bean(객체) 등록한다.
// - 2. Spring Controller 는 기본적으로 HTTP 서블릿 지원한다. 별도로 상속를 받지 않는다.
public class RestController1 {

    // [1] [GET] http://localhost:8080/day01/doget
    //  @RequestMapping( value = "/httl주소정의" , method = RequestMethod.사용할HTTP메소드 )
    //  - 1. value 속성에 매핑할 HTTP 주소 정의한다. * http://localhost:8080/(http주소정의)
    //      value = "/day01/doget"  ===> http://localhost:8080/day01/doget
    //  - 2. method = RequestMethod.POST/GET/PUT/DELETE 선택해서 사용한다.
    @RequestMapping( value = "/day01/doget" , method = RequestMethod.GET )
    public void doGet(){
        System.out.println(" day01 doGet executed ");
    } // F END
    // [2] [POST] http://localhost:8080/day01/dopost
    @RequestMapping( value = "/day01/dopost" , method = RequestMethod.POST )
    public void doPost(){
        System.out.println(" day01 doPost executed");
    } // F END
    // [3] [PUT] http://localhost:8080/day01/doput
    @RequestMapping( value = "/day01/doput" , method = RequestMethod.PUT )
    public void doPut() {
        System.out.println(" day01 doPut executed");
    } // F END
    // [4] [DELETE] http://localhost:8080/day01/dodelete
    @RequestMapping( value = "/day01/dodelete" , method = RequestMethod.DELETE )
    public void doDelete(){
        System.out.println(" day01 doDelete executed");// syso [x] --> sout  [o]
    } // F END

    // [1-1] [GET] http://localhost:8080/day01/doget2
    // @RequestMapping( value = "/day01/doget" , method = RequestMethod.GET )
    //  VS
    // @GetMapping( value = "/day01/doget2") , value 속성명 생략 가능.
    @GetMapping( "/day01/doget2" )
    public void doGET2(){  System.out.println(" day01 doGet2 executed ");  }

    // [2-1] [POST] http://localhost:8080/day01/doput2
    //  @RequestMapping( value = "/day01/dopost" , method = RequestMethod.POST ) vs @PostMapping( "/day01/doput2")
    @PostMapping( "/day01/dopost2")
    public void doPost2(){ System.out.println(" day01 doPost2 executed "); }

    // [3-1] [PUT] http://localhost:8080/day01/doput2
    @PutMapping( "/day01/doput2")
    public void doPut2() {   System.out.println( " day01 doput2 executed ");  }

    // [4-1] [DELETE] http://localhost:8080/day01/doput2
    @DeleteMapping( "/day01/dodelete2")
    public void doDelete2(){ System.out.println(" day01 dodelete2 executed "); }

} // C END

