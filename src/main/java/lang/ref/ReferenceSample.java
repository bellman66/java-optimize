package lang.ref;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class ReferenceSample {

    static class TestBean {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("MyObject is being garbage collected!");
            super.finalize();
        }
    }

    @Test
    void WeakReferenceTest() throws InterruptedException {
        // given
        ReferenceQueue<TestBean> queue = new ReferenceQueue<>();
        TestBean target = new TestBean();
        WeakReference<TestBean> weakReference = new WeakReference<>(target, queue);

        // when
        Assertions.assertEquals(weakReference.get(), target);

        target = null;
        System.gc();

        Thread.sleep(1000);

        // then
        Assertions.assertEquals(weakReference.get(), null);
    }

    @Test
    void WeakReferenceMapTest() throws InterruptedException {
        // given
        Map<Object, String> map = new WeakHashMap<>();
        Object target = new Object();
        map.put(target, "test value");

        // when
        Assertions.assertEquals(map.size(), 1);

        target = null;
        System.gc();

        Thread.sleep(1000);

        // then
        Assertions.assertEquals(map.size(), 0);
    }
}
