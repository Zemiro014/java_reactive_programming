package com.rp.section11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture04SinkReply {

    public static void main(String[] args) {

        // Handle through which we would push items
        Sinks.Many<Object> sink = Sinks.many().replay().all();

        // handle through subscribers will receive items
        Flux<Object> flux = sink.asFlux();

        // The items emitted before any subscription are stored, so the first subscriber will consume that stored items
        sink.tryEmitNext("Hi");
        sink.tryEmitNext("how are you");

        // Allow one or more subscription
        flux.subscribe(Util.subscriber("SAM")); // Will consume all items
        flux.subscribe(Util.subscriber("Mike")); // Will consume all items

        sink.tryEmitNext("?");
        flux.subscribe(Util.subscriber("Jake")); // Will consume all items


    }
}
