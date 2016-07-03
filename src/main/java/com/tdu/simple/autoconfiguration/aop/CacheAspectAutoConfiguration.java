package com.tdu.simple.autoconfiguration.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
@Aspect
public class CacheAspectAutoConfiguration {
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;

	@Pointcut("@annotation(org.springframework.cache.annotation.Cacheable)")
	private void cacheable() {
	}

	@Around("cacheable()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		return null;
	}
}
