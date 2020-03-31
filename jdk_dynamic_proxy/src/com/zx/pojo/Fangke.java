package com.zx.pojo;

import java.lang.reflect.Proxy;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

public class Fangke {
	public static void main(String[] args) {
		Mishu mishu=new Mishu();
		//第一个参数是反射时使用的类加载器，第二个参数说明procxy需要实现什么接口，第三个参数表示接口对象调用方法时需要调用哪个类的invoke方法。
		Gongneng gongneng = (Gongneng) Proxy.newProxyInstance(Fangke.class.getClassLoader(), new Class[]{Gongneng.class}, mishu);
		gongneng.chifan();
	}
}
