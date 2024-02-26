package com.rp.section06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lecture06Parallel {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Flux.range(1,  10)
                .parallel(2)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next " + i))
                .sequential()
                .subscribe(v -> printThreadName("sub "+v));

        Util.sleepSecond(5);

    }

    private static void printThreadName(String msg){
        System.out.println(msg + "\t\t: Thread : "+Thread.currentThread().getName());
    }
}
