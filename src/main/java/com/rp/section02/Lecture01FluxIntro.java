package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.io.Serializable;

public class Lecture01FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        Flux<Integer> flux0 = Flux.empty();
        Flux<Object> flux1 = Flux.just(1, 2, 3, "Ai", Util.faker().name().fullName());
        flux1.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
                );
    }
}
