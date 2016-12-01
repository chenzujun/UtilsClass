package com.algorithm;

/**
 * 
 * @ClassName: Luhn 
 * @Description: 银行卡合法性效验
 * @author chenjun
 * @date 2017年1月12日 上午10:31:45 
 *
 */
public class Luhn {
	public static void main(String[] args) {
        System.out.println(luhnTest(""));
        System.out.println(luhnTest("9558803602145444097"));
        System.out.println(luhnTest("4581230149856611"));
        System.out.println(luhnTest(""));
    }
 
    public static boolean luhnTest(String number){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(number).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }
}