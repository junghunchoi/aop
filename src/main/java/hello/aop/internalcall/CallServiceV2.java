package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    /*
    지연조회를 사용하여 주입받은 후 로직을 실행시킨다.
    하지만 굉장한 억지로 만든 느낌을 지울 수 없다.
     */
    private final ObjectProvider<CallServiceV2> objectProvider;

    public CallServiceV2(ObjectProvider<CallServiceV2> objectProvider) {
        this.objectProvider = objectProvider;
    }

    public void external() {
        CallServiceV2 callServiceV2 = objectProvider.getObject();
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
