package com.rf.m.mapper;

import java.io.IOException;
import java.util.List;

import com.rf.m.po.Item;
import com.rf.m.po.ItemCustom;
import com.rf.m.po.ItemQueryVo;

public interface ItemMapper {

	public Item queryItemById(int id) throws IOException;
	//使用resultMap 进行输出映射
	public Item queryItemByIdResultMap(int id) throws IOException;
	
	//综合查询（使用包装对象）
	public List<ItemCustom> findItemList(ItemQueryVo itemQueryVo) throws IOException;
	//综合查询总数（使用包装对象）
	public int findItemCount(ItemQueryVo itemQueryVo) throws IOException;
}
