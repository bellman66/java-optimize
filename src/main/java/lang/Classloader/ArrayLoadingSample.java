package lang.Classloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayLoadingSample {

    static class SuperClass {
        static {
            System.out.println("상위 클래스 초기화");
        }

        public static int value = 100;
    }

    /**
     * ClassLoader에 Array 형식으로 저장
     * name : [Llang.Classloader.ArrayLoadingSample$SuperClass
     */
    @Test
    void arrayLoadingTest() {
        // given
        SuperClass[] array = new SuperClass[10];

        String name = array.getClass().getName();

        Assertions.assertEquals("[Llang.Classloader.ArrayLoadingSample$SuperClass;", name);
    }
}
