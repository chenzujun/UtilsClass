import java.util.ArrayList;
import java.util.List;

public class Test {
	public static int test() {
		int a = 10;
		int b = 0;

		try {
			System.out.println(a / b);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 20;
	}
	
	public static boolean isOdd(int i) {
		if(i%2 != 0){   //是奇数   
	        return true;   
	    }   
	    return false; 
	}

	public static void main(String[] args) throws Exception {
		System.out.println(isOdd(-1));
		System.out.println(isOdd(-2));
		System.out.println(isOdd(0));
		System.out.println(isOdd(3));
		System.out.println(Math.ceil(7/(6*1.0)));
	}
}
