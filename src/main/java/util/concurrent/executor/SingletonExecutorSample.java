package util.concurrent.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

public class SingletonExecutorSample {

    @Test
    void singletonExecutorSample() throws InterruptedException {
        // given
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // when
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread Name: " + Thread.currentThread().getName());
        });

        // then
        executorService.shutdown();

        while (!executorService.isTerminated()) {
            Thread.sleep(1000);
        }
    }

    @Test
    void singletonExecutorAsyncSample() {
        // given
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // when
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        }, executorService).thenAccept(result -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
        });

        // then
        completableFuture.join();
    }
}
