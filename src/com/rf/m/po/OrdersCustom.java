package com.rf.m.po;

public class OrdersCustom extends Orders {

	private String name;
	private String sex;
	private String address;
	
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
	@Override
	public String toString() {
		return "OrdersCustom [name=" + name + ", sex=" + sex + ", address=" + address + "]";
	}
	
	
}
