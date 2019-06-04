package com.grammar.random;

import java.util.concurrent.atomic.AtomicLong;

public class RandomTest {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    private static final AtomicLong seedUniquifier
            = new AtomicLong(8682522807148012L);
    public int nextInt() {
        long oldseed, nextseed;
        do {
            oldseed = seedUniquifier.get();
            nextseed = (oldseed * multiplier + addend) & mask;
        } while (!seedUniquifier.compareAndSet(oldseed, nextseed));
        return (int)nextseed;
    }

    public static void main(String[] args) {
        RandomTest r = new RandomTest();
        int i = 0;
        long start = System.nanoTime();
        long start2 = System.currentTimeMillis();
        while (i < 100000) {
            System.out.println(r.nextInt());
            i++;
        }
        long end = System.nanoTime();
        long end2 = System.currentTimeMillis();
        System.out.println("耗时 = "+(end-start));
        System.out.println("耗时2 = "+(end2-start2));
    }
}
