package com.rp.section09.helper;

import com.github.javafaker.Book;
import com.rp.courseutil.Util;
import lombok.Data;
import lombok.ToString;

import java.text.DecimalFormat;
import java.text.ParseException;

@Data
@ToString
public class BookOrder {

    private String title;
    private String author;
    private String category;
    private double price;

    public BookOrder(){
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        try {
            this.price = decimalFormat.parse(Util.faker().commerce().price()).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Book book = Util.faker().book();
        this.title = book.title();
        this.author = book.author();
        this.category = book.genre();
    }
}
