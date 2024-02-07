package com.rp.section01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lecture05MonoFromSupplier {
    public static void main(String[] args) {

        /*
        Use "just" only when you have data already. If you need create a Mono with a dynamic data, use "Mono.fromSupplier" instead "Mono.just"
        "Mono.fromSupplier" works in Lazy mode.
        */
//        Mono<String> mono = Mono.just(getName()); // Not Lazy

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> monoSupplier = Mono.fromSupplier(stringSupplier); // Lazy
        monoSupplier.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());
    }

    private static String getName(){
        System.out.println("Generating name ...");
        return Util.faker().name().fullName();
    }
}
