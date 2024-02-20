package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture07FluxGenerateCounter {

    public static void main(String[] args) {

        Flux.generate(
                () -> 1,
                (state, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if(state >= 10 || country.toLowerCase().equals("canada")) sink.complete();
            return state + 1;
        })
        .subscribe(Util.subscriber());

    }
}
