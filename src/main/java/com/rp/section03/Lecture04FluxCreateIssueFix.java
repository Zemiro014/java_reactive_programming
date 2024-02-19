package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {
    public static void main(String[] args) {

        // only one instance of fluxsink. But allows emitting more of one item
        Flux.create(fluxSink -> {
                String country;

                do {
                    country = Util.faker().country().name();
                    System.out.println("Emitted Country: "+country);

                    // We are emitting more than one item
                    fluxSink.next(country);
                    fluxSink.next(country);
                } while (!country.toLowerCase().equals("angola") && !fluxSink.isCancelled());
            })
            .take(10) // This cancels a subscription when the 3rd item is emitted
            .subscribe(Util.subscriber());
    }
}
