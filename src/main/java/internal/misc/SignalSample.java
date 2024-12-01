package internal.misc;

import org.junit.jupiter.api.Test;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignalSample {

    @Test
    void signalHandler() throws InterruptedException {
        // given
        AtomicBoolean flag = new AtomicBoolean(false);

        SignalHandler signalHandler = signal -> {
            flag.set(true);
            System.out.println("catch signal : " + signal.getName());
        };

        // when
        Signal.handle(new Signal("INT"), signalHandler);

        Signal.raise(new Signal("INT"));

        Thread.sleep(1000);

        // then
        assertTrue(flag.get());
    }
}
