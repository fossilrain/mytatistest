package com.rf.m.po;

import java.util.List;

/**
 * 包装类型
 * @author RainFossil
 *
 */
public class ItemQueryVo {
	//在此包装所需要的查询条件
	
	//商品查询条件
	private ItemCustom itemCustom;
	//id查询条件
	private List<Integer> ids;
	
	public ItemCustom getItemCustom() {
		return itemCustom;
	}

	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	//...等等其它的查询条件
	
}
