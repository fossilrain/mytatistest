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
	//一级缓存测试
	@Test
	public void testCache1() throws IOException {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ItemMapper im=sqlSession.getMapper(ItemMapper.class);
		//一级缓存限于同一个session 一下查询更改需要使用同一个session
		Item item1=im.queryItemById(3);
		System.out.println(item1);
		//两次请求之间进行了修改操作缓存将清空
		/*item1.setPrice("99999999");
		im.updateItem(item1);
		sqlSession.commit();*/
		
		Item item2=im.queryItemById(3);
		System.out.println(item2);
		
		sqlSession.close();
	}
	//二级缓存测试
	@Test
	public void testCache2() throws IOException {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		
		ItemMapper im1 = sqlSession1.getMapper(ItemMapper.class);
		ItemMapper im2 = sqlSession2.getMapper(ItemMapper.class);
		ItemMapper im3 = sqlSession3.getMapper(ItemMapper.class);
		// 一级缓存限于同一个session 一下查询更改需要使用同一个session
		Item item1 = im1.queryItemById(3);
		//这里执行关闭操作会将sqlSession1中的信息写入到二级缓存区域
		sqlSession1.close();
		System.out.println(item1);
		
		// 两次请求之间进行了修改操作缓存将清空
		item1.setPrice("1.99999999");
		im3.updateItem(item1);
		sqlSession3.commit();
		sqlSession3.close();

		Item item2 = im2.queryItemById(3);
		sqlSession2.close();
		System.out.println(item2);

	}
}
