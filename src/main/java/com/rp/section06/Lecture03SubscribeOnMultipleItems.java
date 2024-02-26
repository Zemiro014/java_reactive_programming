package com.rp.section06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture03SubscribeOnMultipleItems {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sleepSecond(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next " + i));

        flux
        .subscribeOn(Schedulers.boundedElastic())
        .subscribe(v -> printThreadName("sub "+v));

        flux
        .subscribeOn(Schedulers.newParallel("vins"))
        .subscribe(v -> printThreadName("sub "+v));

        Util.sleepSecond(7);

    }

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : "+Thread.currentThread().getName());
    }
}
