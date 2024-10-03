package hello.aop.pointcut;

import hello.aop.member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ParameterTest {

    @Autowired
    MemberService memberService;

    @Test
    void success() {
        log.info("memberservice : {}", memberService.getClass());
        memberService.hello("helloA");
    }

    @Slf4j
    @Aspect
    static class ParameterAspect {}

    @Pointcut("execution(* hello.aop.member..*.*(..))")
    private void allMember() {

    }


}
