package com.rp.section01;

import com.rp.courseutil.Util;
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

        // A Subscriber can receive a lot of parameters (OnNext, OnError, OnComplete)
        // Publisher
        Mono<Integer> mono1 = Mono.just("ball")
                .map(String::length)
                .map( l -> l / 1);

        mono1.subscribe(
                item -> System.out.println(item), // onNext
                err -> System.out.println("Fall on Throwable Exception: "+err.getMessage()), // onError
                () -> System.out.println("Completed") // onComplete
        );

        mono1.subscribe(
                Util.onNext(), // onNext
                Util.onError(), // onError
                Util.onComplete() // onComplete
        );
    }
}
