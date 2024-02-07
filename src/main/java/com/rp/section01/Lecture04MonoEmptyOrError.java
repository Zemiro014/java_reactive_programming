package com.rp.section01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture04MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(3)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId){
        // 1
        if(userId == 1){
            return Mono.just(Util.faker().name().fullName());
        } else if(userId == 2){
            return Mono.empty(); //equivalent at null
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
