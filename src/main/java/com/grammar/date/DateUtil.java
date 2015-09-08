package com.grammar.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil
{
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
			        System.out.println(datedf.format(startCalendar.getTime()));
			        startCalendar.add(Calendar.WEEK_OF_YEAR, 1);
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
	
    public static String fomatDate(String date, String newStyle, String originalStyle)
    {
      try
      {
        SimpleDateFormat sdf = new SimpleDateFormat(originalStyle);
        SimpleDateFormat sdf2 = new SimpleDateFormat(newStyle);
        Date tempDate = sdf.parse(date);
        return sdf2.format(tempDate);
      }
      catch (ParseException e) {
      }
      return "";
    }
    
    public static void main(String[] args) throws ParseException
    {
        System.out.println(fomatDate("26/05/2015 11:33:22", "yyyy-MM-dd hh:mm:ss", "dd/MM/yyyy hh:mm:ss"));
    }
}
