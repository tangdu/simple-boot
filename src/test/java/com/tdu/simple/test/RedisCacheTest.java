package com.tdu.simple.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tdu.run.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class RedisCacheTest {

	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<Object, Object> template;
	
	@Test
	public void 测试set_排重集合() {
		SetOperations<String, String> ops = redisTemplate.opsForSet();
		ops.add("b", "1", "2", "3","5");
		redisTemplate.expire("b", 50, TimeUnit.SECONDS);
		System.out.println(ops.remove("b", "1","3"));
	}
	
	@Test
	public void 测试map(){
		HashOperations<String, String, String> ops=redisTemplate.opsForHash();
		ops.put("users", "11111", "1111111");
		redisTemplate.expire("users", 150, TimeUnit.SECONDS);
	}
	
	@Test
	public void 测试list(){
		ListOperations<String, String> ops=redisTemplate.opsForList();
		ops.leftPush("hh", "xxx");
		ops.leftPush("hh2", "xxx");
		redisTemplate.expire("users", 150, TimeUnit.SECONDS);
	}
	
	@Test
	public void 测试zset_有序集合(){
		ZSetOperations<String, String> ops=redisTemplate.opsForZSet();
		ops.add("zset1", "xx1x",5d);
		ops.add("zset1", "xx3x",2d);
		ops.add("zset1", "xx4x",0d);
		//ops.incrementScore("zset1", "xx1x", 2);
		System.out.println(ops.range("zset1", 1, 9));
		redisTemplate.expire("zset1", 15000, TimeUnit.SECONDS);
	}
	
	@Test
	public void 测试分组(){
	}
}
