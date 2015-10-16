package com.grammar.date;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
			c.add(Calendar.MONTH, 1);
			
			System.out.println(c.getTime());
			
			Calendar c2 = Calendar.getInstance();
			c2.setTime(new Date());
			
				System.out.println(c2.after(c));
	}

}
