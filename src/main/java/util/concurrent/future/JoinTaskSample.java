package util.concurrent.future;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JoinTaskSample {

    static class SumTask extends RecursiveTask<Long> {

        private final long start;
        private final long end;

        SumTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= 100) {
                long sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }

            long mid = (start + end) / 2;
            SumTask leftTask = new SumTask(start, mid);
            SumTask rightTask = new SumTask(mid + 1, end);

            leftTask.fork();
            return rightTask.compute() + leftTask.join();
        }
    }

    @Test
    void joinTaskSample() {
        // given
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // when
        RecursiveTask<Long> task = new SumTask(0, 1000);
        Long result = forkJoinPool.invoke(task);

        // then
        assertEquals(500500, result);
        forkJoinPool.shutdown();
    }
}
