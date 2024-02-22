package com.rp.section05;

import com.rp.courseutil.Util;
import com.rp.section05.assignment.InventoryService;
import com.rp.section05.assignment.OrderService;
import com.rp.section05.assignment.RevenueService;

import java.util.Locale;

public class Lecture06Assignment {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inventory - observe the order stream
        orderService.orderStream().subscribe(revenueService.subscriberOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscriberOrderStream());

        inventoryService.inventoryStream()
                .doOnError(throwable -> {
                    System.out.println("ERROR : "+throwable.getMessage());
                })
                .subscribe(Util.subscriber("Inventory"));
        revenueService.revenueStream()
                .doOnError(throwable -> {
                    System.out.println("ERROR : "+throwable.getMessage());
                })
                .subscribe(Util.subscriber("Revenue"));

        Util.sleepSecond(60);
    }
}
