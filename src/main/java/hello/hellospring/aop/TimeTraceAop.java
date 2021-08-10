package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // 이걸 적어줘야 aop로 쓸 수 있음 - springConfig에서 bean 으로 등록해줘도 되고 , component scan으로 써도됨
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") // hellospring 패키지 하위에는 다 적용해라
    // 호출이 될 때마다 인터셉트를 걸면서 time 로직을 실행해주는 것
    // hello.hellospring.service..*(..)) --> service 아래의 로직에만 적용해라
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START = " + joinPoint.toString());

        try{
            return joinPoint.proceed(); // 다음 메소드로 진행된다.
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END = " + joinPoint.toString() + " " + timeMs +"ms");
        }
    }
}
