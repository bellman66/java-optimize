package util.concurrent.locks.builtin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;

public class Account {

    private int amount;
    private final Lock lock;
    private final String name;

    public Account(String name) {
        this.amount = 0;
        this.lock = new ReentrantLock();
        this.name = name;
    }

    public Account(String name, int amount) {
        this.amount = amount;
        this.lock = new ReentrantLock();
        this.name = name;
    }

    public void deposit(int amount) {
        withLock(depositAction, amount);
    }

    public void withdraw(int amount) {
        withLock(withdrawAction, amount);
    }

    private void withLock(BiConsumer<Account, Integer> action, int amount) {
        lock.lock();

        try {
            action.accept(this, amount);
        } finally {
            lock.unlock();
        }
    }

    private static final BiConsumer<Account, Integer> depositAction = (account, amount) -> {
        account.amount += amount;
        System.out.println("Deposited " + amount + " to " + account.name + ". Current amount: " + account.amount);
    };

    private static final BiConsumer<Account, Integer> withdrawAction = (account, amount) -> {
        if (account.amount < amount) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }

        account.amount -= amount;
        System.out.println("Withdrawn " + amount + " from " + account.name + ". Current amount: " + account.amount);
    };

    public int getAmount() {
        return amount;
    }
}