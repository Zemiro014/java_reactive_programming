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

        // The items emitted before any subscription are stored, so the first subscriber will consume that stored items
        sink.tryEmitNext("Hi");
        sink.tryEmitNext("how are you");

        // Allow one or more subscription
        flux.subscribe(Util.subscriber("SAM")); // Will consume the 2 above items and 1 below item
        flux.subscribe(Util.subscriber("Mike")); // Will consume only the 1 below item

        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("Jake")); // Will consume nothing


    }
}
