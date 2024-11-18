package internal.unsafe;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import sun.misc.Unsafe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnsafeSample {

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
}
