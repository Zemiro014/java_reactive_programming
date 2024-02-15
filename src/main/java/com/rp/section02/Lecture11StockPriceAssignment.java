package com.rp.section02;

import com.rp.section02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lecture11StockPriceAssignment {

    public static void main(String[] args) {
        Flux.just(1, 2, 3);
        CountDownLatch latch = new CountDownLatch(1);
        StockPricePublisher.getPrice().subscribeWith(new Subscriber<Integer>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println(LocalDateTime.now()+" : Price : "+ price);
                if(price > 110 || price < 90){
                    this.subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
