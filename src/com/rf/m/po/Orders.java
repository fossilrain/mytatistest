package com.rf.m.po;

import java.util.List;

public class Orders {

	private String id;
	private String userId;
	private String createDate;
	private Users users;
	
	private List<Orderdetail> odli;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public List<Orderdetail> getOdli() {
		return odli;
	}
	public void setOdli(List<Orderdetail> odli) {
		this.odli = odli;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", createDate=" + createDate + "]";
	}
	
	
}
