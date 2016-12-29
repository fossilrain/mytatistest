package com.rf.m.po;

import java.util.List;

public class Users {

	private String id;
	private String name;
	private String sex;
	private String address;
	
	private List<Orders> lo;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Orders> getLo() {
		return lo;
	}
	public void setLo(List<Orders> lo) {
		this.lo = lo;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", sex=" + sex + ", address=" + address + ", lo=" + lo + "]";
	}
	
	
}
