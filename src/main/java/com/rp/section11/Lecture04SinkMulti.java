package com.rp.section11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Lecture04SinkMulti {

    public static void main(String[] args) {

        // Handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        // Allow one or more subscription
        flux.subscribe(Util.subscriber("SAM"));
        flux.subscribe(Util.subscriber("Mike"));

        sink.tryEmitNext("Hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");



    }
}
