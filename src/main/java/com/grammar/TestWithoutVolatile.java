package com.grammar;

public class TestWithoutVolatile {
    private static boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                    }
                }
            }
        }.start();
        
        Thread.sleep(1);
        
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    bChanged = !bChanged;
                }
            }
        }.start();
    }
}
