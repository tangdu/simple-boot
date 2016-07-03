package com.tdu.simple.autoconfiguration.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

@Configuration
@EnableCaching
@AutoConfigureAfter({EhcacheAutoConfiguration.class,RedisAutoConfiguration.class})
public class CompositeCacheAuconfiguration {

	private List<CacheManager> cacheManagers = new ArrayList<>();;

	@PostConstruct
	public void initCacheList() {
		cacheManagers.add(cacheCacheManager);
		cacheManagers.add(redisCacheManager);
	}

	@Autowired
	EhCacheCacheManager cacheCacheManager;
	@Autowired
	RedisCacheManager redisCacheManager;

	@Bean
	public CompositeCacheManager compositeCache() {
		CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
		compositeCacheManager.setCacheManagers(cacheManagers);
		compositeCacheManager.setFallbackToNoOpCache(true);
		return compositeCacheManager;
	}
}
