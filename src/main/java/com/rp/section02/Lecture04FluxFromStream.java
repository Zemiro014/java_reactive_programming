package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lecture04FluxFromStream {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = integers.stream();

        //stream.forEach(System.out::println); // after this step, the stream will be closed
        //stream.forEach(System.out::println); // This operation will generate a Exception

//        Flux<Integer> integerFlux = Flux.fromStream(stream);
//        integerFlux.subscribe( // Once read the stream, the stream will be closed
//                Util.onNext(),
//                Util.onError(),
//                Util.onComplete()
//                );
//        integerFlux.subscribe( // This subscriber will generate an error because the stream already closed
//                Util.onNext(),
//                Util.onError(),
//                Util.onComplete()
//        );

        Flux<Integer> integerFlux1 = Flux.fromStream(() -> integers.stream());
        integerFlux1.subscribe( // Once read the stream, the stream will be closed
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        integerFlux1.subscribe( // This subscriber will generate an error because the stream already closed
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
