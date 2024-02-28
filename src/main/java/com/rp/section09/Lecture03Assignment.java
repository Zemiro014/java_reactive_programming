package com.rp.section09;

import com.rp.courseutil.Util;
import com.rp.section09.helper.BookOrder;
import com.rp.section09.helper.RevenueReport;
import reactor.core.publisher.Flux;

import java.io.Flushable;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lecture03Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = Set.of(
                "Science fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream().filter(bookOrder -> allowedCategories.contains(bookOrder.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(bookOrders -> revenueCalculator(bookOrders))
                .subscribe(Util.subscriber());

        Util.sleepSecond(60);
    }

    private static RevenueReport revenueCalculator(List<BookOrder> books){
        Map<String, Double> map = books.stream()
                .collect(Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                ));
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream(){
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
