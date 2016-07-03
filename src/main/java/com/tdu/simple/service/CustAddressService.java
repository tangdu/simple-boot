package com.tdu.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.tdu.simple.dao.CustAddressDao;
import com.tdu.simple.pojo.CustAddress;
import com.tdu.simple.util.Keys;

@Service
@CacheConfig(cacheNames = Keys.CUSTADDRESS)
public class CustAddressService {

	@Autowired
	private CustAddressDao custAddressDao;

	@Cacheable(key = "CUSTALL")
	public List<CustAddress> queryAll() {
		return custAddressDao.queryAll();
	}

	@Caching(cacheable = { 
			@Cacheable(key = "#id+'_cust'", cacheManager = Keys.EHCACHE),
			@Cacheable(key = "#id+'_cust'", cacheManager = Keys.REDIS) 
	})
	public CustAddress queryById(Integer id) {
		return custAddressDao.queryById(id);
	}

	// @CachePut( key = "#address.getId()+'_cust'")
	@CacheEvict(key = "#address.getId()+'_cust'")
	public int add(CustAddress address) {
		return custAddressDao.insert(address);
	}

	// @CachePut( key = "#address.getId()+'_cust'")
	@CacheEvict(key = "#address.getId()+'_cust'")
	public int edit(CustAddress address) {
		return custAddressDao.updateById(address);
	}

	@CacheEvict(key = "#id'_cust'")
	public int delete(Integer id) {
		return custAddressDao.deleteById(id);
	}

}
