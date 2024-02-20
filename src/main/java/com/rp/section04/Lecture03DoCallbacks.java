package com.rp.section04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
//            fluxSink.complete();
            fluxSink.error(new Throwable("OOPS"));
            System.out.println("--completed");
        })
        .doOnComplete(() -> System.out.println("doOnComplete"))
        .doFirst(() -> System.out.println("doFirst 1")) // Will be the third callable which will be executed in the pipeline
        .doOnNext(o -> System.out.println("doOnNext : "+o))
        .doOnSubscribe(s -> System.out.println("doOnSubscribe : "+s))
        .doOnRequest(r -> System.out.println("doOnRequest : "+r))
        .doFirst(() -> System.out.println("doFirst 2")) // Will be the second callable which will be executed in the pipeline
        .doOnError(e -> {
            System.out.println("doOnError : "+e.getMessage());
            if(e instanceof Throwable){
                System.out.println("Throwble Exception");
            }
        })
        .doOnTerminate(() -> System.out.println("doOnTerminate"))
        .doOnCancel(() -> System.out.println("doOnCancel"))
        .doFinally(signalType -> System.out.println("doFinally : "+signalType))
        .doFirst(() -> System.out.println("doFirst 3")) // Will be the first callable which will be executed in the pipeline
        .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : "+o))
        .subscribe(Util.subscriber()); // A subscriber calls the callable from bottom to top
    }
}
