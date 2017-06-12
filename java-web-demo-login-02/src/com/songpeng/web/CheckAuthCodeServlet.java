package com.songpeng.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 需求: 生成验证码
		// 1 生成画布
		int width = 100;
		int height = 30;
		BufferedImage bufi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 3 获取画笔
		Graphics g = bufi.getGraphics();
		// 4 填充背景颜色
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		// 5 绘制边框
		g.setColor(Color.red);
		g.drawRect(0, 0, width - 1, height - 1);
		// 6 生成随机字符
		// 6.1 准备数据
		String data = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		// 6.2 准备随机对象
		Random r = new Random();
		// 7.1 声明一个变量 保存验证码
		String code = "";
		// 6.3 循环绘制随机字符
		for (int i = 0; i < 4; i++) {
			// 6.3.2 设置字体
			g.setFont(new Font("宋体", Font.BOLD, 25));
			// 6.3.3 设置随机颜色
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			// 6.3.1 绘制字符
			String str = "" + data.charAt(r.nextInt(data.length())); // 绘制的字符串
			g.drawString(str, 10 + i * 20, 22);

			// 7.2 每生成一个 追加到验证码变量中
			code += str;
		}

		// 7 将验证码打印到控制台
		System.out.println(code);

		// 8 绘制干扰线
		for (int i = 0; i < 7; i++) {
			// 8.1 设置随机颜色
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		}

		// 2 将画布输出给浏览器显示
		ImageIO.write(bufi, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}