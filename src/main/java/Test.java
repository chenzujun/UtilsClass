import java.util.ArrayList;
import java.util.Arrays;

import com.bean.User;

public class Test {
	public int test(Double a) {
		System.out.println(a);
		return 0;
	}
	public void test(int c, String b) {
		System.out.println(c+b);
	}
	public void test( String b,int c) {
		System.out.println(c+b);
	}
	public static void swap(User x, User y) {
		User tmp = x;
		x=y;
		y=tmp;
	}
	public static void main(String[] args) throws Exception {
		User[] u = new User[2];
		u[0] = new User("chen");
		u[1] = new User("jun");
		System.out.println(u.length);
		
		ArrayList<Integer> a = new ArrayList<>();
		
	}
}
