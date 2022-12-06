package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false) //1번 테스트: 아예 실행되지 않음
        public void setNoBean1(Member noBean1) { //Member는 컨테이너에 의해 관리되는 빈이 아님, 즉 주입할 것이 없음!
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired //2번 테스트: null이 주입 됨
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired //3번 테스트: Optional.empty 가 주입 됨
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }

    }
}
