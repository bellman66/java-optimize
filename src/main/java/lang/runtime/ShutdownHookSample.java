package lang.runtime;

import org.junit.jupiter.api.Test;

public class ShutdownHookSample {

    @Test
    void shutdownHookTest() throws InterruptedException {
        // given
        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("Hook : JVM is shutting down.");
        }));

        // when
        System.out.println("Program is running...");

        Thread.sleep(3000);

        // then
        System.out.println("Exiting program.");
        runtime.exit(0);
    }
}
