package com.rf.m.po;

public class Orderdetail {

	private String id;
	private String orderId;
	private String itemId;
	private Integer countBuy;
	private Item item;//商品信息
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public Integer getCountBuy() {
		return countBuy;
	}
	public void setCountBuy(Integer countBuy) {
		this.countBuy = countBuy;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
