package com.rp.section08.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    List<String> names = new ArrayList<>();
    public Flux<String> generateNames(){
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("Generate fresh");
            Util.sleepSecond(1);
            String name = Util.faker().name().firstName();
            names.add(name);
            stringSynchronousSink.next(name);
        })
        .cast(String.class)
        .startWith(getFromCache());
    }

    private Flux<String> getFromCache(){
        return Flux.fromIterable(names);
    }
}
