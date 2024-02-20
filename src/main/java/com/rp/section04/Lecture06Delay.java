package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lecture06Delay {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "10");
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1)) // Apply a delay in each item production. Like limitRate,define also a request limit rate. Its request limit rate is define by "rector.bufferSize.x" from Queues, which in default is 32
                .subscribe(Util.subscriber());


        Util.sleepSecond(10);
    }
}
