package com.algorithm;

/**
 * 先来解释下算法原理，校验和类型的算法，一般是ID＋校验号，校验号和ID号的每位相关，如果出错，通过某种运算能检测出这种改动。借用维基百科的例子我来解释下。
 * 我们以数字“7992739871”为例，计算其校验位：
 * 从校验位开始，从右往左，偶数位乘2（例如，7*2=14），然后将两位数字的个位与十位相加（例如，10：1+0=1，14：1+4=5）；
 * 把得到的数字加在一起（本例中得到67）；
 * 将数字的和取模10（本例中得到7），再用10去减（本例中得到3），得到校验位。
 * 原始数字 偶数位乘2 将数字相加
 * 7       9       9       2       7       3       9       8       7       1       x
 * 7       18      9       4       7       6       9       16      7       2       x
 * 7       9       9       4       7       6       9       7       7       2       =67
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
        System.out.println(luhnTest("79927398713"));
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