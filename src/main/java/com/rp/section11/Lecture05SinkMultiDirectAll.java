package com.rp.section11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lecture05SinkMultiDirectAll {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();


        Flux<Object> flux = sink.asFlux();

        flux.subscribe(Util.subscriber("SAM")); // Increase performance because the Mike is too Slow
        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("Mike"));


        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSecond(10);
    }
}
