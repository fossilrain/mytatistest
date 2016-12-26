package com.rf.m.dao;

import java.io.IOException;

import com.rf.m.po.Item;

public interface ItemDao {

	public Item findItemByIdTest(int id) throws IOException;
}
