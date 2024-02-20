package com.rp.section03;

import com.rp.courseutil.Util;
import com.rp.section03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lecture08FilereaderServiceAssignment {

    public static void main(String[] args) {

        FileReaderService readerService = new FileReaderService();

        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");

        readerService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if(integer > 8)
                        throw new RuntimeException("OOPS");
                    return s;
                })
                .take(20)
                .subscribe(Util.subscriber());
    }
}
