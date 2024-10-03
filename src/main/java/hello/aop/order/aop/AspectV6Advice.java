package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

    @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            //@Before
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            //@AfterReturing
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            //@AfterThrowing
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        }finally {
            //@Atfer
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }

    /*
        joinpoint가 실행되기전에 동작시키기 위한 어노테이션이다.
        @Around 대신 이걸 쓰는 이유는
        ProceedingJoinPoint 타입의 파라미터를 받으면 반드시 proceed를 호출해야한다.
        하지만 joinPoint의 경우 다른 작업을 안해도 프록시의 메서드가 실행되기 때문이다.
    */
    @Before("hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    /*
        메서드가 정상적으로 실행되고 결과를 반환한 후에 실행되는 어드바이스
        실행되는 메서드의 타입이 void일 경우 return으로 null을 받기 때문에 반환타입을 고려해야한다.
     */
    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void doBefore(JoinPoint joinPoint, Object result) {
        log.info("[return] {} returning={}", joinPoint.getSignature(), result);
    }

    /*
        catch에서 하는 역할의 어드바이스이다.
     */
    @AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[exception] {} exception={}", joinPoint.getSignature(), ex);
    }

    @After("hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }

}
