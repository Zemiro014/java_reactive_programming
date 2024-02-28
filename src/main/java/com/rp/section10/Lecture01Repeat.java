package com.rp.section10;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lecture01Repeat {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        getIntegers()
                .repeat(() -> atomicInteger.get() < 14) // used to repeat the emission of items multiple times, allow the subscriber consuming 2 times
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"))
                .map(i -> atomicInteger.getAndIncrement());
    }
}
