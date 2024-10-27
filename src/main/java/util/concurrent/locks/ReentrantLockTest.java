package util.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import util.concurrent.locks.builtin.Account;

public class ReentrantLockTest {

    @Test
    void depositTest() throws InterruptedException {
        // given
        Account account = new Account("test");

        // when
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> account.deposit(100));

        // then
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        Assertions.assertEquals(100, account.getAmount());
    }

    @Test
    void withdrawTest() throws InterruptedException {
        // given
        Account account = new Account("test", 1000);

        // when
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> account.withdraw(200));

        // then
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.SECONDS);
        Assertions.assertEquals(800, account.getAmount());
    }

    @Test
    void overWithdrawTest() {
        // given
        Account account = new Account("test", 1000);

        // when
        Executable executable = () -> account.withdraw(1200);

        // then
        Assertions.assertThrows(IllegalStateException.class,executable);
    }

    @Test
    void transferTest() {
        // given
        Account from = new Account("from", 1000);
        Account to = new Account("to", 1000);

        // when
        from.transfer(to, 500);

        // then
        Assertions.assertEquals(500, from.getAmount());
        Assertions.assertEquals(1500, to.getAmount());
    }
}
