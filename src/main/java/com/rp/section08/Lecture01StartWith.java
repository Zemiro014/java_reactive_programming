package com.rp.section08;

import com.rp.courseutil.Util;
import com.rp.section08.helper.NameGenerator;

public class Lecture01StartWith {

    public static void main(String[] args) {


        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("Sam"));

        // Will consume only the items produced by cache if in the cache there is 2 items otherwise will consume the refresh item too.
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("Mike"));

        // Will consume only the items produced by cache if in the cache there is 3 items otherwise will consume the refresh item too.
        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("Jak"));

        // Will consume only the items produced by cache if in the cache there is 2 item which start with "A" otherwise will consume the refresh item too.
        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("Marshal"));

    }
}
