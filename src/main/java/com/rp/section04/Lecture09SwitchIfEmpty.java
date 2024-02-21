package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback()) // If publisher generated an empty element, then call the fallback
                .subscribe(Util.subscriber());
    }

    // use case: redis cache
    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }

    // use case: DB
    private static Flux<Integer> fallback(){
        return Flux.range(20, 5);
    }
}
