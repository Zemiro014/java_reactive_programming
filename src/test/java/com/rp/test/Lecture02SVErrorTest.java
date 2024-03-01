package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lecture02SVErrorTest {

    @Test
    public void testError(){
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyError();
    }

    @Test
    public void testExceptionThrown(){
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyError(RuntimeException.class);
    }

    @Test
    public void testErroMessage(){
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                .verifyErrorMessage("oops");
    }
}
