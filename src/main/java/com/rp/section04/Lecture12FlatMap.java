package com.rp.section04;

import com.rp.courseutil.Util;
import com.rp.section04.helper.OrderService;
import com.rp.section04.helper.UserService;

public class Lecture12FlatMap {

    public static void main(String[] args) {

        UserService.getUsers()
//                .map(user -> OrderService.getOrder(user.getUserId())) // The getOrder method return a pusher, for this reason the map is not good using
                .flatMap(user -> OrderService.getOrder(user.getUserId())) // work better than map. Mono / flux
                .subscribe(Util.subscriber());


        Util.sleepSecond(60);
    }
}
