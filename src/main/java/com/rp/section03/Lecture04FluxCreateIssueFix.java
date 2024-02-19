package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {
    public static void main(String[] args) {
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
