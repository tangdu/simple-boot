package com.tdu.simple.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdu.simple.pojo.CustAddress;
import com.tdu.simple.service.CustAddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/custAddress")
public class CustAddressController {

	@Autowired
	private CustAddressService custAddressService;

	@ApiOperation(value = "获取所有客户地址信息", notes = "获取所有客户地址信息")
	@RequestMapping(value = "/queryAll", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> queryAll(String name) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", custAddressService.queryAll());
		return result;
	}

	@ApiOperation(value = "添加客户地址信息", notes = "添加客户地址信息")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> add(CustAddress address) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", custAddressService.add(address));
		return result;
	}

	@ApiOperation(value = "更新客户地址信息", notes = "更新客户地址信息")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> edit(CustAddress address) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", custAddressService.edit(address));
		return result;
	}

	@ApiOperation(value = "删除客户地址信息", notes = "删除客户地址信息")
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> delete(Integer id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("data", custAddressService.delete(id));
		return result;
	}
}
