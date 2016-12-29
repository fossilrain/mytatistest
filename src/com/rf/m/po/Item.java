package com.rf.m.po;

import java.io.Serializable;
import java.util.Date;
//实现序列化接口为了取出缓存数据的反序列话，因为缓存数据不一定存储在内存中
public class Item implements Serializable{
	private String id;
	private String name;
	private String price;
	private String detail;
	private Date createtime;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", detail=" + detail + ", createtime="
				+ createtime + "]";
	}
	
	
}
