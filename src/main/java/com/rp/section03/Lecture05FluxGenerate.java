package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxGenerate {

    public static void main(String[] args) {

        // Indefinitely loops. In each loop only one emitting is allowed
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitted Country: "+country);

            //Allows emitting only one item
            synchronousSink.next(country);
//            synchronousSink.next(country);
        })
        .take(2) // Cancelled a subscription from 2nd items emitted
        .subscribe(Util.subscriber());
    }
}
