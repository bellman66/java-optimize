package reactor;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UseSample {

    @Test
    void monoflatmap() {
        // given
        Mono<String> mono = Mono.just("hello")
                .flatMap(s -> Mono.just(s + " world"))
                .doOnNext(System.out::println)
                .doOnError(Throwable::printStackTrace)
                .doOnSuccess((content) -> System.out.println("complete : " + content));

        mono.subscribe();
    }

    @Test
    void fluxflatmap() {
        // given
        Flux<Integer> flux = Flux.range(1, 5)
                        .flatMap(i -> Flux.range(i * 10, 2))
                        .doOnNext(System.out::println)
                        .doOnError(Throwable::printStackTrace)
                        .doOnComplete(() -> System.out.println("complete"));

        flux.subscribe();
    }

    @Test
    void fluxReduce() {
        // given
        Mono<String> flux = Flux.<String>create(sink -> {
                sink.next("hello");
                sink.next("world");
                sink.complete();
            }).concatMap(s -> Flux.just(s.toUpperCase()))
                .reduce((s1, s2) -> s1 + " " + s2);

        flux.subscribe(System.out::println);
    }

    @Test
    void fluxTransform() {
        Function<Flux<String>, Flux<String>> transformer = flux -> flux.map(String::toUpperCase);

        // A B C
        Flux.fromIterable(Arrays.asList("a", "b", "c"))
            .transform(transformer)
            .subscribe((result) -> System.out.println("result = " + result));
    }

    @Test
    void fluxTransformDeferred() {
        // given
        AtomicInteger count = new AtomicInteger();
        Function<Flux<String>, Flux<String>> transformer = flux -> {
            if (count.incrementAndGet() == 1) {
                return flux.map(String::toUpperCase);
            }
            return flux;
        };

        // when
        Flux<String> upperFlux = Flux.fromIterable(Arrays.asList("a", "b", "c"))
                .transformDeferred(transformer);

        // then
        upperFlux.collect(StringBuilder::new, StringBuilder::append)
                .subscribe((result) -> Assertions.assertEquals("ABC", result.toString()));
        upperFlux.collect(StringBuilder::new, StringBuilder::append)
                .subscribe((result) -> Assertions.assertEquals("abc", result.toString()));
    }
}
