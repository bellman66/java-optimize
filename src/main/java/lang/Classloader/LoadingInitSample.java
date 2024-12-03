package lang.Classloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoadingInitSample {

    static class SuperClass {
        static {
            System.out.println("상위 클래스 초기화");
        }

        public static int value = 100;
    }

    static class SubClass extends SuperClass {
        static {
            System.out.println("하위 클래스 초기화");
        }
    }

    /**
     * 수동참조 확인
     * SubClass.value 를 호출하면 SuperClass 가 초기화 되는지 확인한다.
     */
    @Test
    void initTest() {
        // when
        int value = SubClass.value;

        Assertions.assertEquals(100, value);
    }
}
