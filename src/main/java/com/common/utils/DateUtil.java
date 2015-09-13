package com.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DateUtil
{
	public static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static DateFormat formatstart = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	public static DateFormat formatend = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
	
	/**
	 * 按类型生产指定日期范围的数组
	 * 
	 * @param startdate
	 * @param enddate
	 * @param type 1 按日、2 按周、3 按月
	 * @return
	 */
	public static List<String> generateDateList(String startdate, String enddate, String type){
		List<String> resultList = new ArrayList<String>(); 
		
		Calendar startCalendar = Calendar.getInstance();
	    Calendar endCalendar = Calendar.getInstance();
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    SimpleDateFormat datedf = new SimpleDateFormat("yyyyMMdd");
	    SimpleDateFormat weekdf = new SimpleDateFormat("yyyy");// 周設置未知
	    SimpleDateFormat monthdf = new SimpleDateFormat("yyyyMM");
	    
	    try {
			Date startDate = df.parse(startdate);
			startCalendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置周一为一周第一天
			startCalendar.setTime(startDate);
			
			Date endDate = df.parse(enddate);
			endCalendar.setTime(endDate);
			
			if("1".equals(type)){
				while(true){
			        if(startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()){
			        	resultList.add(datedf.format(startCalendar.getTime()));
			        }else{
				        break;
				    }
			        startCalendar.add(Calendar.DAY_OF_MONTH, 1);
				}
			}else if ("2".equals(type)) {
				while(true){
			        if(startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()){
			        	resultList.add(weekdf.format(startCalendar.getTime())+startCalendar.get(Calendar.WEEK_OF_YEAR));
			        }else{
				        break;
				    }
			        // 设置下周第一天
			        startCalendar.add(Calendar.WEEK_OF_YEAR, 1);
			        startCalendar.set(Calendar.DAY_OF_WEEK, startCalendar.getFirstDayOfWeek());
				}
			}else if ("3".equals(type)) {
				while(true){
			        if(startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()){
			        	resultList.add(monthdf.format(startCalendar.getTime()));
			        }else{
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
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		
		try {
			// 设置开始时间
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
			map.put("startTime", formatstart.format(calendar.getTime()));
			
			// 设置当前时间
			calendar.setTime(new Date());
			map.put("endTime", format.format(calendar.getTime()));
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
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		
		try {
			// 设置开始时间
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
			map.put("startTime", formatstart.format(calendar.getTime()));
			
			// 设置当前时间
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			map.put("endTime", formatend.format(calendar.getTime()));
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
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		
		int currentMonth = calendar.get(Calendar.MONTH) + 1; 
		try {
			// 设置开始时间
			if (currentMonth >= 1 && currentMonth <= 3) 
				calendar.set(Calendar.MONTH, 0); 
			else if (currentMonth >= 4 && currentMonth <= 6) 
				calendar.set(Calendar.MONTH, 3); 
			else if (currentMonth >= 7 && currentMonth <= 9) 
				calendar.set(Calendar.MONTH, 6); 
			else if (currentMonth >= 10 && currentMonth <= 12) 
				calendar.set(Calendar.MONTH, 9);
			calendar.set(Calendar.DATE, 1);
			map.put("startTime", formatstart.format(calendar.getTime()));

			// 设置当前时间
			calendar.setTime(new Date());
			map.put("endTime", format.format(calendar.getTime()));
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
		Map<String, String> map = new HashMap<String, String>();
		// 获取Calendar
		Calendar calendar = Calendar.getInstance();
		
		// 设置开始时间
		try {
			calendar.set(Calendar.MONTH, calendar.getActualMinimum(Calendar.MONTH));
			calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
			map.put("startTime", formatstart.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		// 设置当前时间
		calendar.setTime(new Date());
		map.put("endTime", format.format(calendar.getTime()));
		return map;
	}
	
	public static List<Integer> getExecuteDaysOfTheMonth(Date month,List<Integer> holiday)
	{
		List<Integer> workDay = new ArrayList<Integer>();
		boolean isNoHoliday = holiday == null || holiday.size()==0; 
		int days = HycCommonUtils.getMonthDays(month);
		for( int i=1;i<=days;++i ){
			if (isNoHoliday || ! holiday.contains(i)) {
				workDay.add(i);
			}
		}
		return workDay ;	
	}
	
	public static Date getMarkDate(Date month, List<Integer> workday){
		Calendar c = Calendar.getInstance();
    	c.setTime(month);
    	c.set(Calendar.DAY_OF_MONTH, workday.get(2));
    	
    	return c.getTime();
	}
	
    public static void main(String[] args) throws ParseException
    {
//    	List<String> list = generateDateList("2015-09-01", "2015-09-30", "1");
//    	for (String string : list) {
//			System.out.println(string);
//		}
    	List<Integer> holiday = new ArrayList<Integer>();
    	holiday.add(2);
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date();
    	
    	List<Integer> workday = getExecuteDaysOfTheMonth(date, holiday);
    	System.out.println(df.format(getMarkDate(date, workday)));
    }
}
