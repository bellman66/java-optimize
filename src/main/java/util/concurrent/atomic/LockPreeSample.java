package util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockPreeSample {

    /**
     * CAS ( atomic operation )
     * - 데이터 메모리 주소
     * - 기대 값(expected value): 변수의 현재 값으로 예상되는 값.
     * - 새로운 값(new value): 변수의 값을 업데이트할 새로운 값.
     * 
     * ABA 
     *  - 다른 스레드가 기존 값을 변경하고 돌아와도 모르는 상태
     */
    @Test
    void ABAProblem() throws InterruptedException {
        // given
        AtomicInteger atomicValue = new AtomicInteger(100);
        boolean[] isUpdated = {false};

        // when
        Thread thread1 = new Thread(() -> {
            int expectedValue = 100;
            System.out.println("Thread 1: Expected Value = " + expectedValue);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // 값 일치시 업데이트
            isUpdated[0] = atomicValue.compareAndSet(expectedValue, 200);
            System.out.println("Thread 1: Update successful = " + isUpdated[0]);
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            atomicValue.set(50);  // 값 변경
            System.out.println("Thread 2: Changed Value to 50");

            atomicValue.set(100); // 원래 값으로 복원
            System.out.println("Thread 2: Restored Value to 100");
        });

        // then
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Assertions.assertEquals(atomicValue.get(), 200);
        Assertions.assertEquals(isUpdated[0], true);
    }

}
