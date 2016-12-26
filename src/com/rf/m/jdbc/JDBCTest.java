package com.rf.m.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

	public static void main(String[] args) {
		//数据库连接
		Connection connection = null;
		//预编译satement
		PreparedStatement preparedStatement=null;
		//结果集
		ResultSet resultSet=null;
		
		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取数据库连接
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatistest?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false","root","1234");
			String sql="SELECT * FROM item WHERE NAME=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, "name1");
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
