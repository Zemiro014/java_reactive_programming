package com.rp.section09.helper;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;


@ToString
public class RevenueReport {

    private LocalDateTime localDateTime = LocalDateTime.now();
    private Map<String, Double> evenue;

    public RevenueReport(Map<String, Double> evenue) {
        this.evenue = evenue;
    }
}
