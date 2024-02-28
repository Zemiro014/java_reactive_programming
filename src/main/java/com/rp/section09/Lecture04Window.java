package com.rp.section09;

import com.rp.courseutil.Util;
import com.rp.section09.helper.BookOrder;
import com.rp.section09.helper.RevenueReport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Lecture04Window {
    private static AtomicInteger  atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {


        eventStream()
                .window(Duration.ofSeconds(2))
                .flatMap(stringFlux -> saveEvents(stringFlux))
                .subscribe(Util.subscriber());


        Util.sleepSecond(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event"+i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux){
        return flux.doOnNext(e -> System.out.println("saving "+e))
                .doOnComplete(() -> {
                    System.out.println("saved this batch");
                    System.out.println("-----------------------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
