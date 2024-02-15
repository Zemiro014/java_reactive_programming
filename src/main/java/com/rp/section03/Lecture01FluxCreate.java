package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01FluxCreate {
    public static void main(String[] args) {
        // Emitting item programmatically
//        Flux.create(fluxSink -> {
//            fluxSink.next(1);
//            fluxSink.next(2);
//            fluxSink.complete();
//        })
//                .subscribe(Util.subscriber());

        // Emitting item programmatically. If a condition is match then stop to emit item
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("angola"));
                })
                .subscribe(Util.subscriber());
    }
}
