package com;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import com.caucho.hessian.client.HessianProxyFactory;
import com.zhenai.crm.message.share.model.CrmMessage;
import com.zhenai.crm.message.share.service.CrmMessageService;

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
		System.out.println(System.currentTimeMillis());

		try {
			Thread.sleep(40*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis());
	}
	
	public static void main(String[] args) {
		test t = new test();
		t.test();
	}
	
}
