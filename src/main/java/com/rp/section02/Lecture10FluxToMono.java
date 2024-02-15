package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture10FluxToMono {

    public static void main(String[] args) {


        Flux<Integer> fluxRange = Flux.range(1, 10);
        Mono<Integer> fluxToMono = fluxRange
                .filter(i -> i > 3)
                .next();
        doSomething(fluxToMono);
    }

    private static  void doSomething(Mono<Integer> mono){
        mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
