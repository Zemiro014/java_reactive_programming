package com.rp.section06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01ThreadDemo {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next " + i));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub "+v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSecond(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : "+Thread.currentThread().getName());
    }
}
