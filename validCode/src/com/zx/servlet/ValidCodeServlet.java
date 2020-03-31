package com.zx.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//创建一张图片
		//宽高单位为像素	
		BufferedImage image=new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		
		//画板对象
		//画之前必须设置画笔
		Graphics2D gra = image.createGraphics();
		
		gra.setColor(Color.white);
		//前两个参数表示填充起始坐标
		//后两个参数表示一个矩形区域
		gra.fillRect(0, 0, 200, 100);
		
		//随机产生四位数字
		List<Integer> randlist = new ArrayList<Integer>();
		
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			randlist.add(random.nextInt(10));
		}
		Color[] colors=new Color[]{Color.red,Color.yellow,Color.black,Color.blue,Color.pink};
		//设置字体
		gra.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,40));
		for (int i = 0; i < randlist.size(); i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawString(randlist.get(i)+"", i*40, 50+(random.nextInt(21)-10));
		}
		
		//绘制横线
		//前两个表示线段起始坐标点，后两个表示线段终止坐标点
		for (int i = 0; i < 2; i++) {
			gra.setColor(colors[random.nextInt(colors.length)]);
			gra.drawLine(0,random.nextInt(101), 200,random.nextInt(101));
		}
		
		ServletOutputStream outputStream = resp.getOutputStream();
		//工具类
		ImageIO.write(image, "jpg", outputStream);
		
		//吧验证码放入session中
		HttpSession session = req.getSession();
		session.setAttribute("code", ""+randlist.get(0)+randlist.get(1)+randlist.get(2)+randlist.get(3));
	}
}
