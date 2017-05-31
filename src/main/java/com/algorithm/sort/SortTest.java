package com.algorithm.sort;


public class SortTest {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        BubbleSort b = (BubbleSort) Class.forName("com.sort.BubbleSort").newInstance();
        b.sort();
    }

}
