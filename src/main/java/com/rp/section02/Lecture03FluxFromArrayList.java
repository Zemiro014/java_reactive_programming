package com.rp.section02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lecture03FluxFromArrayList {

    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("a", "b", "c");
//
//        Flux.fromIterable(strings)
//                .subscribe(Util.onNext());

        Integer[] arr = {1, 2, 3, 4, 6, 8};
        Flux.fromArray(arr)
                .subscribe(Util.onNext());
    }
}
