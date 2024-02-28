package com.rp.section09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture01Buffer {

    public static void main(String[] args) {

        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2)) // Allow that the subscriber consuming the items in group (5 items by group) instead of item by item, or consuming item when pass 2s.
                .subscribe(Util.subscriber());


        Util.sleepSecond(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> "event"+i);
    }
}
