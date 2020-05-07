package com.common.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 * Redisson
 *  是一个在Redis的基础上实现的Java驻内存数据网格（In-Memory Data Grid）。它不仅提供了一系列的分布式的Java常用对象，还提供了许多分布式服务。
 *  其中包括(BitSet, Set, Multimap,SortedSet, Map, List, Queue, BlockingQueue, Deque, BlockingDeque, Semaphore, Lock, AtomicLong, CountDownLatch, Publish / Subscribe,
 *  Bloom filter, Remote service, Spring cache, Executor service, Live Object service, Scheduler service) Redisson提供了使用Redis的最简单和最便捷的方法。
 *  Redisson的宗旨是促进使用者对Redis的关注分离（Separation of Concern），从而让使用者能够将精力更集中地放在处理业务逻辑上。
 *
 *
 * @author chenjun
 * @date 2020/3/26
 * @since V1.0.0
 */
public class DistributionRedisLock  {

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

    public static void autoRelease(){
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
                    boolean res = lock.tryLock(100, 12, TimeUnit.SECONDS);
                    if(res){
                        System.out.println(Thread.currentThread().getName() + "获取锁成功 | " + (System.currentTimeMillis()-start)/1000);
                        try {
                            SurvivalClamProcessor survivalClamProcessor
                                    = new SurvivalClamProcessor(lock, "anyLock", Thread.currentThread().getId(), 12);
                            Thread survivalThread = new Thread(survivalClamProcessor);
                            survivalThread.setDaemon(Boolean.TRUE);
                            survivalThread.start();
                            Thread.sleep(20*1000);
                            survivalClamProcessor.stop();
//                            survivalThread.interrupt();
                        } finally {
                            lock.unlock();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + "获取锁失败");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 未设置leaseTime，看门狗生效，避免死锁
     */
    public static void watchDog(){
        ThreadPoolExecutor service = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit. SECONDS, new ArrayBlockingQueue<>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i=0;i<2;i++){
            service.execute(()->{
                RLock lock = redisson.getLock("watchDog");
                try {
                    long start = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + "开始获取锁 | " + start);
                    // 尝试加锁，最多等待100秒
                    boolean res = lock.tryLock(100, TimeUnit.SECONDS);
                    if(res){
                        System.out.println(Thread.currentThread().getName() + "获取锁成功 | " + (System.currentTimeMillis()-start)/1000);
                        try {
                            Thread.currentThread().stop();
                        } finally {
                            lock.unlock();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + "获取锁失败");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) throws Exception {
        DistributionRedisLock.autoRelease();
    }
}
