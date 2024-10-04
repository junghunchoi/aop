package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {
    private CallServiceV1 callServiceV1;

    /*
    스스로 세터를 통해 다시 의존성을 주입해서
    내부메소드도 프록시처리를 하여 값을 확인할 수 있다.
     */
    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

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
