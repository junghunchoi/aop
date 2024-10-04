package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {

    /*
        내부 메소드를 사용할 떈 aop가 적용되지 않는다.
        프록시를 거치지 않고 자신 객체의 메소드를 사용하기 때문이다.
     */
    public void external() {
        log.info("call external");
        internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
