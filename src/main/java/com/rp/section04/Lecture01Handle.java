package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01Handle {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, sink) -> {
                    if(integer % 2 == 0)
                        sink.next(integer);  // filter
                    else
                        sink.next(integer+"a"); // map
                })
                .subscribe(Util.subscriber());
    }
}
