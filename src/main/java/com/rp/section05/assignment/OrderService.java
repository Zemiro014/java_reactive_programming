package com.rp.section05.assignment;

import com.rp.section05.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.*;

public class OrderService {

    private Flux<PurchaseOrder> flux;
    public Flux<PurchaseOrder> orderStream(){
        if(Objects.isNull(flux))
            flux = getOrderStream();
        return flux;
    }

    private static Flux<PurchaseOrder> getOrderStream() {
        return Flux.interval(Duration.ofMillis(100))
                .map(i -> new PurchaseOrder())
                .publish()
                .refCount(2);
    }
}
