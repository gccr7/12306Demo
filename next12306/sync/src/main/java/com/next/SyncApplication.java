package com.next;

import com.google.common.collect.Lists;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;

@SpringBootApplication
public class SyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyncApplication.class, args);
    }

    @Bean("shardedJedisPool")
    public ShardedJedisPool shardedJedisPool() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1", "6379");
        ArrayList<JedisShardInfo> jedisShardInfos = Lists.newArrayList(jedisShardInfo);
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(genericObjectPoolConfig, jedisShardInfos);
        return shardedJedisPool;
    }
}

