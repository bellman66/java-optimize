package util.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.concurrent.locks.builtin.Account;

public class ReentrantLockTest {

    @Test
    void depositTest() throws InterruptedException {
        // given
        Account account = new Account("from");

        // when
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> account.deposit(100));

        // then
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        Assertions.assertEquals(100, account.getAmount());
    }
}
