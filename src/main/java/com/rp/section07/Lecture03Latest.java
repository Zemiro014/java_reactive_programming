package com.rp.section07;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lecture03Latest {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16"); // Customizing the buffer size. The default value is 256 defined in QUEES property
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 201; i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : "+i);
                    }
                    fluxSink.complete();
                })
                .onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    // This operation will cause the soulfully consume item in subscriber side
                    Util.sleepMills(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSecond(10);
    }
}
