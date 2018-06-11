package com.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @description: java8 time API测试
 * @author: mustang
 * @create: 2018-06-10
 **/
public class TimeTest {
    public static void testInstant(){
        // 精确到纳秒
        Instant start = Instant.now();
        try {
            Thread.sleep(1, 0);
        } catch (InterruptedException e) {
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        long millis = timeElapsed.toMillis();
        System.out.println("start="+start.getEpochSecond());
        System.out.println("  end="+end.getEpochSecond());
        System.out.println("millis="+millis);
    }

    public static void  testLocalDateTime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime="+localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(localDateTime.format(formatter));
    }

    public static void main(String[] args) {
        testInstant();

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate="+localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime="+localTime);

        testLocalDateTime();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime="+zonedDateTime);
    }
}
