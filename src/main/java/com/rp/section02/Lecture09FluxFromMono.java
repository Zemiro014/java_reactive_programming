package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture09FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("A");

        Flux<String> flux = Flux.from(mono);
        doSomething(flux);

    }

    private static  void doSomething(Flux<String> flux){
        flux.subscribe(Util.onNext());
    }
}
