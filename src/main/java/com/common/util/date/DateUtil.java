package com.common.util.date;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 非线程安全
 * @author mustang
 */
public class DateUtil {
    private static final String DATE_FMT = "yyyy-MM-dd";

    public static DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DateFormat FORMAT_START = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    public static DateFormat FORMAT_END = new SimpleDateFormat("yyyy-MM-dd 23:59:59");

    /**
     * 带时区的日期格式
     */
    public static final String Format_DateTime_UTC = "yyyy-MM-dd HH:mm:ss Z";
    public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";

    public static Date getDateFromString(String dateStr) {
        Date date = null;
        try {
            if (StringUtils.isEmpty(dateStr)) {
                return new Date();
            }
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FMT);
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date addDay(Date date, int interval){
        GregorianCalendar gc =new GregorianCalendar();
        gc.setTime(date);
        gc.add(GregorianCalendar.DAY_OF_MONTH, interval);

        return gc.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FMT);
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(betweenDays));
    }

    /**
     * 按类型生产指定日期范围的数组
     *
     * @param startdate
     * @param enddate
     * @param type      1 按日、2 按周、3 按月
     * @return
     */
    public static List<String> generateDateList(String startdate, String enddate, String type) {
        List<String> resultList = new ArrayList<String>();

        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat datedf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat weekdf = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthdf = new SimpleDateFormat("yyyyMM");

        try {
            Date startDate = df.parse(startdate);
            // 设置周一为一周第一天
            startCalendar.setFirstDayOfWeek(Calendar.MONDAY);
            startCalendar.setTime(startDate);

            Date endDate = df.parse(enddate);
            endCalendar.setTime(endDate);

            if ("1".equals(type)) {
                while (true) {
                    if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
                        resultList.add(datedf.format(startCalendar.getTime()));
                    } else {
                        break;
                    }
                    startCalendar.add(Calendar.DAY_OF_MONTH, 1);
                }
            } else if ("2".equals(type)) {
                while (true) {
                    if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
                        resultList.add(weekdf.format(startCalendar.getTime()) + startCalendar.get(Calendar.WEEK_OF_YEAR));
                    } else {
                        break;
                    }
                    // 设置下周第一天
                    startCalendar.add(Calendar.WEEK_OF_YEAR, 1);
                    startCalendar.set(Calendar.DAY_OF_WEEK, startCalendar.getFirstDayOfWeek());
                }
            } else if ("3".equals(type)) {
                while (true) {
                    if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
                        resultList.add(monthdf.format(startCalendar.getTime()));
                    } else {
                        break;
                    }
                    startCalendar.add(Calendar.MONTH, 1);
                    startCalendar.set(Calendar.DATE, startCalendar.getActualMinimum(Calendar.DATE));
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    /**
     * 获取当月的开始时间和当前时间
     *
     * @return
     */
    public static Map<String, String> getCurrentMonthTime() {
        Map<String, String> map = new HashMap<>(2);
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();

        try {
            // 设置开始时间
            calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
            map.put("startTime", FORMAT_START.format(calendar.getTime()));

            // 设置当前时间
            calendar.setTime(new Date());
            map.put("endTime", FORMAT.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取上个月的开始时间和上个月的结束时间
     *
     * @return
     */
    public static Map<String, String> getLastMonthTime() {
        Map<String, String> map = new HashMap<>(4);
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        try {
            // 设置开始时间
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            map.put("startTime", FORMAT_START.format(calendar.getTime()));

            // 设置当前时间
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            map.put("endTime", FORMAT_END.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取本季度的开始时间和当前时间
     *
     * @return
     */
    public static Map<String, String> getCurrentQuarterTime() {
        Map<String, String> map = new HashMap<>(4);
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();

        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        try {
            // 设置开始时间
            if (currentMonth >= 1 && currentMonth <= 3){
                calendar.set(Calendar.MONTH, 0);
            }
            else if (currentMonth >= 4 && currentMonth <= 6){
                calendar.set(Calendar.MONTH, 3);
            }
            else if (currentMonth >= 7 && currentMonth <= 9){
                calendar.set(Calendar.MONTH, 6);
            }
            else if (currentMonth >= 10 && currentMonth <= 12){
                calendar.set(Calendar.MONTH, 9);
            }

            calendar.set(Calendar.DATE, 1);
            map.put("startTime", FORMAT_START.format(calendar.getTime()));

            // 设置当前时间
            calendar.setTime(new Date());
            map.put("endTime", FORMAT.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 获取本年的开始时间和当前时间
     *
     * @return
     */
    public static Map<String, String> getCurrentYearTime() {
        Map<String, String> map = new HashMap<>(4);
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();

        // 设置开始时间
        try {
            calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
            calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
            map.put("startTime", FORMAT_START.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 设置当前时间
        calendar.setTime(new Date());
        map.put("endTime", FORMAT.format(calendar.getTime()));
        return map;
    }

    public static Date getMarkDate(Date month, List<Integer> workday) {
        Calendar c = Calendar.getInstance();
        c.setTime(month);
        c.set(Calendar.DAY_OF_MONTH, workday.get(2));

        return c.getTime();
    }

    /**
     * 方法说明：任意格式化 创建日期：2010-8-18,下午04:40:31
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String formateDateToStr(Date date, String formatStr) {
        if(date == null) return null;
        // 一种格式
        SimpleDateFormat df = new SimpleDateFormat(formatStr);
        return df.format(date);
    }

    /**
     * 方法说明：把格式好的字符串生成日期 创建日期：2009-5-4,上午11:31:30
     *
     * @param source
     * @return
     * @throws ParseException
     */
    public static Date parseDateFormStr(String source) throws ParseException {
        if(source == null) return null;
        // 一种格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return df.parse(source);
    }

    /**
     * 方法说明：格式化日期 创建日期：2010-8-1,下午01:25:45
     *
     * @param source
     * @param formatStr
     * @return
     * @throws ParseException
     */
    public static Date parseDateFormStr(String source, String formatStr) {
        if (StringUtils.isNotBlank(source)) {
            // 一种格式
            SimpleDateFormat df = new SimpleDateFormat(formatStr);
            try {
                return df.parse(source);
            } catch (ParseException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 将一个时间字符串转化为时间的下一天并返回字符串
     *
     * @param date 时间字符串
     * @param pattern
     *            时间格式
     * @return 传入 2011-11-02 返回2011-11-03
     */
    public static String strToNextDateStr(String date, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DATE, 1);
        return df.format(cal.getTime());
    }

    /**
     * 将一个时间字符串转化为时间的前一天并返回字符串
     *
     * @param date 时间字符串
     * @param pattern
     *            时间格式
     * @return 传入 2011-11-02 返回2011-11-01
     */
    public static String strToPrevDateStr(String date, String pattern) {
        return strToPrevDateStr(date, pattern, -1);
    }

    /**
     * 将一个时间字符串转化为时间的前/后day天并返回字符串
     *
     * @param date 时间字符串
     * @param pattern
     *            时间格式
     * @param day
     * 			 多少天
     * @return
     */
    public static String strToPrevDateStr(String date, String pattern, int day) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(df.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DATE, day);
        return df.format(cal.getTime());
    }

    public static String todayToStr(String pattern) {
        return formateDateToStr(new Date(), pattern);
    }

    public static Date tomorrow() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    public static String tomorrowToStr(String pattern) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return formateDateToStr(c.getTime(), pattern);
    }

    /**
     * 方法说明：把2008年5月变成 2008-05-01 创建日期：2009-5-18,上午09:21:47
     *
     * @return
     */
    public static String chineseMonthYearToStr(String my) {
        return my.replaceAll("年|月", "-") + "01";
    }

    /**去除小数点*/
    public static String formatFloat(Object value){
        if(value == null){
            return null;
        }
        DecimalFormat df = new DecimalFormat("0");
        df.setDecimalSeparatorAlwaysShown(false);
        return df.format(value);
    }

    public static Calendar toCalendar(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c;
    }

    public static int getDay(Date d) {
        return toCalendar(d).get(Calendar.DAY_OF_MONTH);
    }

    public static int getToday() {
        return toCalendar(new Date()).get(Calendar.DAY_OF_MONTH);
    }

    public static int getDay(Calendar c) {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHour(Date d) {
        return toCalendar(d).get(Calendar.HOUR_OF_DAY);
    }

    public static int getHour(Calendar c) {
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinute(Calendar c) {
        return c.get(Calendar.MINUTE);
    }

    public static int calcDays(Date d1, Date d2) {
        if(d1 == null || d2 == null) return 0;
        return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
    }

    /**
     * 判断是否是周末
     * @return
     */
    public static boolean isWeekendDay(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        int week=cal.get(Calendar.DAY_OF_WEEK)-1;
        if(week ==6 || week==0){
            //0代表周日，6代表周六
            return true;
        }
        return false;
    }

    /**
     * 清除时分秒
     * @param date
     * @return
     */
    public static Date clearHMS(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 把时分秒跳到23点59分59秒
     * @param date
     * @return
     */
    public static Date fullHMS(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    public static long getIntervalMinutes(Date dateStart, Date dateEnd) {
        long intervalSecond = (dateEnd.getTime() - dateStart.getTime()) / 1000;
        long divValue = intervalSecond / 60;
        long modValue = intervalSecond % 60;
        return divValue == 0 ? 1 : modValue >= 30 ? divValue + 1 : divValue;
    }

    public static boolean isTheSameMonth(Date date1) {
        return isTheSameMonth(date1, new Date());
    }

    public static boolean isTheSameMonth(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
    }

    public static int compareDateWithoutTime(Date date1,Date date2){
        if(date1 == null || date2 == null){
            throw new RuntimeException("时间不能为null");
        }
        try {
            date1 = DateUtil.parseDateFormStr(DateUtil.formateDateToStr(date1, "yyyy-MM-dd"));
            date2 = DateUtil.parseDateFormStr(DateUtil.formateDateToStr(date2, "yyyy-MM-dd"));
        } catch (ParseException e) {
        }
        return date1.compareTo(date2);
    }

    /**
     * 获取当前日期 第几周的周末日期
     * @param date
     * @param count
     * @return
     */
    public static Date getLastWeekEndDate(Date date,int count){
        Calendar ca=Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        ca.add(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, count*7);
        return ca.getTime();
    }
    /**
     * 判断两个日期相差月数
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        return result == 0 ? 1 : Math.abs(result);
    }

    /**
     * 获取当前日期 第几周的开始日期
     * @param date
     * @param count
     * @return
     */
    public static Date getFirstWeekEndDate(Date date,int count){
        Calendar ca=Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        ca.add(Calendar.DAY_OF_MONTH, 1);
        ca.add(Calendar.DAY_OF_MONTH, count*7);//周末
        ca.add(Calendar.DAY_OF_MONTH, -1);
        ca.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return ca.getTime();
    }

    /**
     * 获取当前日期 第几月的月末日期
     * @param date
     * @param count
     * @return
     */
    public static Date getLastDayOfMonth(Date date,int count){
        Calendar end = Calendar.getInstance();
        end.setTime(date);
        end.add(Calendar.MONTH, count);
        end.set(Calendar.DAY_OF_MONTH, end.getActualMaximum(Calendar.DAY_OF_MONTH));
        end.set(Calendar.SECOND, 59);
        end.set(Calendar.HOUR_OF_DAY, 23);
        end.set(Calendar.MINUTE, 59);
        return end.getTime();
    }

    /**
     * 获取当前日期 第几月的月初日期
     * @param date
     * @param count
     * @return
     */
    public static Date getFirstDayOfMonth(Date date,int count){
        Calendar begin = Calendar.getInstance();
        begin.setTime(date);
        begin.add(Calendar.MONTH, count);
        begin.set(Calendar.DAY_OF_MONTH, begin.getActualMinimum(Calendar.DAY_OF_MONTH));
        begin.set(Calendar.SECOND, 0);
        begin.set(Calendar.HOUR_OF_DAY, 0);
        begin.set(Calendar.MINUTE, 0);
        return begin.getTime();
    }

    public static String formatTime(Date date, String format) {
        String s = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            s = sdf.format(date);
        }

        return s;
    }

    public static Date parseDate(String s, String format) {
        Date date = null;
        if (org.apache.commons.lang3.StringUtils.isNotBlank(s)) {
            try {
                date = (new SimpleDateFormat(format)).parse(s);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return date;
    }

    public static void main(String[] args) {
        List<Integer> holiday = new ArrayList<Integer>();
        holiday.add(2);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

    }
}
