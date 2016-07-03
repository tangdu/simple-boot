package com.tdu.simple.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdu.simple.pojo.UserVO;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ApiController {

	@ApiOperation(value = "获取信息", notes = "根据名称获取信息")
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getInfo(String name) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Key", 1111111l);
		return result;
	}

	@ApiOperation(value = "提交信息", notes = "保存基本信息")
	@RequestMapping(value = "/putInfo", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> putInfo(String name) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Key", 1111111l);
		return result;
	}

	@ApiOperation(value = "删除信息", notes = "根据ID删除明细")
	@RequestMapping(value = "/deleteInfo/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteInfo(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Key", 1111111l);
		return result;
	}

	@ApiOperation(value = "添加用户信息", notes = "添加用户信息")
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public UserVO addUser(@RequestBody UserVO userVO) {
		return userVO;
	}
}
