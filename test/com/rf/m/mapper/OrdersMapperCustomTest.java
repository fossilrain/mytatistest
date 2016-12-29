package com.rf.m.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.rf.m.po.ItemCustom;
import com.rf.m.po.ItemQueryVo;
import com.rf.m.po.Orders;
import com.rf.m.po.OrdersCustom;
import com.rf.m.po.Users;

public class OrdersMapperCustomTest {
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
	public void testQueryOrdersWithUsersInfo() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom omc=sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> li=omc.queryOrdersWithUserInfo();
		sqlSession.close();
		System.out.println(li);
	}
	@Test
	public void testQueryOrdersUserResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom omc=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> li=omc.queryOrdersUserResultMap();
		sqlSession.close();
		System.out.println(li);
	}
	@Test
	public void testQueryOrdersUserODetailResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom omc=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> li=omc.queryOrdersUserODetailResultMap();
		sqlSession.close();
		System.out.println(li);
	}
	@Test
	public void testQueryUserItemResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom omc=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Users> li=omc.queryUserItemResultMap();
		sqlSession.close();
		System.out.println(li);
	}
	@Test
	public void testQueryOrdersUserLazyResultMap() throws Exception {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		OrdersMapperCustom omc=sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> li=omc.queryOrdersUserLazyResultMap();
		sqlSession.close();
//		System.out.println(li);
		for(Orders o:li){
			Users u=o.getUsers();
			System.out.println(u);
		}
	}
}
