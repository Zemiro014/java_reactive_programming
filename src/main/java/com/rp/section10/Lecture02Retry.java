package com.rp.section10;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lecture02Retry {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        getIntegers()
                .retry(2) // used to retry the emission of items multiple times, allow the subscriber consuming 2 times
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
                .doOnError(err -> System.out.println("-- ERROR : "+err.getMessage()));
    }
}
