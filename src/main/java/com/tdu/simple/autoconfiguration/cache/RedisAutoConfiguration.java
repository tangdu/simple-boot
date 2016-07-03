package com.tdu.simple.autoconfiguration.cache;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.tdu.simple.util.JsonUtil;
import com.tdu.simple.util.Keys;

@Configuration
@AutoConfigureBefore(CacheAutoConfiguration.class)
public class RedisAutoConfiguration {

	public static final long DEFAULT_EXPIRE_TIME_SECOND=3600*1;
	
	@Bean(name = { Keys.REDIS })
	public RedisCacheManager redisCacheManager(RedisTemplate<Object, Object> redisTemplate) {
		RedisCacheManager redisCacheManager=new RedisCacheManager(redisTemplate);
		redisCacheManager.setDefaultExpiration(DEFAULT_EXPIRE_TIME_SECOND);
		return redisCacheManager;
	}

	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(redisConnectionFactory);
		defaultJsonSerializer(template);
		return template;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void defaultJsonSerializer(RedisTemplate template) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(
				Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(JsonUtil.getDefaultObjectMapper());
		template.setKeySerializer(new StringRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}

	@Bean
	@ConditionalOnMissingBean(StringRedisTemplate.class)
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		template.setEnableTransactionSupport(true);
		template.setKeySerializer(new StringRedisSerializer());
		defaultJsonSerializer(template);
		return template;
	}
}
