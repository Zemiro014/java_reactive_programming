package com.rp.section12;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lecture01Context {

    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(Context.of("user", "Sam"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user")){
                return Mono.just("Welcome " +contextView.get("user"));
            } else {
                return Mono.error(new RuntimeException("Forbidden"));
            }
        });
    }
}
