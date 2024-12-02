package lang.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class WaitSample {

    class TaskQueue {

        private static final int MAX_TASK = 10;
        private final Queue<String> queue;

        public TaskQueue() {
            this.queue = new ArrayDeque<>();
        }

        public synchronized void publish(String task) {
            if (queue.size() >= MAX_TASK) {
                try {
                    System.out.println("Queue is full");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("    add Task : " + task);
            queue.add(task);
            notify();
        }

        public synchronized void consume() {
            if (queue.isEmpty()) {
                try {
                    System.out.println("Queue is empty");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            String task = queue.poll();
            System.out.println("    solve Task : " + task);
            notify();
        }
    }

    @Test
    void waitTwoThread() {
        // given
        TaskQueue taskQueue = new TaskQueue();

        // when
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                taskQueue.publish("task-" + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                taskQueue.consume();
            }
        });

        // then
        producer.start();
        consumer.start();
    }
}
