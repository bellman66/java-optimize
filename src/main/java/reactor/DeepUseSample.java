package reactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class DeepUseSample {

    @Test
    void monoZip() {
        // given
        Mono<String> stringMono = Mono.zip(
                Mono.just("hello"),
                Mono.just("world"),
                Mono.just("!!!")
        ).flatMap(tuple -> {
            String content = tuple.getT1() + " " + tuple.getT2() + " " + tuple.getT3();
            return Mono.just(content);
        });

        // then
        stringMono.subscribe(res -> Assertions.assertEquals("hello world !!!", res));
    }
}
