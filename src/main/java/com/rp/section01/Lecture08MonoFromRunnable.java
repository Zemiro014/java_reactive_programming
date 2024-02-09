package com.rp.section01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> System.out.println("Process is done. Sending emails")
                );
    }

    private static Runnable timeConsumingProcess(){
        return () -> {
            Util.sleepSecond(3);
            System.out.println("Operation of timeConsumingProcess completed");
        };
    }
}
