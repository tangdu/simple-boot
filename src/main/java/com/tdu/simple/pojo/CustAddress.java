/**
* qccr.com Inc.
* Copyright (c) 2014-2016 All Rights Reserved.
*/
package com.tdu.simple.pojo;

import java.io.Serializable;

/**
 * 客户地址信息表 (T_WM_CUST_ADDRESS)
 * 
 * @author tangdu
 * @since vision:1.0.0, Date:2016年06月30日 14:06:35
 */
public class CustAddress implements Serializable {
	/** ID */
	private Integer id;

	/** 省 */
	private String province;

	/** 市 */
	private String city;

	/** 详细地址 */
	private String address;

	/** 收货电话 */
	private String phone;

	/** 邮政编码 */
	private String post;

	/** 说明 */
	private String remark;

	/** 客户编号 */
	private String custId;

	/** 是否默认 : 1:为默认 0:不是 */
	private String defaultAddress;

	/** 收货人 */
	private String consigneePerson;

	/** 是否有效 */
	private Integer custValid;

	/***/
	private static final long serialVersionUID = 1L;

	/**
	 * 返回 F_ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置 F_ID
	 * 
	 * @param fId
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 返回 省
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置 省
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 返回 市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置 市
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 返回 详细地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置 详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 返回 收货电话
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置 收货电话
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 返回 邮政编码
	 */
	public String getPost() {
		return post;
	}

	/**
	 * 设置 邮政编码
	 * 
	 * @param post
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * 返回 说明
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置 说明
	 * 
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 返回 客户编号
	 */
	public String getCustId() {
		return custId;
	}

	/**
	 * 设置 客户编号
	 * 
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * 返回 是否默认 : 1:为默认 0:不是
	 */
	public String getDefaultAddress() {
		return defaultAddress;
	}

	/**
	 * 设置 是否默认 : 1:为默认 0:不是
	 * 
	 * @param defaultAddress
	 */
	public void setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	/**
	 * 返回 收货人
	 */
	public String getConsigneePerson() {
		return consigneePerson;
	}

	/**
	 * 设置 收货人
	 * 
	 * @param consigneePerson
	 */
	public void setConsigneePerson(String consigneePerson) {
		this.consigneePerson = consigneePerson;
	}

	/**
	 * 返回 是否有效
	 */
	public Integer getCustValid() {
		return custValid;
	}

	/**
	 * 设置 是否有效
	 * 
	 * @param custValid
	 */
	public void setCustValid(Integer custValid) {
		this.custValid = custValid;
	}

}