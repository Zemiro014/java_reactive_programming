package com.rp.section07;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture01Demo {

    public static void main(String[] args) {

        // In this code, the publisher is going produce all items before the subscriber start consuming them. For this reason, There will be a overflow on publish side.
        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : "+i);
            }
            fluxSink.complete();
        })
        .publishOn(Schedulers.boundedElastic())
        .doOnNext(i -> {
            // This operation will cause the soulfully consume item in subscriber side
            Util.sleepMills(10);
        })
        .subscribe(Util.subscriber());

        Util.sleepSecond(60);
    }
}
