package com.rp.section02;

import com.rp.courseutil.Util;
import com.rp.section02.helper.NameGenerator;

import java.util.List;

public class Lecture07FluxVsList {

    public static void main(String[] args) {
        // When you call a List of item, it's gonna waiting to pass 5s before to show all items of list
        List<String> names = NameGenerator.getListNames(5);
        System.out.println(names);

        // When you call a Flux of item, it's gonna spending 5s to show all items. But in each second of 5s, 1 item will be showed until completed.
        NameGenerator.getFluxNames(5)
                .subscribe(Util.onNext());
    }
}
