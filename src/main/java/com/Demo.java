package com;

public class Demo {
	public static void main(String[] args) {
        Out.In in = new Out().new In();
        in.print();
        //或者采用下种方式访问
        /*
        Out out = new Out();
        Out.In in = out.new In();
        in.print();
        */
    }
}
