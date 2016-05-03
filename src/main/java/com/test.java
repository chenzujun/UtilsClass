package com;

import java.util.Calendar;

public class test {

	private boolean isFourthWorkingDay(){
		Calendar calendar = Calendar.getInstance();
		int now = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(now);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)+"=1");
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)+"=2");
		int count = 0;
		while (count < 4) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY 
					&& calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++count;
			}
			
		}
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		return calendar.get(Calendar.DAY_OF_MONTH) == now;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stubnew
		System.out.println(new test().isFourthWorkingDay());
	}

}
