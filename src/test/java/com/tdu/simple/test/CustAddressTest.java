	package com.tdu.simple.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tdu.run.Application;
import com.tdu.simple.pojo.CustAddress;
import com.tdu.simple.service.CustAddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class CustAddressTest {

	private static final Logger logger=LoggerFactory.getLogger(CustAddressTest.class);
	@Autowired
	CustAddressService custAddressService;

	LoadingCache<Integer, Optional<CustAddress>> localCache = null;

	@Before
	public void initParams() {
		localCache = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(5, TimeUnit.MINUTES)
				.build(new CacheLoader<Integer, Optional<CustAddress>>() {
					@Override
					public Optional<CustAddress> load(Integer key) throws Exception {
						System.out.println("CustAddressTest.initParams().new CacheLoader() {...}.load()"+key);
						return Optional.fromNullable(custAddressService.queryById(key));
					}
				});

	}

	@Test
	public void testAdd() {
		MDC.put("sessionId", "user-session");
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			logger.error("ssss",e);
		}
		logger.info("测试运行");
		
		CustAddress address = new CustAddress();
		address.setAddress("dd");
		address.setCustId("1234");
		address.setPhone("12938273223");
		address.setPost("1234");
		address.setRemark("232");
		address.setCity("湘潭");
		custAddressService.add(address);

		System.out.println(address.getId());
		long s=System.currentTimeMillis();
		CustAddress a = custAddressService.queryById(address.getId());
		long e=System.currentTimeMillis();
		System.out.println(a.getCity() + "_1---" + a.getId()+"---"+(e-s)+"ms");
		s=System.currentTimeMillis();
		a = custAddressService.queryById(address.getId());
		e=System.currentTimeMillis();
		System.out.println(a.getCity() + "_2---" + a.getId()+"---"+(e-s)+"ms");
		///
		try {
			Optional<CustAddress> option = localCache.get(a.getId());
			if (option.isPresent()) {
				System.out.println(option.get().getCity() + "-----1");
			}
			localCache.invalidate(a.getId());
			//localCache.cleanUp();
			option = localCache.get(a.getId());
			if (option.isPresent()) {
				System.out.println(option.get().getCity() + "-----2");
			}
			System.out.println("CustAddressTest.testAdd()"+CacheBuilder.newBuilder().recordStats());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
