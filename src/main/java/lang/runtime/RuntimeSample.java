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

    @Test
    void externalCommandTest() {
        // given
        Runtime runtime = Runtime.getRuntime();
        String command = "notepad";

        // when
        try {
            Process process = runtime.exec(command);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void garbageCollectionTest() {
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

        // when
        runtime.gc();

        // given
        freeMemory = runtime.freeMemory();
        totalMemory = runtime.totalMemory();
        maxMemory = runtime.maxMemory();

        // then
        System.out.println("freeMemory: " + freeMemory);
        System.out.println("totalMemory: " + totalMemory);
        System.out.println("maxMemory: " + maxMemory);
    }
}
