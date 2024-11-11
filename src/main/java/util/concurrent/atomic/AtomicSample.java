package util.concurrent.atomic;

import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AtomicSample {

    /**
     * VarHandle 사용되지 않음
     * AtomicBoolean과 비교 필수
     *
     * public class AtomicInteger extends Number implements java.io.Serializable {
     *    private static final long serialVersionUID = 6214790243416807050L;
     *    private static final Unsafe U = Unsafe.getUnsafe();
     *    private volatile int value;
     *    ...
     *
     * @See Unsafe
     */
    @Test
    void atomicIntegerSample() {
        // given
        AtomicInteger atomicInteger = new AtomicInteger();

        // when
        int result = atomicInteger.addAndGet(1);

        // then
        assertEquals(1, result);
    }

    /**
     * VarHandle 사용됨
     *
     * public class AtomicBoolean implements java.io.Serializable {
     *     private static final long serialVersionUID = 4654671469794556979L;
     *     private static final VarHandle VALUE;
     *     ...
     *
     * @see VarHandle
     */
    @Test
    void atomicBooleanSample() {
        // given
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        // when
        atomicBoolean.set(true);

        // then
        assertTrue(atomicBoolean.get());
    }
}
