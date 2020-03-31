package com.zx.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zx.dao.FlowerDao;
import com.zx.pojo.Flower;

/**
 * 数据访问层要有异常处理
 * 
 * @author zhang
 *
 */
public class FlowerDaoImpl implements FlowerDao{
	//声明实体类和集合类
	List<Flower> list=new ArrayList<>();
	//声明全局对象
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	@Override
	public List<Flower> selAll() {
		
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//创建数据库连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?serverTimezone=GMT", "root", "521521");
			//创建sql命令
			String sql="select * from flower";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//为占位符赋值
			//执行sql命令
			rs=ps.executeQuery();
			//遍历查询结果
			while (rs.next()) {
				list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回查询结果
		return list;
	}
	//插入新的花卉
	@Override
	public int insFlower(Flower flower) {
		int index=0;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//创建数据库连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?serverTimezone=GMT", "root", "521521");
			conn.setAutoCommit(false);
			//创建sql命令
			String sql="insert into flower values(default,?,?,?)";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//为占位符赋值
			ps.setString(1, flower.getName());
			ps.setDouble(2, flower.getPrice());
			ps.setString(3, flower.getProduction());
			//执行sql命令
			index=ps.executeUpdate();
			
			//遍历查询结果
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回查询结果
		return index;
	}
	
}
