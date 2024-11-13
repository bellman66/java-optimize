package util.concurrent.future;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    private static final int SEMAPHORE_COUNT = 3;
    private static int CriticalSection = 0;

    private static class TestClass implements Runnable{
        private final Semaphore semaphore;

        public TestClass(int semaphoreCount) {
            semaphore = new Semaphore(semaphoreCount);
        }


        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " : 자원 요청");

            try {
                semaphore.acquire();

                System.out.println("Thread " + Thread.currentThread().getName() + " : 자원 획득");

                CriticalSection++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
                System.out.println("Thread " + Thread.currentThread().getName() + " : 자원 반납");
            }
        }
    }

    @Test
    void addCountWithSemaphore() throws InterruptedException {
        // given
        TestClass testClass = new TestClass(SEMAPHORE_COUNT);

        Thread thread1 = new Thread(testClass);
        Thread thread2 = new Thread(testClass);
        Thread thread3 = new Thread(testClass);

        // when
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        // then
        Assertions.assertEquals(3, CriticalSection);
    }
}
