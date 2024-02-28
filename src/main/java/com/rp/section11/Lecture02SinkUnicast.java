package com.rp.section11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture02SinkUnicast {

    public static void main(String[] args) {


        // Handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();
        flux.subscribe(Util.subscriber("SAM"));

        sink.tryEmitNext("Hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");

        flux.subscribe(Util.subscriber("Mike")); // Doesn't allow 2 or more subscriber

    }
}
