package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * 내부로직을 아예 따로 뺴서 구조적으로 자연스럽게 사용할 수 있도록 수정한다.
 * 스프링에서 가장 권장하는 방법
 * 하지만 내부로직까지 로그를 다는 방법은 거의 없기에
 * aop가 적용되지 않는다면 내부호출을 의심해보자.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV3 {

    private final InternalService internal;

    public void external() {
        internal.internal();
    }


}
