package com.rp.section05.assignment;

import com.rp.courseutil.Util;
import lombok.Data;
import lombok.ToString;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private double price;
    private String category;
    private int quantity;

    public PurchaseOrder() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        this.item = Util.faker().commerce().productName();
        try {
            this.price = decimalFormat.parse(Util.faker().commerce().price()).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.category = Util.faker().commerce().department();
        this.quantity = Util.faker().random().nextInt(1, 10);
    }
}
