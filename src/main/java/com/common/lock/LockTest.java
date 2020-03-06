package com.common.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁测试
 *
 * @author chenjun
 * @date 2020/2/27
 * @since V1.0.0
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                System.out.println("Thread real execute");
                lock.writeLock().unlock();
            }
        });
        // 获取两次锁，需要释放两次，否则线程无法获取锁
        lock.writeLock().lock();
        lock.writeLock().lock();
        t.start();
        Thread.sleep(200);

        System.out.println("realse one once");
        lock.writeLock().unlock();
    }
}
