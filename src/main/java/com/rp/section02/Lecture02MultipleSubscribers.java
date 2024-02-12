package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> eventFlux = integerFlux.filter(i -> i % 2 == 0);
        integerFlux.subscribe(i -> System.out.println("Sub 1 : "+i));

        eventFlux.subscribe(i -> System.out.println("Sub 2 : "+i));
    }
}
