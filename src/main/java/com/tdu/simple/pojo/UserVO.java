package com.tdu.simple.pojo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "用户信息")
public class UserVO implements Serializable {

	private static final long serialVersionUID = 4876948917908267453L;
	@ApiModelProperty(name = "id", value = "用户Id")
	private String id;
	@ApiModelProperty(name = "name", value = "用户名称用户名称用户名称用户名称用户名称用户名称用户名称用户名称")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<String> keys;

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

}
