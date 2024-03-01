package com.rp.section12;

import com.rp.courseutil.Util;
import com.rp.section12.helper.BookService;
import com.rp.section12.helper.UserService;
import reactor.util.context.Context;

public class Lecture02ContextRateLimiterDemo {

    public static void main(String[] args) {

        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(Util.subscriber());
    }
}
