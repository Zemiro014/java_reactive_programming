package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture02HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, sink) -> {
                    sink.next(s);
                    if (s.toLowerCase().equals("canada"))
                        sink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
