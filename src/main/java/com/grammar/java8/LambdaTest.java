package com.grammar.java8;

/**
 * Lambda 表达式
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）
 * 语法：
 * (parameters) -> expression
 * 或
 * (parameters) ->{ statements; }
 *
 * @author chenjun
 * @date 2018/5/22
 * @see https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
public class LambdaTest {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + test.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + test.operateBinary(20, 10, subtraction));


        // 1、从lambda 表达式引用的本地变量必须是最终变量或实际上的最终变量
        int num = 2;
        IntegerMath subtraction2 = (a, b) -> a - b + num;
        test.operateBinary(20, 10, subtraction2);
//        num = 3;
        // 2、在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
//        IntegerMath subtraction3 = (num, b) -> num - b;


        // before java 8
        System.out.println("40 + 2 = " + test.operateAdd(40, 2));
        System.out.println("20 - 10 = " + test.operateSubtraction(20, 10));
    }


    public int operateAdd(int a, int b) {
        return a + b;
    }

    public int operateSubtraction(int a, int b) {
        return a - b;
    }
}
