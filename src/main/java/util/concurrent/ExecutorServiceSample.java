package util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

public class ExecutorServiceSample {

    @Test
    void ExecutorServiceSample() {
        // given
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // when
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println("Thread Name: " + Thread.currentThread().getName());
            });
        }

        // then
        executorService.shutdown();
    }

    @Test
    void ScheduledExecutorServiceSample() throws InterruptedException {
        // given
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);

        // when
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Task executed at fixed rate by " + Thread.currentThread().getName());
        }, 1, 2, TimeUnit.SECONDS);
    }
}
