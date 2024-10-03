package hello.aop.exam;

import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {
    private static int seq = 0;

    /**
     * 5번에 1번 실패하는 요청
     */
    public String save(String exam) {
        seq++;
        if (seq == 5) {
            seq = 0;
            throw new RuntimeException("5번에 1번 실패하는 요청");
        }
        return "ok";
    }
}
