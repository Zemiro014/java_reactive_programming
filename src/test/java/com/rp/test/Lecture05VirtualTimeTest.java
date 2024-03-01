package com.rp.test;

import com.rp.section09.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lecture05VirtualTimeTest {
    @Test
    public void test1(){

        StepVerifier.withVirtualTime(() -> timeConsumingFlux())
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a", "2a", "3a", "4a")
                .expectComplete();
    }

    private Flux<String> timeConsumingFlux(){
        return Flux.range(1, 4)
                .delayElements(Duration.ofSeconds(5))
                .map(i -> i + "a");
    }
}
