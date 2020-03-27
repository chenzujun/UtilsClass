package com.common.lock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

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
        config.setLockWatchdogTimeout(15000);

        redisson = Redisson.create(config);
    }

    public static void main(String[] args) throws Exception {
        RLock lock = redisson.getLock("anyLock");
        boolean res = lock.tryLock(100, 60, TimeUnit.SECONDS);
        if(res){
            try {
                System.out.println(lock.getName()+ "true");
            }finally {
                lock.unlock();
            }
        }
    }
}
