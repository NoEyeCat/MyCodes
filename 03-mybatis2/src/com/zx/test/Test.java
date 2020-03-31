package com.zx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.pojo.People;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is=Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		/*People peo=new People();
		peo.setId(1);
		peo.setName("张三");
		
		int pageSize=2;
		int pageNumber=1;
		
		Map<String, Object> map=new HashMap<>();
		//显示几个
		map.put("pageSize", pageSize);
		//第几页
		map.put("pageStart",pageSize*(pageNumber-1));
		//如果想要传递多个参数，可以使用对象或者map
		People p = session.selectOne("a.b.selById", peo);
		System.out.println(p);
		List<People> list = session.selectList("a.b.page", map);
		for (People people : list) {
			System.out.println(people.toString());
		}*/
		People peo=new People();
		peo.setName("狗宋");
		peo.setAge(25);
		
		try {
			int index = session.insert("a.b.ins", peo);
			if (index>0) {
				
			}else{
				System.out.println("数据增加失败，请检查");
			}
		} catch (Exception e1) {
			//e.printStackTrace();
			session.rollback();
		}
		try {
			People p =new People();
			p.setName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			int index1 = session.insert("a.b.ins", p);
			if (index1>0) {
				
			}else{
				System.out.println("数据增加失败，请检查");
			}
		} catch (Exception e) {
			
			//e.printStackTrace();
			session.rollback();
		}
		session.commit();
		session.close();
	}
}
