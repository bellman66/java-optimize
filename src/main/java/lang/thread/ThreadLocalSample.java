package lang.thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ThreadLocalSample {

    static class TaskContext {

        private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

        public static void set(String value) {
            THREAD_LOCAL.set(value);
        }

        public static String get() {
            return THREAD_LOCAL.get();
        }
    }

    @Test
    void ThreadLocalTest() {
        // given & when
        Thread thread1 = new Thread(() -> {
            assertNull(TaskContext.get());
            TaskContext.set("thread1");
            assertEquals("thread1", TaskContext.get());
        });

        Thread thread2 = new Thread(() -> {
            assertNull(TaskContext.get());
            TaskContext.set("thread2");
            assertEquals("thread2", TaskContext.get());
        });

        // then
        thread1.start();
        thread2.start();
    }
}
