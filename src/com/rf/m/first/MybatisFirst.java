package com.rf.m.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.rf.m.po.Item;

public class MybatisFirst {

	@Test
	public void findItemByIdTest() throws IOException{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建回话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		//通过session操作数据库
		Item item=session.selectOne("test.queryItemById", 1);
		System.out.println(item);
		//释放资源
		session.close();
	}

	@Test
	public void findItemByNameTest() throws IOException{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建回话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		//通过session操作数据库
		List<Item> li=session.selectList("test.queryItemByName", "name");
		System.out.println(li);
		//释放资源
		session.close();
	}
	@Test
	public void insertItemTest() throws IOException{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建回话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		//通过session操作数据库
		Item item=new Item();
		item.setName("item3");
		item.setPrice("3.0");
		item.setDetail("商品描述3");
		item.setCreatetime(new Date());
		int i=session.insert("test.insertItem", item);
		//提交事务
		session.commit();
		System.out.println(item);
		//释放资源
		session.close();
	}
	@Test
	public void deleteItemTest() throws IOException{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建回话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		//通过session操作数据库
		int i=session.delete("test.deleteItem", 6);
		//提交事务
		session.commit();
		System.out.println(i);
		//释放资源
		session.close();
	}
	@Test
	public void updateItemTest() throws IOException{
		//mybatis配置文件
		String resource = "sqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建回话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂得到SqlSession
		SqlSession session = sqlSessionFactory.openSession();
		//通过session操作数据库
		Item item=new Item();
		item.setId("1");
		item.setName("item23");
		item.setPrice("23.0");
		item.setDetail("商品描述23");
		item.setCreatetime(new Date());
		int i=session.update("test.updateItem", item);
		//提交事务
		session.commit();
		System.out.println(item);
		//释放资源
		session.close();
	}
}
