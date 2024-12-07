package reactor;

import org.junit.jupiter.api.Test;
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
}
