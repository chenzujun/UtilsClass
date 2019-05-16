package com.grammar.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    /**
     * 多线程效率低，原因：多个线程同时计算新的种子时候会竞争同一个原子变量的更新操作
     */
    public static void getRandomIntByRandom() {
        // 不要设置seed，除非必要
        Random random = new Random();
        int rand = random.nextInt();
        System.out.println("getRandomIntByRandom 1= " + rand);
    }

    /**
     * 各线程维护本地种子。提升效率
     */
    public static void getRandomIntByThreadLocalRandom() {
        int rand = ThreadLocalRandom.current().nextInt();
        System.out.println("getRandomIntByThreadLocalRandom = " + rand);
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 2) {
            getRandomIntByRandom();
            getRandomIntByThreadLocalRandom();

            i++;
        }
    }
}
