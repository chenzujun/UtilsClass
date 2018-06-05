package com.grammar.date;

import com.common.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author chenjun
 * @date 2018/5/2
 */
public class DateTool {
    public static void main(String[] args) {
        DatePagination();
    }


    public static void DatePagination(){
        String startDateStr = "2018-05-01";
        String endDateStr = "2018-05-15";

        Date beginDate = DateUtil.getDateFromString(startDateStr);
        Date endDate = DateUtil.getDateFromString(endDateStr);
        int intervalDay = DateUtil.daysBetween(beginDate, endDate);
        if(intervalDay > 10){
            int start = 0;
            int end = 9;
            System.out.println(DateUtil.addDay(endDate, 25));
            System.out.println(DateUtil.addDay(endDate, -end));
        }
    }


}
