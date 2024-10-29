package keyword.volatiles;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VolatileTest {

    /**
     * Volatile 키워드
     * - 멀티쓰레드 환경에서 공유되는 변수에 사용
     * - 변수를 메인 메모리에 저장하고 캐시에 저장하지 않음
     */
    static class SharedObject {

        private volatile int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    @Test
    void sharedTwoThread() {
        // given
        SharedObject shared = new SharedObject();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // when
        try {
            Future<?> submit1 = executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    shared.increment();

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Future<?> submit2 = executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    System.out.println("count : " + shared.getCount());

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            submit1.get();
            submit2.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
