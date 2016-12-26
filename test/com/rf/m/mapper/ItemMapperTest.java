package com.rf.m.mapper;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.rf.m.po.Item;
import com.rf.m.po.ItemCustom;
import com.rf.m.po.ItemQueryVo;

public class ItemMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "sqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testQueryItemById() throws IOException {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ItemMapper im=sqlSession.getMapper(ItemMapper.class);
		Item item=im.queryItemById(3);
		sqlSession.close();
		System.out.println(item);
	}
	@Test
	public void testQueryItemByIdResultMap() throws IOException {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ItemMapper im=sqlSession.getMapper(ItemMapper.class);
		Item item=im.queryItemByIdResultMap(3);
		sqlSession.close();
		System.out.println(item);
	}

	@Test
	public void testFindItemList() throws IOException {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ItemMapper im=sqlSession.getMapper(ItemMapper.class);
		//创建包装对象 设置查询条件
		ItemQueryVo itemQueryVo=new ItemQueryVo();
		ItemCustom ic=new ItemCustom();
		ic.setName("item");
		ic.setDetail("商品描述");
		itemQueryVo.setItemCustom(ic);
		
		//循环id
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(1);
//		ids.add(2);
//		ids.add(3);
		itemQueryVo.setIds(ids);
		
		List<ItemCustom> li=im.findItemList(itemQueryVo);
		sqlSession.close();
		System.out.println(li);
	}
	@Test
	public void testFindItemCount() throws IOException {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ItemMapper im=sqlSession.getMapper(ItemMapper.class);
		//创建包装对象 设置查询条件
		ItemQueryVo itemQueryVo=new ItemQueryVo();
		ItemCustom ic=new ItemCustom();
		ic.setName("item");
		ic.setDetail("商品描述");
		itemQueryVo.setItemCustom(ic);
		int count=im.findItemCount(itemQueryVo);
		sqlSession.close();
		System.out.println("总数："+count);
	}
}
