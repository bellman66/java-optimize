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

    /**
     * halt() 메소드는 JVM을 즉시 종료시키는 메소드이다.
     * ShutdownHook 로직이 아니기 때문에 print문이 출력되지 않는다.
     **/
    @Test
    void haltTest() throws InterruptedException {
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
        runtime.halt(0);
    }
}
