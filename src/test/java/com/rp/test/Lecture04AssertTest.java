package com.rp.test;

import com.rp.section09.helper.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lecture04AssertTest {
    @Test
    public void test1(){
        Mono<BookOrder> bookOrderMono = Mono.fromSupplier(() -> new BookOrder())
                .delayElement(Duration.ofSeconds(3));

        StepVerifier.create(bookOrderMono)
                .assertNext(b -> Assertions.assertNotNull(b.getAuthor()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));
    }
}
