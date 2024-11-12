package util.concurrent.future;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSample {

    @Test
    void cyclicBarrierSample() throws InterruptedException {
        // given
        int threadCount = 3;

        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("모든 스레드 응답완료");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " : 작업 시작");

                Thread.sleep((long) ((Math.random() % 3) * 3000));
                barrier.await();

                System.out.println(Thread.currentThread().getName() + " : 작업 종료");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // when
        Collection<Thread> threadGroup = new HashSet<>();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(task);
            thread.start();
            threadGroup.add(thread);
        }

        for (Thread thread : threadGroup) {
            thread.join();
        }
    }
}
