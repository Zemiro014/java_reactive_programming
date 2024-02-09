package com.rp.section01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture06MonoSupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName().subscribe(item -> System.out.println("RECEIVED: "+item));
        String block = getName().block(); // o método block() interrompe o processo de assincrono
        System.out.println(block);
    }

    private static Mono<String> getName(){
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name ...");
            Util.sleepSecond(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
