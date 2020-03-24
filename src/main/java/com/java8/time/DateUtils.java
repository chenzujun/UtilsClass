package com.java8.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author chenjun
 * @date 2018/6/21
 * @since V1.0.0
 */
public class DateUtils {

    public static void dateToLocalDate(Date date) {
        Instant instant = date.toInstant();

        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Date = " + date);
        System.out.println("LocalDate = " + localDate);
    }
}
