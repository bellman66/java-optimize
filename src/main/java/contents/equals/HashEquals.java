package contents.equals;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashEquals {

    static class TestBean {
        private String name;

        public TestBean(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return name.length();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            return name.equals(((TestBean) obj).name);
        }
    }

    @Test
    void checkEqualsAndHash() {
        // given
        TestBean testBean1 = new TestBean("test");
        TestBean testBean2 = new TestBean("test");

        // when & then
        Assertions.assertEquals(testBean1, testBean2);
    }

    @Test
    void checkHashSetEquals() {
        // given
        Set<TestBean> testBeans = new HashSet<>();

        TestBean testBean1 = new TestBean("test");
        TestBean testBean2 = new TestBean("test");
        TestBean testBean3 = new TestBean("test1");

        /*
            public boolean add(E e) {
                return map.put(e, PRESENT)==null;
            }
         */
        testBeans.add(testBean1);
        testBeans.add(testBean2);
        testBeans.add(testBean3);

        // when & then
        assertTrue(testBeans.size() == 2);
    }

    @Test
    void checkHashMapKeyGenerator() {
        // given
        String key = "test";

        int h;
        int result = (h = key.hashCode()) ^ (h >>> 16);

        // when & then
        assertEquals(key.hashCode(), 3556498);
        assertEquals(key.hashCode() >>> 16, 54);
        assertEquals(result, 3556516);
    }
}
