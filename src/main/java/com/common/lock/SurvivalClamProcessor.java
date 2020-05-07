package com.common.lock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁的延时类
 *
 * @author chenjun
 * @date 2020/5/7
 * @since V1.0.0
 */
@Slf4j
public class SurvivalClamProcessor implements Runnable {
    private static final int REDIS_EXPIRE_SUCCESS = 1;
    private RLock rLock;

    private String key;

    /**
     * 业务线程的id
     */
    private long value;

    private int lockTime;

    /**
     * 线程关闭的标记
     */
    private volatile Boolean signal;

    public SurvivalClamProcessor(RLock rLock, String key, long value, int lockTime) {
        this.rLock = rLock;
        this.key = key;
        this.value = value;
        this.lockTime = lockTime;
        this.signal = Boolean.TRUE;
    }

    public void stop() {
        this.signal = Boolean.FALSE;
    }

    @Override
    public void run() {
        int waitTime = lockTime * 1000 * 2 / 3;
        while (signal) {
            try {
                Thread.sleep(waitTime);
                System.out.println(Thread.currentThread().getName());
                // 此处如果不用tryLockAsync会导致锁id进行变更。导致释放锁的时候报错
                if (rLock.tryLockAsync(lockTime, 30, TimeUnit.SECONDS, value).get()) {
                    log.info("expandLockTime 成功，本次等待{}ms，将重置锁超时时间重置为{}s,其中key为{},value为{},", waitTime, lockTime, value, key);
                } else {
                    log.info("expandLockTime 失败，将导致SurvivalClamConsumer中断");
                    this.stop();
                }
            } catch (InterruptedException e) {
                log.info("SurvivalClamProcessor 处理线程被强制中断， error {}", e);
            } catch (Exception e) {
                log.error("SurvivalClamProcessor run error", e);
            }
        }
        log.info("SurvivalClamProcessor 处理线程已停止");
    }
}