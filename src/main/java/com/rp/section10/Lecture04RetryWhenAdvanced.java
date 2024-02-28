package com.rp.section10;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;
import reactor.util.retry.RetrySpec;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture04RetryWhenAdvanced {

    private static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        orderService(Util.faker().business().creditCardNumber())
                .doOnError(err -> System.out.println(err.getMessage()))
                .retryWhen(Retry.from(
                        retrySignalFlux -> retrySignalFlux
                                .doOnNext(res -> {
                                    System.out.println(res.totalRetries());
                                    System.out.println(res.failure());
                                })
                                .handle((res, sync) -> {
                                    if(res.failure().getMessage().equals("500"))
                                        sync.next(1);
                                    else
                                        sync.error(res.failure());
                                })
                                .delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(Util.subscriber());

        Util.sleepSecond(60);

    }

    private static Mono<String> orderService(String ccNumber){
        return Mono.fromSupplier(() -> {
            processpayment(ccNumber);
            return Util.faker().idNumber().valid();
        });
    }

    private static void processpayment(String ccNumber) {
        int random = Util.faker().random().nextInt(1, 10);
        if(random < 8)
            throw new RuntimeException("500");
        else if(random < 10)
            throw new RuntimeException("404");
    }
}
