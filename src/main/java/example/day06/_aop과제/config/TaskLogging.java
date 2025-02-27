package example.day06._aop과제.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect// AOP 적용
@Component // 스프링 컨테이너에 빈 등록
public class TaskLogging {

    // [*]  @Before / @AfterReturning 사용하지 않고 @Around 하나로 표현
    @Around( " execution( * example.day06._aop과제.service.TaskService.*(..) )" )
    public Object TaskServiceCheck( ProceedingJoinPoint joinPoint ) throws Throwable{
        // * 지정한 함수 시그너처 출력
        System.out.println("[실행메소드] : " + joinPoint.getSignature() );
        // 1. 매개변수 출력
        // Arrays.toString( 배열변수 ) : 배열 출력을 주소값이 아닌 값으로 반환
        System.out.println("[매개변수] : " + Arrays.toString( joinPoint.getArgs() ) );
        // * 지정한 함수 실행
        Object result = joinPoint.proceed();
        // 2. 반환 값 출력
        System.out.println("[반환값 ] : " + result );
        // * 지정한 함수의 반환 값 그대로 반환
        return result;
    }

}


    /*
    // [1] save,findAll 실행 전 에 , 앞에* : 모든리턴타입 , 뒤에*:모든메소드 , (..) : 모든 매개변수타입 , && args( 매개변수명 )
    @Before("execution( * example.day06._aop과제.service.TaskService.*(..) ) && args( param ) ")
    public void paramCheck( Object param ){ // + Object ? 모든 매개변수들 값을 대입받기 위해서 ( 다형성 ) , 최상위 클래스
        System.out.println("[TaskService exe]");
        System.out.println("매개변수 : " + param );
    } // f end

    // [2] save,findAll 실행 후 에 , returning = "리턴값변수명"
    @AfterReturning(value = "execution( * example.day06._aop과제.service.TaskService.*(..) ) " , returning = "result")
    public void returnCheck( Object result ){ // + 모든 값들을 Object 타입으로 저장할 수 있기 때문에.
        System.out.println("[TaskService return]");
        System.out.println("반환값 : " + result );
    }

    // [3] save,findAll 실행 전 과 후 걸린시간
    @Around(" execution( * example.day06._aop과제.service.TaskService.*(..) ) ")
    public Object timeCheck(ProceedingJoinPoint joinPoint ) throws Throwable { // joinPoint.proceed() : 지정한 메소드[ TasksService.* ]를 실행

        // ProceedingJoinPoint : AOP 에서 사용되는 인터페이스
        // 제공하는 메소드
        // 1. .proceed() : 지정한 메소드를 실행하는 메소드
        System.out.println( joinPoint.getArgs() ); // 지정한 메소드의 매개변수 반환 ( 배열타입 )
        System.out.println( joinPoint.getSignature() ); // 지정한 메소드 시그너처 반환 ( 실행된 메소드의 리턴타입,함수명,매개변수)
        System.out.println( joinPoint.getTarget()); // 지정한 메소드를 실행한 객체 ( TaskService객체 )

        // (1) 시작 시간
        long stime = System.currentTimeMillis(); // 현재시간 밀리초
        // (*) 지정한 함수 실행 + 예외처리 필수
        Object result = joinPoint.proceed();
        // (2) 끝 시간
        long etime = System.currentTimeMillis(); // 현재시간 밀리초
        // (3) 걸린시간
        System.out.println("소요시간 : " + ( etime - stime) + "ms");
        // (-) 지정한 함수의 실행 리턴값 그대로 리턴
        return result;
    }
    */
