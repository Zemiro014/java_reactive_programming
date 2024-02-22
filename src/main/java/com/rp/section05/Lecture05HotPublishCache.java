package com.rp.section05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture05HotPublishCache {
    public static void main(String[] args) {

        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .cache(); // cache = publish().replay(). It's means that, when a new subscriber is associated, this new subscriber will start receiving immediately the items cached

        Util.sleepSecond(2);
        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSecond(7);

        movieStream.subscribe(Util.subscriber("mike"));
        System.out.println("Mike is joining");

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
