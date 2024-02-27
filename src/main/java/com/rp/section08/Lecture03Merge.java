package com.rp.section08;

import com.rp.courseutil.Util;
import com.rp.section08.helper.AmericanAirlines;
import com.rp.section08.helper.Emirates;
import com.rp.section08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lecture03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(Util.subscriber());
        Util.sleepSecond(10);
    }
}
