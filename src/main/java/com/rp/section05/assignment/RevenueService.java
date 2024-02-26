package com.rp.section05.assignment;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private Map<String, Double> db = new HashMap<>();

    public RevenueService(){
        db.put("Kids", 0.0);
        db.put("Automotive", 0.0);
    }

    public Consumer<PurchaseOrder> subscriberOrderStream() {
        System.out.println("Revenue was subscribed");
        return p -> db.computeIfPresent(p.getCategory(), (k,v) -> v + p.getPrice());
    }

    public Flux<String> revenueStream(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString())
                .subscribeOn(Schedulers.boundedElastic());// The flux subscription will occur delimited elastic threads pool who is usually used in I/O operations
    }
}
