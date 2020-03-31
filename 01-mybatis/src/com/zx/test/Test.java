package com.zx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.pojo.Flower;

public class Test {
	/**
	 * 
	 * mybatis的三种查询方式
	 * 		selectList()返回值为List<resultType属性控制>
	 * 		List<Flower> list = session.selectList("com.zx.FlowerMapper.selAll");
			for(Flower f:list){
				System.out.println(f.toString())};
	 * 		
	 * 
	 * 		selectOne() 返回值为Object
	 * 			适用于返回结果只是一个变量或者一行数据时候
	 * 
	 * 		selectMap() 返回值为Map
	 * 			适用于需要在查询结果中快速通过某列的值取到这行数据的需求
	 * 			Map(key,resultType控制)
	 * 
	 * 
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		//使用工厂模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		//生产SqlSession
		SqlSession session=factory.openSession();
		
		/*List<Flower> list = session.selectList("com.zx.FlowerMapper.selAll");
		for(Flower f:list){
			System.out.println(f.toString());
		}*/

		/*int count=session.selectOne("com.zx.FlowerMapper.selOne");
		System.out.println(count);*/
		//把数据库哪个列的值当作map的key  
		Map<Object, Object> map = session.selectMap("com.zx.FlowerMapper.selOther", "name");
		System.out.println(map);
		
		
		session.close();
	}
}
