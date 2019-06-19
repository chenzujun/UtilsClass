package com.common.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间测试
 *
 * @author chenjun
 * @date 2019/6/19
 * @since V1.0.0
 */
public class DateUtilTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat foo = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("foo:" + foo.format(new Date()));

        Calendar gc = GregorianCalendar.getInstance();
        System.out.println("gc.getTime():" + gc.getTime());
        System.out.println("gc.getTimeInMillis():" + new Date(gc.getTimeInMillis()));

        // 当前系统默认时区的时间：
        Calendar calendar = new GregorianCalendar();
        System.out.print("时区：" + calendar.getTimeZone().getID() + "  ");
        System.out.println("时间：" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

//        getAvailableIDs();
        // 澳大利亚堪培拉
        TimeZone tz = TimeZone.getTimeZone("Australia/Canberra");
        // 时区转换
        calendar.setTimeZone(tz);
        System.out.print("时区：" + calendar.getTimeZone().getID() + "  ");
        System.out.println("时间：" + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));

        // 1、取得本地时间：
        java.util.Calendar cal = java.util.Calendar.getInstance();

        // 2、取得时间偏移量：
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);

        // 3、取得夏令时差：
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);

        // 4、从本地时间里扣除这些差量，即可以取得UTC时间：
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        // 之后调用cal.get(int x)或cal.getTimeInMillis()方法所取得的时间即是UTC标准时间。
        System.out.println("UTC:" + new Date(cal.getTimeInMillis()));

        Calendar calendar1 = Calendar.getInstance();
        TimeZone tztz = TimeZone.getTimeZone("GMT");
        calendar1.setTimeZone(tztz);
        System.out.println("GMT:" + calendar1.getTime());
        System.out.println(calendar1.getTimeInMillis());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date t = new Date();
        System.out.println("当前时间：" + df.format(t));
        // 待处理数据的时区
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        df1.setTimeZone(TimeZone.getTimeZone("Australia/Canberra"));
        // 转换为当前系统时区输出
        System.out.println("UTC："+df.parse("2019-06-19T17:08:43Z").toString());
        System.out.println("Australia/Canberra："+df1.parse("2019-06-19T17:08:43Z").toString());
    }


    public static final void getAvailableIDs(){
        // getting available Ids
        String[] availId = TimeZone.getAvailableIDs();

        // checking available Ids
        System.out.println("Available Ids are: ");
        for (int i=0; i<availId.length; i++){
            System.out.println(availId[i]);
        }
    }
}
