package util.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FutureImplSample {

    @Test
    void completableFutureSample() throws ExecutionException, InterruptedException {
        // given
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "flow : task 1";
        });

        // when
        CompletableFuture<String> future1 = future.thenApply(data -> data.concat(" -> task 2"))
                .thenApply(data -> data.concat(" -> task 3"));

        // then
        String result = future1.get();
        assertEquals("flow : task 1 -> task 2 -> task 3", result);
    }

    @Test
    void scheduleSample() throws ExecutionException, InterruptedException {
        // given
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        // when
        ScheduledFuture<?> schedule = service.schedule(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return "Hello";
        }, 2, TimeUnit.SECONDS);

        // then
        assertEquals("Hello", schedule.get());
        service.shutdown();
    }
}
