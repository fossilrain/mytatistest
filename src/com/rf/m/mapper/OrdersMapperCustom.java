package com.rf.m.mapper;

import java.util.List;

import com.rf.m.po.Orders;
import com.rf.m.po.OrdersCustom;
import com.rf.m.po.Users;

public interface OrdersMapperCustom {

	//查询订单关联查询用户信息
	public List<OrdersCustom> queryOrdersWithUserInfo()throws Exception;
	//查询订单关联查询用户信息(使用resultMap)
	public List<Orders> queryOrdersUserResultMap()throws Exception;
	//查询订单关联查询用户信息及订单明细(使用resultMap)
	public List<Orders> queryOrdersUserODetailResultMap()throws Exception;
	//用户商品关联查询
	public List<Users> queryUserItemResultMap()throws Exception;
	//延迟加载查询订单信息
	public List<Orders> queryOrdersUserLazyResultMap()throws Exception;
}
