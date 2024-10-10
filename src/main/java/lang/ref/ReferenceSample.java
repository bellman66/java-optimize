package lang.ref;

import org.junit.jupiter.api.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

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
        System.out.println("Before GC: Weak reference = " + weakReference.get());

        target = null;
        System.gc();

        Thread.sleep(1000);

        // then
        System.out.println("Before GC: Weak reference = " + weakReference.get());
    }
}
