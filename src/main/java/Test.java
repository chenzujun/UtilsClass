

public class Test {
	static final int low = -128;
	
	public static void main(String[] args) {
		Integer i = 129;
		 int h = 127;
		Integer ii =Integer.valueOf(127);
		Integer ii2 =new Integer(100000);
		if(i==ii){
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		  
		h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
		System.out.println("max:"+Integer.MAX_VALUE);
		System.out.println("high:"+h);
		 assert i >= 127;
	}
}
