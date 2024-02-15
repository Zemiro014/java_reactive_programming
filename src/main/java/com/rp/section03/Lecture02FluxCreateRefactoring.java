package com.rp.section03;

import com.rp.courseutil.Util;
import com.rp.section03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lecture02FluxCreateRefactoring {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        // Subscribing in publisher
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        // Emitting items
        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSecond(2);
    }
}
