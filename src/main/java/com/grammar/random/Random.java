package com.grammar.random;

import java.util.concurrent.atomic.AtomicLong;

public class Random {

    private final AtomicLong seed;

    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;

    // 1.0 / (1L << 53)
    private static final double DOUBLE_UNIT = 0x1.0p-53;

    static final String BadBound = "bound must be positive";
    static final String BadRange = "bound must be greater than origin";
    static final String BadSize  = "size must be non-negative";


    public Random() {
        this(seedUniquifier() ^ System.nanoTime());
    }

    private static long seedUniquifier() {
        for (;;) {
            long current = seedUniquifier.get();
            long next = current * 181783497276652981L;
            if (seedUniquifier.compareAndSet(current, next)){
                return next;
            }
        }
    }

    private static final AtomicLong seedUniquifier
            = new AtomicLong(8682522807148012L);


    public Random(long seed) {
        System.out.println("Random seed="+seed +" | " + seedUniquifier.get());
        if (getClass() == Random.class)
            this.seed = new AtomicLong(initialScramble(seed));
        else {
            // subclass might have overriden setSeed
            this.seed = new AtomicLong();
            setSeed(seed);
        }
    }

    private static long initialScramble(long seed) {
        return (seed ^ multiplier) & mask;
    }

    synchronized public void setSeed(long seed) {
        this.seed.set(initialScramble(seed));
    }

    public int nextInt() {
        return next(32);
    }

    public int nextInt(int bound) {
        if (bound <= 0){
            throw new IllegalArgumentException(BadBound);
        }

        int r = next(31);
        int m = bound - 1;
        if ((bound & m) == 0)  {
            // i.e., bound is a power of 2
            r = (int)((bound * (long)r) >> 31);
        } else {
            for (int u = r;
                 u - (r = u % bound) + m < 0;
                 u = next(31)){
            }
        }
        return r;
    }

    protected int next(int bits) {
        long oldseed, nextseed;
        AtomicLong seed = this.seed;
        do {
            oldseed = seed.get();
            nextseed = (oldseed * multiplier + addend) & mask;
        } while (!seed.compareAndSet(oldseed, nextseed));
        return (int)(nextseed >>> (48 - bits));
    }


    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt() + " | " +seedUniquifier.get());
        System.out.println("==========");
        Random r2 = new Random();
        System.out.println(r2.nextInt() + " | " +seedUniquifier.get());

        System.out.println(r.seed.get() + " | " +r2.seed.get());



    }
}
