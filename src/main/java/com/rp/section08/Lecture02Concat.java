package com.rp.section08;

import com.rp.courseutil.Util;
import com.rp.section08.helper.NameGenerator;
import reactor.core.publisher.Flux;

public class Lecture02Concat {

    public static void main(String[] args) {


        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("OOPS"));
        Flux<String> flux3 = Flux.just("c", "d", "e");

//        Flux<String> flux = flux1.concatWith(flux2); OR
        // Flux<String> flux = Flux.concat(flux1, flux2, flux3); // Will stop the execution in exact moment of exception thrown
        Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3); // Will continues run if occur some Exception is will be thrown in end of execution

        flux.subscribe(Util.subscriber());

    }
}
