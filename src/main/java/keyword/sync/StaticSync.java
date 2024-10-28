package keyword.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

public class StaticSync {

    private static int count = 0;

    // Static method -> class level lock
    synchronized static void syncMethod() {
        count += 1;
        System.out.println("Thread : " + Thread.currentThread().getName() + " count : " + count);
    }

    @Test
    void staticSyncMethodTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    syncMethod();
                }
            });

            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    syncMethod();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}
