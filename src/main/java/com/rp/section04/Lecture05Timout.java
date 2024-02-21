package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture05Timout {

    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallback()) // If the publisher no producing nothing in 2s, the fallback will be call
                .subscribe(Util.subscriber());

        Util.sleepSecond(60);
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback(){
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
