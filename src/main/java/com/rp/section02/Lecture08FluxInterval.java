package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture08FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSecond(5);
    }
}
