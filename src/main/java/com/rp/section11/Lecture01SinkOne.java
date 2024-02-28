package com.rp.section11;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lecture01SinkOne {

    public static void main(String[] args) {


        // mono 1 value/ empty / error
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();
        mono.subscribe(Util.subscriber("Sam"));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return false;
        }));

        sink.emitValue("hi", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());
            return true;
        }));

    }
}
