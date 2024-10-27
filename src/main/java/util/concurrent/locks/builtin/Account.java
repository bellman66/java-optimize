package util.concurrent.locks.builtin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        lock.lock();

        try {
            this.amount += amount;

            System.out.println("Deposited " + amount + " to " + name + ". Current amount: " + this.amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();

        if (this.amount < amount) {
            throw new IllegalArgumentException("Not enough amount to withdraw");
        }

        try {
            this.amount -= amount;

            System.out.println("Withdrawn " + amount + " from " + name + ". Current amount: " + this.amount);
        } finally {
            lock.unlock();
        }
    }

    public int getAmount() {
        return amount;
    }
}
