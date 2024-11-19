package internal.unsafe;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnsafeSample {

    class Dummy {
        private String value = "default";

        public Dummy() {
            this.value = "init";
        }

        public String getValue() {
            return value;
        }
    }

    @Test
    void internalAccess() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // given
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // when
        long address = unsafe.allocateMemory(4L);
        unsafe.putInt(address, 123);
        int result = unsafe.getInt(address);

        // then
        assertEquals(123, result);
    }

    @Test
    void instanceAccess() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        // given
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);

        // when
        Dummy dummy = (Dummy) unsafe.allocateInstance(Dummy.class);

        // then
        Assertions.assertNull(dummy.getValue());
    }
}
