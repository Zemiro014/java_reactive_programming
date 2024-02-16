package com.rp.section03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03FluxTake {

    public static void main(String[] args) {
        Flux.range(7, 10)
                .log()
                .take(3) // This cancels a subscription when the 3rd item is emitted
                .log()
                .subscribe(Util.subscriber());
    }
}
