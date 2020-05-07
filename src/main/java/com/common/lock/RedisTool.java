package com.common.lock;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 分布式锁
 *
 *
 */
public class RedisTool {
	 
    private static final String LOCK_SUCCESS = "OK";
    /**
     *  NX -- Only set the key if it does not already exist.
     *  XX -- Only set the key if it already exist.
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * expire time units: EX = seconds; PX = milliseconds
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";
 
    private static final Long RELEASE_SUCCESS = 1L;
    
    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(JedisCluster jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }
    
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(JedisCluster jedis, String lockKey, String requestId) {
 
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
 
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }

    public static void main(String[] args) {
        // 集群
        HostAndPort hostAndPort = new HostAndPort("10.104.6.131", 7000);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        JedisCluster jedis = new JedisCluster(hostAndPortSet);
        // 单点
//        JedisPool jedispool = new JedisPool("10.104.6.131",7000);
//        Jedis jedis = jedispool.getResource();
        System.out.println(tryGetDistributedLock(jedis, "pds:test:key1","1", 60));
        System.out.println(tryGetDistributedLock(jedis, "pds:test:key1","2", 60));
    }

}