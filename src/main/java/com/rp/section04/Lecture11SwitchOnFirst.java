package com.rp.section04;

import com.rp.courseutil.Util;
import com.rp.section04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture11SwitchOnFirst {

    public static void main(String[] args) {
        getPerson()
                .switchOnFirst(((signal, personFlux) -> {
                    System.out.println("Inside switchOnFirst");
                   return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                }))
                .subscribe(Util.subscriber());

    }

    public static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return personFlux -> personFlux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class , p -> System.out.println("Not allowing : "+p));
    }
}
