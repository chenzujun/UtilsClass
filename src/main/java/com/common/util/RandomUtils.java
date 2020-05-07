package com.common.util;

import java.util.HashSet;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 *
 * @author chenjun
 * @date 2020/5/7
 * @since V1.0.0
 */
public class RandomUtils {

    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     * @param set 随机数结果集
     */
    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            // 递归
            randomSet(min, max, n - setSize, set);
        }
    }


    public static void main(String[] args) {
        // 第一种 Math.random()： 获取随机小数范围：[0.0,1.0) 返回的值是double类型
        // 获取一个[min,max] 区间内的随机整数，(int) Math.round(Math.random()*(max-min)+min)
        int r1 = (int) Math.round(Math.random()*(50-30)+30);
        System.out.println("第一种（Math.random()）随机数据="+r1);

        // 第二种 Random类
        // 获取一个[min,max]区间内的随机整数，random.nextInt(max)%(max-min+1) + min
        Random random = new Random();
        int r2 = random.nextInt(50)%(50-30+1) + 30;
        System.out.println("第二种（Random）随机数据="+r2);

        // 第三种 ThreadLocalRandom current()，线程安全
        // ThreadLocalRandom （jdk1.7开始出现）
        // 获取一个[min,max)区间内的随机整数，方法：int nextInt(int a,int b)
        int r3 = ThreadLocalRandom.current().nextInt(30,50);
        System.out.println("第三种（ThreadLocalRandom）随机数据="+r3);

        // 第四种 System.currentTimeMillis()
        //获取一个[min,max]区间内的随机整数，(int) (randomNum%(max-min+1))+min
        int r4 = (int)(System.currentTimeMillis()%(50-30+1)) + 30;
        System.out.println("第四种（System.currentTimeMillis()）随机数据="+r4);

        // 第五种 UUID
        String uuid = UUID.randomUUID().toString();
        System.out.println("第五种（UUID）随机数据="+uuid);

        HashSet<Integer> set = new HashSet();
        RandomUtils.randomSet(30, 50, 20, set);
        System.out.println(set.toString());
    }
}
