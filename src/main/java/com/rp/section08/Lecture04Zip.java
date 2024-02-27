package com.rp.section08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple3;

public class Lecture04Zip {

    public static void main(String[] args) {

        // The quantity of items in zip, will be determined by publisher which is smallest of all
        Flux<Tuple3<String, String, String>> zip = Flux.zip(getBody(), getEngine(), getTires());
                zip.subscribe(Util.subscriber());

    }

    private static Flux<String> getBody(){
        return Flux.range(1, 5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine(){
        return Flux.range(1, 3)
                .map(i -> "engine");
    }

    private static Flux<String> getTires(){
        return Flux.range(1, 6)
                .map(i -> "tires");
    }
}
