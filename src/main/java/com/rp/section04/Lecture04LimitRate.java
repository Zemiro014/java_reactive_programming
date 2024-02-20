package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04LimitRate {

    public static void main(String[] args) {

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0) // is used to prevent the overload in subscriber.  It's limit the item production rate by request.
                .subscribe(Util.subscriber());
    }
}
