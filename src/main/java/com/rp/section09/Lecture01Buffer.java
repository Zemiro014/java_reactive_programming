package com.rp.section09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture01Buffer {

    public static void main(String[] args) {

        eventStream()
                .buffer(5) // Allow that the subscriber consuming the items in group instead of item by item.
                .subscribe(Util.subscriber());


        Util.sleepSecond(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event"+i);
    }
}
