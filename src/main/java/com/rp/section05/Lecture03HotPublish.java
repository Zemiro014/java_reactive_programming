package com.rp.section05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture03HotPublish {

    public static void main(String[] args) {

        // Every time a new subscriber make a subscription to publisher "movieStream", the new subscriber will receive the current item which the publisher emitted.
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .publish()// This transform a cold publisher to hot publisher
                .refCount(2); // Define a min subscriber to start emitting item. 2 means that the items only will be emitted when there is 2 subscribers associated to this publisher

        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSecond(5);

        movieStream.subscribe(Util.subscriber("mike"));

        Util.sleepSecond(60);
    }
    private static Stream<String> getMovie(){
        System.out.println("Got the movie streaming request ");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
