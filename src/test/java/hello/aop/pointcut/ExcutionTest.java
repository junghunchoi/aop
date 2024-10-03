package hello.aop.pointcut;

import hello.aop.member.MemberServiceImpl;
import hello.aop.member.annotation.MethodAop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExcutionTest {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method method;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        method = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMethod() {
        log.info("method ={}", method);
    }

    @Test
    void exactMethod() {
        pointcut.setExpression("execution(public String hello.aop.member.MemberServiceImpl.hello(String))");
        assertThat(pointcut.matches(method, MemberServiceImpl.class)).isTrue();
    }

}
