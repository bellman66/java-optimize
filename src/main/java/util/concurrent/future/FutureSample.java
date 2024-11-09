package util.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.junit.jupiter.api.Test;

public class FutureSample {

    @Test
    void FutureInterfaceDefaultSample() {
        // given
        FutureTask<String> future = new FutureTask<>(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return "Hello";
        });

        // when
        Thread thread = new Thread(future);
        thread.run();
    }

    /**
     *     Submit Callable시 FutureTask로 변환
     *
     *     protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
     *         return new FutureTask<T>(callable);
     *     }
     *
     *     public void execute(Runnable command) {
     *         if (command == null)
     *             throw new NullPointerException();
     *
     *                 int c = ctl.get();
     *         if (workerCountOf(c) < corePoolSize) {
     *             if (addWorker(command, true))
     *                 return;
     *             c = ctl.get();
     *         }
     *
     *         if (isRunning(c) && workQueue.offer(command)) {
     *             int recheck = ctl.get();
     *             if (! isRunning(recheck) && remove(command))
     *                 reject(command);
     *             else if (workerCountOf(recheck) == 0)
     *                 addWorker(null, false);
     *         }
     *
     *         else if (!addWorker(command, false))
     *             reject(command);
     *     }
     */
    @Test
    void ExecutorServiceSample() {
        // given
        ExecutorService executorService = Executors.newFixedThreadPool(3); // ThreadPoolExecutor

        // when
        executorService.submit(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread Name: " + Thread.currentThread().getName());
        });

        executorService.submit(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
    }
}
