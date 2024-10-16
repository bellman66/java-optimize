package lang.runtime;

import org.junit.jupiter.api.Test;

public class RuntimeSample {

    @Test
    void runtimeMemoryTest() {
        // when
        Runtime runtime = Runtime.getRuntime();

        // given
        long freeMemory = runtime.freeMemory();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();

        // then
        System.out.println("freeMemory: " + freeMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("maxMemory: " + maxMemory);
    }
}
