package com.rp.section10;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01Repeat {

    public static void main(String[] args) {

        getIntegers()
                .repeat(2) // used to repeat the emission of items multiple times, allow the subscriber consuming 2 times
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("--Completed"));
    }
}
