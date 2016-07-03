package com.tdu.simple.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCacheTest {

	@Test
	public void testCache() {
		LoadingCache<Integer, Optional<String>> kes = CacheBuilder.newBuilder().maximumSize(1)
				.expireAfterWrite(5, TimeUnit.MINUTES).build(new CacheLoader<Integer, Optional<String>>() {
					@Override
					public Optional<String> load(Integer key) throws Exception {
						return Optional.fromNullable("000"+key);
					}
				});
		try {
			kes.apply(1);
			kes.apply(2);
			Optional<String> aall = kes.get(123);
			if (aall.isPresent()) {
				System.out.println(aall.get());
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
