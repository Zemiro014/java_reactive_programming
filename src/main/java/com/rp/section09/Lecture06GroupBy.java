package com.rp.section09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture06GroupBy {


    public static void main(String[] args) {

        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> i % 2) // key 0, 1
                .subscribe(gf -> process(gf, gf.key()));

        Util.sleepSecond(60);
    }

    private static void process(Flux<Integer> flux, int key){
        flux.subscribe(i -> System.out.println("Key : "+key+", Item : "+i));
    }
}
