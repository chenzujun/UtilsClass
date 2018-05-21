import org.apache.commons.lang.StringUtils;

import java.util.Calendar;

public class Test {

	private static String extractStr(String obj, int index){
		if(StringUtils.isEmpty(obj)){
			return null;
		}
		String[] arr = obj.split("\\|");
		System.out.println(arr.length);
		return arr[index];
	}

	public static void main(String[] args) throws Exception {
		System.out.println(extractStr("abc|12_12",0));
	}
}
