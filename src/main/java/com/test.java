package com;

import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;

public class test {

    public static void method(List<String> list) {  
        System.out.println("invoke method(List<String> list)");  
    }  
  
    public static int method(List<Integer> list) {  
        System.out.println("invoke method(List<Integer> list)");  
        return 1;
    }  
  
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
	
	public void test(){
		
	}
	
	public static void main(String[] args) throws MalformedURLException {
		
		System.out.println(Double.parseDouble("1321.00"));
	}
	
}
