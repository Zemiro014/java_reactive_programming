package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxRange {
    public static void main(String[] args) {
        // Flux.range is used to execute some operation in number of times you want
        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}
