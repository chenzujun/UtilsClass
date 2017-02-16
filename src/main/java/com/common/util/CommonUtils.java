package com.common.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang.time.DateUtils;

public class CommonUtils {

	/**
	 * 方法说明：把日期变成 2009-01-02这样的格式 创建日期：2009-2-23,下午02:24:03
	 * 
	 * @param date
	 * @return
	 */
	public static String formateDateToStr(Date date) {
		if(date == null) return null;
		// 一种格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		return df.format(date);
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
	 * @param date时间字符串
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
	 * @param date时间字符串
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
	 * @param date时间字符串
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

	/**
	 * 方法说明：今天的字符串 创建日期：2009-3-26,下午04:50:36
	 * 
	 * @return
	 */
	public static String todayToStr() {
		return formateDateToStr(new Date());
	}
	public static String todayToStr(String pattern) {
		return formateDateToStr(new Date(), pattern);
	}

	/**
	 * 方法说明：明天的字符串 创建日期：2009-3-26,下午04:51:57
	 * 
	 * @return
	 */
	public static String tomorrowToStr() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		return formateDateToStr(c.getTime());
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
	 * 方法说明：一个星期前字符串 创建日期：2009-4-21,下午04:03:07
	 * 
	 * @return
	 */
	public static String oneWeekaBeforeToStr() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -7);
		return formateDateToStr(c.getTime());
	}
	
	
	/**
	 * 这一天　星期几
	 * 1=星期天 2=星期１
	 */
	public static int getDayOfWeek(Date date){
		
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    return c.get(Calendar.DAY_OF_WEEK);
	
	}

	/**
	 * 一周里面第一天
	 * @param date
	 * @return
	 */
	public static Date firstDayOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	
	/**
	 * 一周里面最后一天
	 * @param date
	 * @return
	 */
	public static Date lastDayOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}
	
	/**
	 * 方法说明：一个月前字符串 创建日期：2009-4-21,下午04:03:07
	 * 
	 * @return
	 */
	public static String oneMonthBeforeToStr() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -30);
		return formateDateToStr(c.getTime());
	}

	/**
	 * 方法说明：任意天以前字符串 创建日期：2009-5-4,上午10:15:57
	 * 
	 * @param day
	 * @return
	 */
	public static String anyDayBeforeToStr(int day) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 0 - Math.abs(day));
		return formateDateToStr(c.getTime());
	}

	public static Date add(Date date, int field, int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, amount);
		return c.getTime();
	}

	public static String addMonth(Date date, int amount, String format) {
		Date tmpDate = add(date, Calendar.MONTH, amount);
		return formateDateToStr(tmpDate, format);
	}

	/**
	 * 方法说明：当前日期的月份第一天 创建日期：2009-5-11,下午06:47:27
	 * 
	 * @return
	 */
	public static String firstDayOfMonthToStr(Date date) {
		if (date == null)
			date = new Date();
		return formateDateToStr(date).replaceFirst("\\d{2}$", "01");
	}
	
	/**
	 * @param date
	 * @return
	 */
	public static Date firstDayOfMonth(Date date) {
		if (date == null)	date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取某个月的第一天，如2010-10-01
	 * 
	 * @param num
	 *            0表示当月、-1表示上月、1表示下月
	 * @return
	 */
	public static String firstDayOfAnyMonth(int num) {
		Date date = add(new Date(), Calendar.MONTH, num);
		return firstDayOfMonthToStr(date);
	}

	/**
	 * 获取某个月的最后一天，如2010-10-31
	 * 
	 * @param num
	 *            0表示当月、-1表示上月、1表示下月
	 * @return
	 */
	public static String lastDayOfAnyMonth(int num) {
		Date date = add(new Date(), Calendar.MONTH, num);
		return lastDayOfMonthToStr(date);
	}

	/**
	 * 方法说明：当前日期的月份的最后一天 创建日期：2009-5-11,下午06:56:32
	 * 
	 * @return
	 */
	public static String lastDayOfMonthToStr(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		int dm = c.get(Calendar.DAY_OF_MONTH);
		c.add(Calendar.DATE, -dm);
		return formateDateToStr(c.getTime());
	}

	public static Date lastDayOfMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		int dm = c.get(Calendar.DAY_OF_MONTH);
		c.add(Calendar.DATE, -dm);
		return c.getTime();
		
	}
	/**
	 * 方法说明：当前日期下个月的第一天 创建日期：2009-5-18,上午09:17:29
	 * 
	 * @param Date
	 * @return
	 */
	public static String firstDayOfNextMonthToStr(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		int dm = c.get(Calendar.DAY_OF_MONTH);
		c.add(Calendar.DATE, 1 - dm);
		return formateDateToStr(c.getTime());
	}

	/**
	 * 方法说明：求当前日期月份的天数 创建日期：2009-5-20,下午03:13:44
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthDays(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 方法说明：仅显示年月的中文月份 创建日期：2009-5-11,下午07:45:03
	 * 
	 * @return
	 */
	public static String chineseMonthYear() {
		return formateDateToStr(new Date()).replaceFirst("\\d{2}$", "")
				.replaceFirst("-", "年").replaceFirst("-", "月");
	}

	/**
	 * 方法说明：把2008年5月变成 2008-05-01 创建日期：2009-5-18,上午09:21:47
	 * 
	 * @return
	 */
	public static String chineseMonthYearToStr(String my) {
		return my.replaceAll("年|月", "-") + "01";
	}

	/**
	 * 方法说明：把2008年5月变成 2008-05-01日期 创建日期：2009-5-18,上午09:39:12
	 * 
	 * @param my
	 * @return
	 * @throws ParseException
	 */
	public static Date chineseMonthYearToDate(String my) throws ParseException {
		return parseDateFormStr(my.replaceAll("年|月", "-") + "01");
	}
	/**
	 * 把age=29变成1984-*-*（*是明天的日期）
	 * 
	 * @param age
	 * @return
	 */
	public static String getAccurateBirthdayByAge(Integer age){
		Calendar c = Calendar.getInstance();
		age = 0 - Math.abs(age);
		c.add(Calendar.YEAR, age);
		return strToNextDateStr(formateDateToStr(c.getTime()),"yyyy-MM-dd");
	}
	/**
	 * 方法说明：当查询表数据比较多时，使用这个函数 创建日期：2009-4-14,下午02:26:33
	 * 
	 * @param age
	 * @return
	 * @throws ParseException
	 */
	public static String getBirthdayByAge(Integer age) throws ParseException {
		Calendar c = Calendar.getInstance();
		age = 0 - Math.abs(age);
		c.add(Calendar.YEAR, age);
		return formateDateToStr(c.getTime()).replaceFirst(
				"(\\d{4})-\\d{2}-\\d{2}", "$1-01-01");
	}

	/**
	 * 方法说明：计算到现在的天数 创建日期：2009-7-9,上午11:44:23
	 * 
	 * @param begin
	 * @return
	 */
	public static Integer getDifferentDays(Date begin) {
		Date now;
		try {
			now = parseDateFormStr(formateDateToStr(new Date()));
			begin = parseDateFormStr(formateDateToStr(begin));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		long nms = now.getTime();
		long bms = begin.getTime();
		return (int) ((nms - bms) / (24 * 60 * 60 * 1000));
	}

	public static Integer getDifferentDays(Date begin, Date end) {
		try {
			end = parseDateFormStr(formateDateToStr(end));
			begin = parseDateFormStr(formateDateToStr(begin));
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
		long ems = end.getTime();
		long bms = begin.getTime();
		return (int) ((ems - bms) / (24 * 60 * 60 * 1000));
	}
	
	public static Integer getDifferentHours(Date begin, Date end) {
		try {
			end = parseDateFormStr(formateDateToStr(end,"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd HH:mm:ss");
			begin = parseDateFormStr(formateDateToStr(begin,"yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		long ems = end.getTime();
		long bms = begin.getTime();
		return (int) ((ems - bms) / (60 * 60 * 1000));
	}

	
	/**
	 * 排除这些天数之外的当月的其他的day
	 */
	public static List<Integer> getExecuteDaysOfTheMonth(Date month,List<Integer> holiday)
	{
		List<Integer> workDay = new ArrayList<Integer>();
		boolean isNoHoliday = holiday == null || holiday.size()==0; 
		int days = CommonUtils.getMonthDays(month);
		for( int i=1;i<=days;++i ){
			if (isNoHoliday || ! holiday.contains(i)) {
				workDay.add(i);
			}
		}
		return workDay ;	
	}
	
	
	/**
	 * 方法说明：方便处理字符串 创建日期：2009-3-16,下午02:54:24
	 * 
	 * @param obj
	 * @return string
	 */
	public static String evalString(Object obj) {
		if (obj == null)
			return "";
		return obj.toString();
	}
	
	public static String evalToNull(Object obj) {
		if (obj == null) return null;
		return StringUtils.trimToNull(obj.toString());
	}

	/**
	 * 方法说明：方便处理字符串 创建日期：2009-3-16,下午02:54:24
	 * 
	 * @param obj
	 * @return string
	 */
	public static int evalInt(Object obj) {
		if (obj == null)
			return -1000;
		return NumberUtils.toInt(obj.toString(), -1000);
	}

	public static int evalInt(Object obj, int defautValue) {
		if (obj == null)
			return defautValue;
		return NumberUtils.toInt(obj.toString(), defautValue);
	}

	/**
	 * 方法说明：方便处理字符串 创建日期：2009-4-10,上午11:49:45
	 * 
	 * @param obj
	 * @return
	 */
	public static long evalLong(Object obj) {
		if (obj == null)
			return -1000;
		return NumberUtils.toLong(obj.toString(), -1000);
	}

	/**
	 * 方法说明：方便处理字符串 创建日期：2009-4-10,上午11:49:45
	 * 
	 * @param obj
	 * @return
	 */
	public static long evalLong(Object obj, long defaultValue) {
		if (obj == null)
			return defaultValue;
		return NumberUtils.toLong(obj.toString(), defaultValue);
	}

	/**
	 * 方法说明：方便处理boolean 创建日期：2009-5-22,下午03:51:26
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean evalBoolean(Object obj) {
		if (obj == null)
			return false;
		return (Boolean) obj;
	}

	/**
	 * 方法说明：返回一个Number对象 创建日期：2009-5-25,下午02:30:50
	 * 
	 * @param obj
	 * @return
	 */
	public static Number evalNumber(Object obj) {
		if (obj == null)
			return null;
		try {
			return (Number) obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 方法说明：返回一个Number对象 创建日期：2009-5-25,下午02:30:50
	 * 
	 * @param obj
	 * @return
	 */
	public static Date evalDate(Object obj) {
		if (obj == null)
			return null;
		try {
			return (Date) obj;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 方法说明：把一个格式是yyyy-MM-dd的字符串生成日期 创建日期：2010-6-16,下午03:21:30
	 * 
	 * @param obj
	 * @return
	 */
	public static Date evalStrDate(Object obj) {
		if (obj == null)
			return null;
		try {
			return parseDateFormStr(obj.toString());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 方法说明：把一个格式是yyyy-MM-dd的字符串生成日期 创建日期：2010-6-16,下午03:21:30
	 * 
	 * @param obj
	 * @return
	 */
	public static Date evalStrDate(String obj,Date defaultDate) {
		if (StringUtils.isBlank(obj))
			return defaultDate;
		try {
			return parseDateFormStr(obj);
		} catch (Exception e) {
			return defaultDate;
		}
	}

	/**
	 * 方法说明：返回字符串数组. 创建日期：2010-8-2,上午10:26:03
	 * 
	 * @param str
	 * @return
	 */
	public static String[] evalStrToArray(String str) {
		String[] a = null;
		if (str != null) {
			a = str.split(",");
		}
		return a;
	}

	/**
	 * 方法说明：返回字符串数组. 创建日期：2010-8-2,上午10:26:03
	 * 
	 * @param str
	 * @return
	 */
	public static List<Long> evalStrToLongArray(String str) {
		String[] a = null;
		if (str != null) {
			a = str.split(",");
		}
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; a != null && i < a.length; i++) {
			long l = evalLong(StringUtils.trim(a[i]));
			if (l != -1000) {
				list.add(l);
			}
		}
		return list;
	}

	/**
	 * 方法说明：返回字符串数组. 创建日期：2010-8-2,上午10:26:03
	 * 
	 * @param str
	 * @return
	 */
	public static List<Integer> evalStrToIntegerArray(String str) {
		String[] a = null;
		if (str != null) {
			a = str.split(",");
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; a != null && i < a.length; i++) {
			int l = evalInt(StringUtils.trim(a[i]));
			if (l != -1000) {
				list.add(l);
			}
		}
		return list;
	}
	/**
	 * 方法说明：根据正则式返回它的相应匹配类 创建日期：2009-3-6,上午10:08:11
	 * 
	 * @return Matcher
	 */
	public static Matcher getMatcher(String regular, String input) {
		Pattern p = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		return m;
	}

	/**
	 * 方法说明：抛出一个运行时异常 创建日期：2009-3-6,上午10:27:36
	 * 
	 * @throws Exception
	 */
	public static void throwAnException(String condition, String sql)
			throws Exception {
		throw new RuntimeException("非法查询条件[" + condition + "]:" + sql);
	}

	/**
	 * 方法说明：连接list的内容 创建日期：2009-3-6,上午11:08:55
	 * 
	 * @param list
	 * @param symbol
	 * @param quote
	 * @return string
	 */
	public static String listJoin(List<? extends Object> list, String symbol,
			Boolean quote) {
		quote = quote == null ? false : quote;
		String st = quote ? "'" : "";
		String str = "";
		if (list == null || list.isEmpty())
			return "";
		int i = 0;
		for (; i < list.size() - 1; i++) {
			str += st + list.get(i).toString() + st + symbol;
		}
		str += st + list.get(i).toString() + st;
		return str;
	}

	/**
	 * 方法说明：这个是一个比IOUtils.toInputStream还要方便的方法 创建日期：2009-3-25,上午09:47:03
	 * 
	 * @param str
	 * @return InputStream
	 * @throws UnsupportedEncodingException
	 */
	public static InputStream toInputStream(String str) {
		String temp = str == null ? "" : str;
		try {
			return new ByteArrayInputStream(temp.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 方法说明：报表特殊的排序算法(当前列表已经是有序) 创建日期：2009-7-15,下午04:09:17
	 */
	public static void sortAlgorithm(List<Map<String, Object>> list,
			String sortField) {
		sortAlgorithms(list, sortField, 2);
	}

	/**
	 * 方法说明：报表特殊的排序算法(当前列表已经是有序)，精确到小数点后precision位
	 * 创建日期：2009-7-15,下午04:09:17,董吉改，copy hyc代码
	 */
	public static void sortAlgorithms(List<Map<String, Object>> list,
			String sortField, int precision) {
		if (list == null || list.isEmpty())
			return;
		if (precision < 0) {
			return;
		}
		Map<String, Object> first = list.get(0);
		Number pren = CommonUtils.evalNumber(first.get(sortField));
		if (pren == null)
			pren = 0;
		int hRand = 1;
		first.put("hRand", hRand);
		for (int i = 1; i < list.size(); i++) {
			Map<String, Object> item = list.get(i);
			Number n = CommonUtils.evalNumber(item.get(sortField));
			if (n == null) {
				item.put(sortField, 0);
				n = 0;
			}
			BigDecimal a = new BigDecimal(n.doubleValue());
			a = a.setScale(precision, BigDecimal.ROUND_HALF_UP);
			BigDecimal b = new BigDecimal(pren.doubleValue());
			b = b.setScale(precision, BigDecimal.ROUND_HALF_UP);
			double s = Math.abs(a.subtract(b).doubleValue());
			if (s >= 1 / Math.pow(10, precision)) {
				hRand = i + 1;
			}
			item.put("hRand", hRand);
			pren = n;
		}
	}

	/**
	 * 方法说明：去掉一些多余的排序信息 创建日期：2010-8-27,下午05:27:11
	 * 
	 * @param str
	 * @return
	 */
	public static void replaceList(List<Map<String, Object>> list, String[] keys) {
		if (list == null || list.isEmpty())
			return;
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> item = list.get(i);
			for (String key : keys) {
				String value = CommonUtils.evalString(item.get(key));
				if (value != null && value.length() > 0) {
					item.put(key,
							value.replaceFirst("^[0-9\\.\\-\\+\\s\\:]+", ""));
				}
			}
		}
	}

	/**
	 * 得到间隔工作日后的时间
	 * 
	 * @param startDate
	 * @param days
	 * @return
	 */
	public static Date getWorkDays(Date startDate, int days) {
		Date endDate = startDate;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		int count = 0;
		while (count < days) {
			cal.add(Calendar.DATE, 1);
			int day = cal.get(Calendar.DAY_OF_WEEK);
			if (day < 7 && day > 1) {
				count++;
			}
			endDate = cal.getTime();
		}
		return endDate;
	}

	public static <T> long[] parseLongArr(List<T> list) {
		if (list == null)
			return null;
		long[] arr = new long[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Long(list.get(i).toString());
		}
		return arr;
	}

	/**
	 * single是否包含于array
	 * 
	 * @param single
	 * @param ability
	 * @return
	 */
	public static boolean contains(int single, int[] array) {
		for (int element : array) {
			if (single == element) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * rangeValue是否包含containValue
	 * 
	 * @param rangeValue
	 * @param containValue
	 * @return
	 */
	public static boolean containsRange(String rangeValue, String regex,String containValue) {
		if(StringUtils.isNotBlank(rangeValue)){
			String[] range = rangeValue.split(regex);
			for(String v : range){
				if(StringUtils.isNotBlank(v)){
					if(v.equals(containValue)){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static <T> T ifThenElse(boolean bool, T a, T b) {
		return bool ? a : b;
	}

	/**
	 * 数组遍历
	 * 
	 * @param obj
	 * @param split
	 *            分割符
	 * @param emptyReplace
	 *            为空时内容为空时替换成什么
	 * @return
	 */
	public static String arrayToString(Object[] obj, String split,
			String emptyReplace) {
		if (ArrayUtils.isEmpty(obj))
			return "";
		if (!StringUtils.isNotBlank(split))
			split = ",";
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < obj.length; i++) {
			str.append(StringUtils.isBlank(obj[i].toString()) ? emptyReplace
					: obj[i].toString());
			if (i != obj.length - 1)
				str.append(split);
		}
		return str.toString();
	}
	public static String arrayToString(int[] obj, String split) {
		if (ArrayUtils.isEmpty(obj))
			return "";
		if (!StringUtils.isNotBlank(split))
			split = ",";
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < obj.length; i++) {
			str.append(obj[i]);
			if (i != obj.length - 1)
				str.append(split);
		}
		return str.toString();
	}

	public static double evalDouble(Object obj) {
		if (obj == null)
			return 0d;
		else if (StringUtils.isNotBlank(obj.toString()))
			return Double.parseDouble(obj.toString().trim());
		return 0d;
	}
	
	public static double evalDouble(Object obj, double defaultValue) {
		if (obj == null)
			return defaultValue;
		else if (StringUtils.isNotBlank(obj.toString()))
			return Double.parseDouble(obj.toString().trim());
		return 0d;
	}
	
	public static double evalFloat(Object obj) {
		if (obj == null)
			return 0f;
		else if (StringUtils.isNotBlank(obj.toString()))
			return Float.parseFloat(obj.toString().trim());
		return 0f;
	}
	
	public static float evalFloat(Object obj, float defaultValue) {
		if (obj == null)
			return defaultValue;
		else if (StringUtils.isNotBlank(obj.toString()))
			return Float.parseFloat(obj.toString().trim());
		return 0f;
	}

	/**
	 * 集合是否为空
	 */
	public static <T> boolean isEmpty(Collection<T> c) {
		if (c != null && c.size() > 0) {
			boolean flag = true;
			for (T t : c) {
				if (t != null) {
					flag = false;
				}
			}
			return flag;
		}
		return true;
	}

	public static <T> boolean isNotEmpty(Collection<T> c) {
		return !isEmpty(c);
	}
	
	public static <T> boolean isNotBlank(Collection<T> c) {
		if(c==null || c.size()==0)	return false;
		return true;
	}

	public static int[] evalIntArray(String[] str) {
		if (str == null || str.length == 0) {
			return null;
		}
		int[] arrs = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arrs[i] = Integer.parseInt(str[i].trim());
		}
		return arrs;
	}
	
	/**
	 * 整形转换为整形数组
	 * e.g. 23转换为{2,3}
	 * @param num
	 * @return
	 */
	public static int[] toIntArray(int num) {
		int i = Math.abs(num);
		int len = String.valueOf(i).length();
		int[] result = new int[len];
		int j = 0;
		while (true) {
			int temp = i % 10;
			result[j] = temp;
			i = i / 10;
			if (i == 0)
				break;
			++j;
		}
		return result;
	}

	public static Integer[] evalIntegerArray(String[] str) {
		if (str == null || str.length == 0) {
			return null;
		}
		Integer[] arrs = new Integer[str.length];
		for (int i = 0; i < str.length; i++) {
			if(str[i] == null) continue;
			arrs[i] = Integer.parseInt(str[i].trim());
		}
		return arrs;
	}

	public static long[] evalLongArray(String[] str) {
		long[] arrs = new long[str.length];
		for (int i = 0; i < str.length; i++) {
			arrs[i] = Long.parseLong(str[i].trim());
		}
		return arrs;
	}

	public static Date getCalendarField(Date paymentDate, String unit,
			Integer amount) {
		int field = Calendar.DAY_OF_MONTH;// 默认为day
		if ("year".equalsIgnoreCase(unit)) {
			field = Calendar.YEAR;
		} else if ("month".equalsIgnoreCase(unit)) {
			field = Calendar.MONDAY;
		} else if ("week".equalsIgnoreCase(unit)) {
			amount = amount * 7;
		}
		return CommonUtils.add(paymentDate, field, amount);
	}

	public static Integer zeroToNull(Integer num) {
		return num != null && num != 0 ? num : null;
	}

	public static float getRounding(float f) {
		DecimalFormat df = new DecimalFormat("#.00");
		return NumberUtils.toFloat(df.format(f));

	}
	
	/**去除小数点*/
	public static String formatFloat(Object value){
		if(value == null) return null;
		DecimalFormat df = new DecimalFormat("0");
		df.setDecimalSeparatorAlwaysShown(false);
		return df.format(value);
	}

	/**
	 * 获取客户端IP(穿透CDN与代理)
	 * 
	 * @param request
	 * @return
	 */
	/*public static String getRealRemoteIp(HttpServletRequest request) {
		String ip = request.getHeader("Cdn-Src-Ip");
		request.setAttribute("Cdn_Src_Ip", ip == null ? "null" : ip);
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("x-forwarded-for");
			request.setAttribute("x_forwarded_for", ip == null ? "null" : ip);
		}
		if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			request.setAttribute("RemoteAddr", ip == null ? "null" : ip);
		}
		return ip;
	}*/
	public static String getRealRemoteIp(HttpServletRequest request) {
		String ipAddress = request.getHeader("Cdn-Src-Ip");
		request.setAttribute("Cdn_Src_Ip", ipAddress == null ? "null" : ipAddress);
		if(StringUtils.isBlank(ipAddress) ||  "unknown".equalsIgnoreCase(ipAddress)){
			ipAddress = request.getHeader("x-forwarded-for");
			request.setAttribute("x_forwarded_for", ipAddress == null ? "null" : ipAddress);
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			request.setAttribute("RemoteAddr", ipAddress == null ? "null" : ipAddress);
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
	
	public static boolean isIe(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		boolean isIe = false;
		//ie11 以上的版本去掉了MSIE，增加了特有的“rv:”
		if (header != null && (header.indexOf("MSIE") > -1 || header.indexOf("Trident") > -1)) {
			isIe = true;
		}
		return isIe;
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

	public static String replace(String src, String regex,
			String... replacement) {
		if (src == null)
			return null;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(src);
		int gc = 0;
		while (matcher.find()) {
			if (replacement[gc] != null) {
				src = src.replace(matcher.group(), replacement[gc]);
			}
			++gc;
		}
		return src;
	}
	
	public static String colourReplace(String src, String regex,
			String replacement) {
		if (src == null) return null;
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(src);
		return matcher.replaceAll(replacement);
		/*boolean find = matcher.find();
		while(find){
			String delayReplace = matcher.group();
			src = src.replace(delayReplace, String.format(replacement, delayReplace));
			find = matcher.find();
		}
		return src;*/
	}

	/** 根据正则表达式取第几个匹配值 顺序从1开始 可以更层次匹配数据 */
	public static String getMatchValue(String src, String regex, int sequence,
			String[] subRegex, int[] subSeq) {
		String result = null;
		if (src == null)
			return result;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(src);
		int gc = 1;
		while (matcher.find()) {
			if (gc == sequence) {
				result = matcher.group();
				if (subRegex != null && subRegex.length > 0) {
					for (int i = 0; i < subRegex.length; i++) {
						result = getMatchValue(result, subRegex[i], subSeq[i],
								null, null);
					}
				}
				break;
			}
			++gc;
		}
		return result;
	}

	/**
	 * 将某个整数的第几位设置成0或者1
	 * 
	 * @param targetNum
	 *            要更改的整数
	 * @param position
	 *            整数的第几位
	 * @param resultNum
	 *            置0或者置1
	 * @return
	 */
	public static int changeBinaryVal(int targetNum, int position, int resultNum) {
		if (position <= 0 || resultNum < 0) {
			return -1;
		}
		Double en = Math.pow(2, position - 1);
		int n = en.intValue();
		int result = 0;
		if (resultNum == 0) {
			result = targetNum & ~n;
		} else if (resultNum == 1) {
			result = targetNum |= n;
		}
		return result;
	}	
	
	
	/**
	 * 判断是否购具有某种服务，对应处理userInfo的health字段 
	 * 
	 * @param targetNum
	 *            要判断的整数
	 * @param position
	 *            整数的第几位
	 * @return
	 */
	public static boolean isBuyMail(int targetNum, int position) {
		if (position <= 0) {
			return false;
		}
		Double en = Math.pow(2, position - 1);
		int value = en.intValue();
        return (targetNum & value) == value; 
	}	
	
	
	
	
	/** 是否能访问指定URL */
	public static boolean access(String urlStr) {
		boolean result = false;
		if (StringUtils.isBlank(urlStr))
			return result;
		if(!StringUtils.startsWith(urlStr.toLowerCase(), "http://")){
			urlStr = "http://" + urlStr;
		}
		try {
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			int reponseCode = connection.getResponseCode();
			if (reponseCode == HttpURLConnection.HTTP_OK || 
					reponseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
				result = true;
			}
		} catch (Exception e) {
			 return false;
		}
		return result;
	}

	public static int calcDays(Date d1, Date d2) {
		if(d1 == null || d2 == null) return 0;
		return (int) ((d1.getTime() - d2.getTime()) / (24 * 60 * 60 * 1000));
	}
	
	/**
	 * 将数组objects组成以分隔符separator 相隔的字符串
	 * @param objects
	 * @param separator
	 * @return
	 */
	public static String join(Object[] objects,String separator){
		if(objects == null || objects.length < 1)return null;
		if(separator == null) return null;
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<objects.length;i++){
			sb.append(objects[i]);
			if(i < (objects.length -1)){
				sb.append(separator);
			}
		}
		return sb.toString();
	}
	/**
	 * 获取当前日期
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date getCurDate(Date date) throws ParseException{
		return parseDateFormStr(formateDateToStr(date));
	}
	
	public static String getTvPhone(String phone) {
		if (StringUtils.isBlank(phone)) return phone;
		char[] arr = phone.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (i >= 3) {
				arr[i] = String.valueOf((int)(Math.random() * 10)).charAt(0);
			} 
		}
		phone = String.valueOf(arr);
		return phone;
	}
	
	/**获取指定月份总共有多少周*/
	public static int getWeeksOfMonth(Date date){
		int result = 0;
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(date);
		int curYear = tmp.get(Calendar.YEAR);
		int curMonth = tmp.get(Calendar.MONTH)+1;
		Calendar c = Calendar.getInstance();
		for(int i=1; i<=6; i++){//一个月最多5个星期
			c.setTime(date);
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c.set(Calendar.WEEK_OF_MONTH, i);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			if(year==curYear && month==curMonth){
				++result;
			}
		}
		return result;
	}
	
	public static boolean isMonday(Date date){
		Calendar c = Calendar.getInstance();
		String dateStr = CommonUtils.formateDateToStr(date);
		Date tmpDate = CommonUtils.parseDateFormStr(dateStr,"yyyy-MM-dd");
		long curDate = tmpDate.getTime();
		for (int i = 1; i <= 6; i++) {
			c.setTime(tmpDate);
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			c.set(Calendar.WEEK_OF_MONTH, i);
			if(c.getTime().getTime() == curDate){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断是否是周末
	 * @return
	 */
	public static boolean isWeekendDay(Date date){
		    Calendar cal=Calendar.getInstance();
		    cal.setTime(date);
			int week=cal.get(Calendar.DAY_OF_WEEK)-1;
			if(week ==6 || week==0){//0代表周日，6代表周六
				return true;
			}
			return false;
	}
	
	/**
	 * 根据指定日期返回日期在哪个月的第几周<br/>
	 * 两个key，分别为month和week
	 * @param date
	 * @return
	 */
	public static Map<String,Object> getWeekInfo(Date date){
		if (date == null) return null;
		int week = 0;
		Calendar tmp = Calendar.getInstance();
		tmp.setTime(date);
		int curYear = tmp.get(Calendar.YEAR);
		int curMonth = tmp.get(Calendar.MONTH)+1;
		Calendar c = Calendar.getInstance();
		String dateStr = CommonUtils.formateDateToStr(date);
		long curDate = CommonUtils.parseDateFormStr(dateStr,"yyyy-MM-dd").getTime();
		long firstWeekDate1 = 0;
		long firstWeekDate2 = 0;
		for(int i=1; i<=6; i++){//一个月最多5个星期
			c.setTimeInMillis(curDate);
			c.setFirstDayOfWeek(Calendar.MONDAY);
			c.set(Calendar.WEEK_OF_MONTH, i);
			c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1;
			if(year==curYear && month==curMonth){
				++ week;
				long begin = c.getTime().getTime();
				long end = CommonUtils.add(c.getTime(), Calendar.DATE, 6).getTime();
				if(curDate>=begin && curDate<=end){
					break;
				}
			}
			if(i == 1) {
				firstWeekDate1 = c.getTime().getTime();
				firstWeekDate2 = CommonUtils.add(c.getTime(), Calendar.DATE, 6).getTime();
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("month", CommonUtils.firstDayOfMonthToStr(date));
		result.put("week", week);
		int weeks = CommonUtils.getWeeksOfMonth(date);
		if(curDate>=firstWeekDate1 && curDate<=firstWeekDate2  && weeks == week){
			Date month = DateUtils.addMonths(date, -1);
			int weeksTmp = CommonUtils.getWeeksOfMonth(month);
			result.put("month", CommonUtils.firstDayOfMonthToStr(month));
			result.put("week", weeksTmp);
		}
		return result;
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
	
	public static boolean isNum(String string){
		if(StringUtils.isBlank(string)){
			return false;
		}
		try {
		    Integer.valueOf(string);//把字符串强制转换为数字
		    return true;//如果是数字，返回True
		} catch (Exception e) {
		    return false;//如果抛出异常，返回False
		}
	}
	
	/**
	 * 把JavaBean转换成map
	 * @param bean
	 * @return
	 * @throws IntrospectionException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static Map<String, Object> convertBean(Object bean) throws IntrospectionException, 
		IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		Class<? extends Object> type = bean.getClass();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		BeanInfo beanInfo = Introspector.getBeanInfo(type);

		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();
			if (!propertyName.equals("class")) {
				returnMap.put(propertyName, propertyUtilsBean.getNestedProperty(bean, propertyName));
			}
		}
		return returnMap;
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
	
	public static <E> List<E> deduplication(List<E> list){
		if(list == null){
			return null;
		}
		List<E> tempList = new ArrayList<E>();
		for(E i : list){
			if(!tempList.contains(i)){
				tempList.add(i);
			}
		}
		return tempList;
		
	}
	
	/*public static int compareDateWithoutTime(Date date1,Date date2){
		if(date1 == null || date2 == null){
			throw new RuntimeException("时间不能为null");
		}
		DateTime dateTime1 = new DateTime(date1);
		DateTime dateTime2 = new DateTime(date2);
		return dateTime1.withMillisOfDay(0).compareTo(dateTime2.withMillisOfDay(0));
	}*/
	
	public static int compareDateWithoutTime(Date date1,Date date2){
		if(date1 == null || date2 == null){
			throw new RuntimeException("时间不能为null");
		}
		try {
			date1 = CommonUtils.parseDateFormStr(CommonUtils.formateDateToStr(date1, "yyyy-MM-dd"));
			date2 = CommonUtils.parseDateFormStr(CommonUtils.formateDateToStr(date2, "yyyy-MM-dd"));
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
	
	public static void main(String[] args) throws Exception {
         System.out.println(CommonUtils.formateDateToStr(getFirstWeekEndDate(new Date(), 1)));
	}
}