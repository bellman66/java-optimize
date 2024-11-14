package util.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseStreamSample {

    /**
     * IntStream
     *
     *
    */
    @Test
    void baseStreamTest() {
        // given
        /**
         * 생성 순서
         *  1. StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
         *  2. new IntPipeline.Head<>(spliterator, StreamOpFlag.fromCharacteristics(spliterator), parallel);
         *
         * @see static class Head<E_IN> extends IntPipeline<E_IN>
         */
        IntStream stream = Arrays.stream(new int[] {1, 2, 3, 4, 5});

        // when
        /**
         * 순서
         * 1. reduce(0, Integer::sum);
         * 2. evaluate(ReduceOps.makeInt(identity, op));
         * 3. AbstractPipeline.evaluate(TerminalOp<E_OUT, R> terminalOp);
         *  3-1. checkparallel
         * 4. terminalOp.evaluateSequential(this, sourceSpliterator(terminalOp.getOpFlags()));
         * 5. check  private abstract static class ReduceOp<T, R, S extends AccumulatingSink<T, R, S>> implements TerminalOp<T, R>
         */
        int sum = stream.sum();

        // then
        assertEquals(15, sum);
    }
}
