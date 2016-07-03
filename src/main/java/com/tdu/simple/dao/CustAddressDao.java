/**
* qccr.com Inc.
* Copyright (c) 2014-2016 All Rights Reserved.
*/
package com.tdu.simple.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tdu.simple.pojo.CustAddress;

@Mapper
public interface CustAddressDao {
	/**
	 */
	int deleteById(Integer id);

	/**
	 */
	int insert(CustAddress record);

	/**
	 */
	CustAddress queryById(Integer id);

	/**
	 */
	List<CustAddress> queryAll();

	/**
	 */
	int updateById(CustAddress record);
}