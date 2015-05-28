package com.grammar.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
    
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
