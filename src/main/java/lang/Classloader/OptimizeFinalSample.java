package lang.Classloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptimizeFinalSample {

    /**
     * final 변수는 컴파일 시점에 상수로 치환된다.
     * TestClass를 가리키는 심벌참조가 만들어지지 않음
     */
    static class TestClass {
        static {
            System.out.println("상위 클래스 초기화");
        }

        public static final int value = 100;
    }

    @Test
    void optimizeFinalTest() {
        // when
        int value = TestClass.value;

        // then
        Assertions.assertEquals(100, value);
    }
}
