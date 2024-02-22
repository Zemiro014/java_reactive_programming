package com.rp.section04.helper;

import reactor.core.publisher.Flux;

public class UserService {

    public static Flux<User> getUsers(){
        return Flux.range(1, 2)
                .map(i -> new User(i));
    }
}
