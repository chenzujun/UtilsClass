package com.common.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 分布式Redis锁
 *
 * @author chenjun
 * @date 2020/3/26
 * @since V1.0.0
 */
public class DistributionRedisLock {

    private static RedissonClient redisson;

    static {
        Config config = new Config();
        config.useClusterServers()
                // 集群状态扫描间隔时间，单位是毫秒
                .setScanInterval(2000)
                //可以用"rediss://"来启用SSL连接
//                .addNodeAddress("redis://10.104.6.131:7002", "redis://10.104.6.131:7001")
                .addNodeAddress("redis://10.104.6.131:7000");

        redisson = Redisson.create(config);
    }

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor service = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit. SECONDS, new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i=0;i<2;i++){
            service.execute(()->{
                // Redis hash 是一个 string 类型的 field 和 value 的映射表，hash 特别适合用于存储对象。
                // 10.104.6.131:7003> hgetall anyLock
                // 1) "a9d50fdd-6af9-45be-81d9-5e21a31cf997:48"
                // 2) "1"
                RLock lock = redisson.getLock("anyLock");
                try {
                    long start = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + "开始获取锁 | " + start);
                    // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
                    boolean res = lock.tryLock(100, 10, TimeUnit.SECONDS);
                    if(res){
                        try {
                            long end = System.currentTimeMillis();
                            System.out.println(Thread.currentThread().getName() + "获取锁 "+ lock.getName()+" | " + (end-start));
                            Thread.sleep(3000);
                            long end2 = System.currentTimeMillis();
                            System.out.println(Thread.currentThread().getName() + "醒来"+ lock.getName()+" | " + (end2-start));
                        }finally {
                            lock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
