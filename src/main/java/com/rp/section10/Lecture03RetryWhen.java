package com.rp.section10;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture03RetryWhen {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3))) // used to retry conditionally the emission of items multiple times, allow the subscriber consuming 2 times
                .subscribe(Util.subscriber());

        Util.sleepSecond(60);

    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
                .doOnError(err -> System.out.println("-- ERROR : "+err.getMessage()));
    }
}
