package com.rp.section01;

import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {
    public static void main(String[] args) {
        // Publisher
        Mono<String> mono = Mono.just("ball");

        // 1
//        mono.subscribe();

        // 2
        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        // A Subscriber can receive a lot of parameters (OnNext, OnError, OnCompleted)
        // Publisher
        Mono<Integer> mono1 = Mono.just("ball")
                .map(String::length)
                .map( l -> l / 0);

        mono1.subscribe(
                item -> System.out.println(item), // onNext
                err -> System.out.println("Fall on Throwable Exception: "+err.getMessage()), // onError
                () -> System.out.println("Completed") // onCompleted
        );
    }
}
