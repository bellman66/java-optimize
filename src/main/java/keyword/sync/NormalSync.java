package keyword.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

public class NormalSync {

    private int count = 0;

    // 둘다 동일한 객체 (this)에 대한 락을 획득하고 해제
    // 메서드 호출 시점에서 해당 객체(this)에 대한 락을 자동으로 획득하고 해제
    private synchronized void syncMethod() {
        count += 1;
        System.out.println("Thread : " + Thread.currentThread().getName() + " count : " + count);
    }

    // 바이트코드에서 MONITORENTER와 MONITOREXIT 명령어로 명시적인 락 획득과 해제를 수행
    private void scopeSyncMethod() {
        synchronized (this) {
            count += 1;
            System.out.println("Thread : " + Thread.currentThread().getName() + " count : " + count);
        }
    }

    @Test
    void normalSyncMethodTest() {
        NormalSync normalSync = new NormalSync();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    normalSync.syncMethod();
                }
            });

            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    normalSync.syncMethod();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }

    @Test
    void mixNormalSyncMethodTest() {
        NormalSync normalSync = new NormalSync();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    normalSync.syncMethod();
                }
            });

            executorService.submit(() -> {
                for (int i = 0; i < 100; i++) {
                    normalSync.scopeSyncMethod();
                }
            });
        } finally {
            executorService.shutdown();
        }
    }
}
